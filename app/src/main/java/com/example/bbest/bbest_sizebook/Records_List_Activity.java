package com.example.bbest.bbest_sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

//import static com.example.bbest.bbest_sizebook.RecordsListController.recordsList;

public class Records_List_Activity extends AppCompatActivity /*implements AdapterView.OnItemClickListener*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button AddPersonButton;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records__list);

        ListView listView = (ListView) findViewById(R.id.RecordsListView);
        Collection<Person> persons = RecordsListController.getRecordsList().getRecords();
        final ArrayList list = new ArrayList<Person>(persons);
        final ArrayAdapter<Person> personArrayAdapter = new ArrayAdapter<Person>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(personArrayAdapter);

        RecordsListController.getRecordsList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                Collection<Person> persons = RecordsListController.getRecordsList().getRecords();
                list.addAll(persons);
                personArrayAdapter.notifyDataSetChanged();

            }
        });

        AddPersonButton = (Button) findViewById(R.id.AddRecordButton);
        AddPersonButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(getBaseContext(),"Clicked on Add button", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Records_List_Activity.this,AddPersonActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Person person = (Person) list.get(position);
                RecordsListController.getRecordsList().removePerson(person);
             //   Toast.makeText(Records_List_Activity.this, "Deleted "+list.get(position),Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }


    protected void onResume(){
        super.onResume();

        ListView listView = (ListView) findViewById(R.id.RecordsListView);
        Collection<Person> persons = RecordsListController.getRecordsList().getRecords();
        final ArrayList list = new ArrayList<Person>(persons);
        ArrayAdapter<Person> personArrayAdapter = new ArrayAdapter<Person>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(personArrayAdapter);

        recordCount();
    }
    public void recordCount(){
        //RecordsList recordList = getRecordsList();
        RecordsListController recordsListController = new RecordsListController();
        int size = recordsListController.getRecordsList().size();
        Integer sizeIntegerObject = ((Integer) size);
        TextView view = (TextView) findViewById(R.id.CurrentRecordsNumberView);
        view.setText((sizeIntegerObject.toString()));
    }
    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }*/

}
