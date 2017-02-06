/*Records_List_Activity is the main screen of bbest-SizeBook, This diplays a ListView containing all the current records
*as well the current record count above the ListView. To add a record there is an Add button in the top right corner navigating to a 
*AddPersonActivity. To delete records I implemented a long click functionality and to view the record details a short click will 
*trigger a dialog box to appear showing the records details with an edit button to edit to record in the EditPersonActvity.

Sources: 
https://www.youtube.com/playlist?list=PL240uJOh_Vb4PtMZ0f7N8ACYkCLv0673O
Collaborator- Peter Weckend
http://www.mkyong.com/java/how-to-convert-string-to-date-java/

*/
package com.example.bbest.bbest_sizebook;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

//import static com.example.bbest.bbest_sizebook.RecordsListController.recordsList;

public class Records_List_Activity extends AppCompatActivity /*implements AdapterView.OnItemClickListener*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button AddPersonButton;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records__list);
        RecordsListManager.initManager(this.getApplicationContext());
//Filling ListView with appropriate Views and Collection of Persons
        ListView listView = (ListView) findViewById(R.id.RecordsListView);
        Collection<Person> persons = RecordsListController.getRecordsList().getRecords();
        final ArrayList list = new ArrayList<Person>(persons);
        final ArrayAdapter<Person> personArrayAdapter = new ArrayAdapter<Person>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(personArrayAdapter);
        recordCount();
        //Adds Listeners to the Collection
        RecordsListController.getRecordsList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                Collection<Person> persons = RecordsListController.getRecordsList().getRecords();
                list.addAll(persons);
                recordCount();
                personArrayAdapter.notifyDataSetChanged();
            }
        });
        
        //AddPersonButton onClick function to induce AddPersonActivity
        AddPersonButton = (Button) findViewById(R.id.AddRecordButton);
        AddPersonButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Records_List_Activity.this,AddPersonActivity.class);
                startActivity(intent);
            }
        });
        
        //View Records Details Action
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(Records_List_Activity.this);
                Person person = (Person)list.get(position);
                Date date = person.getDate();
                SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
                try {
                    date = format.parse(date.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                adb.setMessage(person.getPersonName()+"\n"+"Neck Size: "+ person.getNeckSize()+"   Chest Size: "+person.getChestSize()+"\n"+"Bust Size: "
                +person.getBustSize()+"   Waist Size: "+person.getWaistSize()+"\n"+"Hip Size: "+person.getHipSize()+"   Inseam Length: "+person.getInseamLength()+"\n"+"Date: "+format.format(date)+"\n"+
                person.getComment());

                final int Finalposition = position;
                //Edit Button induces EditPersonActivity and passes necessary parameters using Intent.putExtra()
                adb.setPositiveButton("Edit", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Person person = (Person) list.get(Finalposition);
                        Intent intent = new Intent(Records_List_Activity.this, EditPersonActivity.class);
                        intent.putExtra("list",list);
                        intent.putExtra("position", position);
                        startActivity(intent);
                    }
                });
                adb.show();
            }
        });
        
        //Long click functionality for deleting records
        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(Records_List_Activity.this, "Deleted "+list.get(position),Toast.LENGTH_LONG).show();
                AlertDialog.Builder adb = new AlertDialog.Builder(Records_List_Activity.this);
                adb.setMessage("Delete "+list.get(position).toString()+"?");
                adb.setCancelable(true);
                final int finalPosition = position;
                adb.setPositiveButton("Delete", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Person person = (Person) list.get(finalPosition);
                        RecordsListController.getRecordsList().removePerson(person);
                    }
                });
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                adb.show();
                return true;
            }
        });
    }

//Methood used to update the current record count
    public void recordCount(){
        RecordsListController recordsListController = new RecordsListController();
        int size = recordsListController.getRecordsList().size();
        Integer sizeIntegerObject = ((Integer) size);
        TextView view = (TextView) findViewById(R.id.CurrentRecordsNumberView);
        view.setText((sizeIntegerObject.toString()));
    }


}
