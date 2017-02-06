/*Outstanding Problem: Can't edit the Date attribute due to a NullPointerException being thrown from line 141
The date is just kept as original instead. Also name edits do not show up in the ListView but if the record is viewed the changes are shown.
editPerson Activity populates the EntryViews with the current Person's attribute values and then once the EditButton is clicked
it grabs the new values and assigns them to the same Person object using the setter methods.

 */

package com.example.bbest.bbest_sizebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class EditPersonActivity extends AppCompatActivity {
    private int position;
    private ArrayList<Person> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person);
        RecordsListManager.initManager(this.getApplicationContext());


        //needs to grab person info and populate entry views
        list = (ArrayList<Person>)getIntent().getSerializableExtra("list");
        position = getIntent().getIntExtra("position",0);
        Person person = list.get(position);
        EditText nametextView = (EditText) findViewById(R.id.EditNameTextEntry);
        nametextView.setText(person.getPersonName());

        EditText necktextView = (EditText) findViewById(R.id.EditNeckSizeEntryView);
        necktextView.setText(Float.toString(person.getNeckSize()));

        EditText chesttextView = (EditText) findViewById(R.id.EditChestEntryView);
        chesttextView.setText(Float.toString(person.getChestSize()));


        EditText busttextView = (EditText) findViewById(R.id.EditBustEntryView);
        busttextView.setText(Float.toString(person.getBustSize()));

        EditText waisttextView = (EditText) findViewById(R.id.EditWaistEntryView);
        waisttextView.setText(Float.toString(person.getWaistSize()));

        EditText hiptextView = (EditText) findViewById(R.id.EditHipEntryView);
        hiptextView.setText(Float.toString(person.getHipSize()));

        EditText inseamtextView = (EditText) findViewById(R.id.EditInseamEntryView);
        inseamtextView.setText(Float.toString(person.getInseamLength()));


        EditText commenttextView = (EditText) findViewById(R.id.EditCommentEntryView);
        commenttextView.setText(person.getComment());

        Date date = person.getDate();
        EditText datetextview = (EditText) findViewById(R.id.EditDateEntryView);
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        try {
            date = format.parse(datetextview.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        datetextview.setText(format.format(date));

    }
//Grabs new values
    public void EditRecord(View v) {
        Person person = list.get(position);
        // Toast.makeText(this, "Submiting new record", Toast.LENGTH_LONG).show();
        RecordsListController recordsListController = new RecordsListController();

        EditText nametextView = (EditText) findViewById(R.id.EditNameTextEntry);

        EditText necktextView = (EditText) findViewById(R.id.EditNeckSizeEntryView);
        String neckString = necktextView.getText().toString();
        float necksize;
        if (neckString.trim().length() == 0) {
            necksize = 0;
        } else {
            necksize = Float.valueOf(neckString);
            necksize = (float) (Math.round(necksize *2)/2.0);
        }

        EditText chesttextView = (EditText) findViewById(R.id.EditChestEntryView);
        String chestString = chesttextView.getText().toString();
        float chestsize;
        if (chestString.trim().length() == 0) {
            chestsize = 0;
        } else {
            chestsize = Float.valueOf(chestString);
            chestsize = (float) (Math.round(chestsize * 2)/ 2.0);
        }

        EditText busttextView = (EditText) findViewById(R.id.EditBustEntryView);
        String bustString = busttextView.getText().toString();
        float bustsize;
        if (bustString.trim().length() == 0){
            bustsize = 0;
        }else{
            bustsize = Float.valueOf(bustString);
            bustsize = (float) (Math.round(bustsize * 2)/ 2.0);
        }

        EditText waisttextView = (EditText) findViewById(R.id.EditWaistEntryView);
        String waistString = waisttextView.getText().toString();
        float waistsize;
        if(waistString.trim().length() == 0){
            waistsize = 0;
        } else {
            waistsize = Float.valueOf(waistString);
            waistsize = (float) (Math.round(waistsize * 2)/ 2.0);
        }

        EditText hiptextView = (EditText) findViewById(R.id.EditHipEntryView);
        String hipString = hiptextView.getText().toString();
        float hipsize;
        if(hipString.trim().length() == 0){
            hipsize = 0;
        } else {
            hipsize = Float.valueOf(hipString);
            hipsize = (float) (Math.round(hipsize * 2)/ 2.0);
        }

        EditText inseamtextView = (EditText) findViewById(R.id.EditInseamEntryView);
        String inseamString = inseamtextView.getText().toString();
        float inseamlength;
        if(inseamString.trim().length() == 0){
            inseamlength = 0;
        } else {
            inseamlength = Float.valueOf(inseamString);
            inseamlength = (float) (Math.round(inseamlength * 2)/ 2.0);
        }

        EditText commenttextView = (EditText) findViewById(R.id.EditCommentEntryView);
        EditText datetextview = (EditText) findViewById(R.id.DateEntryView);

       // Date date = new Date();
//        String dateString = datetextview.getText().toString();
//        if(dateString.trim().length() == 0){
//
//        }else{
//            String dateInString = datetextview.getText().toString();
//            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
//            try {
//                date = format.parse(dateInString);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }

        if(nametextView.getText().toString().trim().length() == 0){
            Toast.makeText(this, "Please provide a name!", Toast.LENGTH_LONG).show();

        }else {
            String name =nametextView.getText().toString();
            String comment = commenttextView.getText().toString();
            //calls Controller to edit the Record.
            RecordsListController.editRecord(position,name,necksize,chestsize,bustsize,waistsize,hipsize,inseamlength,comment,person.getDate());
            Toast.makeText(this, "Record edited!", Toast.LENGTH_LONG).show();

            //need call to close activity and remove from activity stack
            finish();
        }
    }




}

