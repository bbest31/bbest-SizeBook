package com.example.bbest.bbest_sizebook;

import android.icu.text.DateTimePatternGenerator;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.example.bbest.bbest_sizebook.RecordsListController.getRecordsList;

/**
 * This activity is used to add a person record to the RecordList via the RecordListController which calls on the RecordListManager
 * The Person parameters are grabbed from the Edit Text entry views and converted into the necessary attribute types.
 */
public class AddPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        RecordsListManager.initManager(this.getApplicationContext());

    }

    /**
     * Grabs entered values from Entry views and creates new Person with those grabbed values.
     * if entry views are empty it defaults them to zero, and all the float values are rounded to the nearest half.
     * Control then takes this newPerson and adds it to the recordsList.
     * Then uses finish() to kill the activity.
     * @param v - Submit Button View on AddPerson Activity is taken in
     */
    public void submitNewRecord(View v) {
        // Toast.makeText(this, "Submiting new record", Toast.LENGTH_LONG).show();
        RecordsListController recordsListController = new RecordsListController();

        EditText nametextView = (EditText) findViewById(R.id.PersonNameTextEntry);


        EditText necktextView = (EditText) findViewById(R.id.NeckSizeEntryView);
        String neckString = necktextView.getText().toString();
        float necksize;
        if (neckString.trim().length() == 0) {
            necksize = 0;
        } else {
            necksize = Float.valueOf(neckString);
            necksize = (float) (Math.round(necksize *2)/2.0);
        }

        EditText chesttextView = (EditText) findViewById(R.id.ChestSizeEntryView);
        String chestString = chesttextView.getText().toString();
        float chestsize;
        if (chestString.trim().length() == 0) {
            chestsize = 0;
        } else {
            chestsize = Float.valueOf(chestString);
            chestsize = (float) (Math.round(chestsize * 2)/ 2.0);
        }

        EditText busttextView = (EditText) findViewById(R.id.BustSizeEntryView);
        String bustString = busttextView.getText().toString();
        float bustsize;
        if (bustString.trim().length() == 0){
            bustsize = 0;
    }else{
            bustsize = Float.valueOf(bustString);
            bustsize = (float) (Math.round(bustsize * 2)/ 2.0);
    }
        EditText waisttextView = (EditText) findViewById(R.id.WaistSizeEntryView);
        String waistString = waisttextView.getText().toString();
        float waistsize;
        if(waistString.trim().length() == 0){
            waistsize = 0;
        } else {
            waistsize = Float.valueOf(waistString);
            waistsize = (float) (Math.round(waistsize * 2)/ 2.0);        }

        EditText hiptextView = (EditText) findViewById(R.id.HipSizeEntryView);
        String hipString = hiptextView.getText().toString();
        float hipsize;
        if(hipString.trim().length() == 0){
            hipsize = 0;
        } else {
            hipsize = Float.valueOf(hipString);
            hipsize = (float) (Math.round(hipsize * 2)/ 2.0);        }

        EditText inseamtextView = (EditText) findViewById(R.id.InseamLengthSizeEntryView);
        String inseamString = inseamtextView.getText().toString();
        float inseamlength;
        if(inseamString.trim().length() == 0){
            inseamlength = 0;
        } else {
            inseamlength = Float.valueOf(inseamString);
            inseamlength = (float) (Math.round(inseamlength * 2)/ 2.0);        }


        EditText commenttextView = (EditText) findViewById(R.id.CommentEntryView);
        EditText datetextview = (EditText) findViewById(R.id.DateEntryView);

        Date date = new Date();
        if(datetextview.getText().toString().trim().length() == 0){

        }else{
            String dateInString = datetextview.getText().toString();
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
            try {
                 date = format.parse(dateInString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if(nametextView.getText().toString().trim().length() == 0){
            Toast.makeText(this, "Please provide a name!", Toast.LENGTH_LONG).show();

        }else {

            Person newPerson = new Person(nametextView.getText().toString(), necksize, chestsize, bustsize, waistsize, hipsize, inseamlength, commenttextView.getText().toString(),date);
            Toast.makeText(this, "New Record made!", Toast.LENGTH_LONG).show();
            recordsListController.addPerson(newPerson);


            //need call to close activity and remove from activity stack
            finish();
        }
    }




}
