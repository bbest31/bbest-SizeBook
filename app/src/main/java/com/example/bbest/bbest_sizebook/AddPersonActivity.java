package com.example.bbest.bbest_sizebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.bbest.bbest_sizebook.RecordsListController.getRecordsList;
//import static com.example.bbest.bbest_sizebook.RecordsListController.recordsList;

public class AddPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

    }

    /**
     * Grabs entered values from Entry views and creates new Person with those grabbed values.
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
        int necksize;
        if (neckString.trim().length() == 0) {
            necksize = 0;
        } else {
            necksize = Integer.parseInt(neckString);
        }

        EditText chesttextView = (EditText) findViewById(R.id.ChestSizeEntryView);
        String chestString = chesttextView.getText().toString();
        int chestsize;
        if (chestString.trim().length() == 0) {
            chestsize = 0;
        } else {
            chestsize = Integer.parseInt(chestString);
        }

        EditText busttextView = (EditText) findViewById(R.id.BustSizeEntryView);
        String bustString = busttextView.getText().toString();
        int bustsize;
        if (bustString.trim().length() == 0){
            bustsize = 0;
    }else{
        bustsize = Integer.parseInt(bustString);
    }
        EditText waisttextView = (EditText) findViewById(R.id.WaistSizeEntryView);
        String waistString = waisttextView.getText().toString();
        int waistsize;
        if(waistString.trim().length() == 0){
            waistsize = 0;
        } else {
            waistsize = Integer.parseInt(waistString);
        }

        EditText hiptextView = (EditText) findViewById(R.id.HipSizeEntryView);
        String hipString = hiptextView.getText().toString();
        int hipsize;
        if(hipString.trim().length() == 0){
            hipsize = 0;
        } else {
            hipsize = Integer.parseInt(hipString);
        }

        EditText inseamtextView = (EditText) findViewById(R.id.InseamLengthSizeEntryView);
        String inseamString = inseamtextView.getText().toString();
        int inseamlength;
        if(inseamString.trim().length() == 0){
            inseamlength = 0;
        } else {
            inseamlength = Integer.parseInt(inseamString);
        }
        EditText commenttextView = (EditText) findViewById(R.id.CommentEntryView);

        if(nametextView.getText().toString().trim().length() == 0){
            Toast.makeText(this, "Please provide a name!", Toast.LENGTH_LONG).show();

        }else {
            Person newPerson = new Person(nametextView.getText().toString(), necksize, chestsize, bustsize, waistsize, hipsize, inseamlength, commenttextView.getText().toString());
            Toast.makeText(this, "New Record made!", Toast.LENGTH_LONG).show();
            recordsListController.addPerson(newPerson);
            //update the current record count


            //need call to close activity and remove from activity stack
            finish();
        }
    }




}
