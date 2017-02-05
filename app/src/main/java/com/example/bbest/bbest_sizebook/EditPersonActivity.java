package com.example.bbest.bbest_sizebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Observer;

public class EditPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person);
        //needs to grab person info and populate entry views
    }

    public void EditRecord(View v) {
        // Toast.makeText(this, "Submiting new record", Toast.LENGTH_LONG).show();
        RecordsListController recordsListController = new RecordsListController();

        EditText nametextView = (EditText) findViewById(R.id.EditNameTextEntry);


        EditText necktextView = (EditText) findViewById(R.id.EditNeckSizeEntryView);
        String neckString = necktextView.getText().toString();
        int necksize;
        if (neckString.trim().length() == 0) {
            necksize = 0;
        } else {
            necksize = Integer.parseInt(neckString);
        }

        EditText chesttextView = (EditText) findViewById(R.id.EditChestEntryView);
        String chestString = chesttextView.getText().toString();
        int chestsize;
        if (chestString.trim().length() == 0) {
            chestsize = 0;
        } else {
            chestsize = Integer.parseInt(chestString);
        }

        EditText busttextView = (EditText) findViewById(R.id.EditBustEntryView);
        String bustString = busttextView.getText().toString();
        int bustsize;
        if (bustString.trim().length() == 0){
            bustsize = 0;
        }else{
            bustsize = Integer.parseInt(bustString);
        }
        EditText waisttextView = (EditText) findViewById(R.id.EditWaistEntryView);
        String waistString = waisttextView.getText().toString();
        int waistsize;
        if(waistString.trim().length() == 0){
            waistsize = 0;
        } else {
            waistsize = Integer.parseInt(waistString);
        }

        EditText hiptextView = (EditText) findViewById(R.id.EditHipEntryView);
        String hipString = hiptextView.getText().toString();
        int hipsize;
        if(hipString.trim().length() == 0){
            hipsize = 0;
        } else {
            hipsize = Integer.parseInt(hipString);
        }

        EditText inseamtextView = (EditText) findViewById(R.id.EditInseamEntryView);
        String inseamString = inseamtextView.getText().toString();
        int inseamlength;
        if(inseamString.trim().length() == 0){
            inseamlength = 0;
        } else {
            inseamlength = Integer.parseInt(inseamString);
        }
        EditText commenttextView = (EditText) findViewById(R.id.EditCommentEntryView);

        if(nametextView.getText().toString().trim().length() == 0){
            Toast.makeText(this, "Please provide a name!", Toast.LENGTH_LONG).show();

        }else {

            //use setter methods for person to change attribute values.

            Toast.makeText(this, "Record edited!", Toast.LENGTH_LONG).show();

            //need call to close activity and remove from activity stack
            finish();
        }
    }




}

