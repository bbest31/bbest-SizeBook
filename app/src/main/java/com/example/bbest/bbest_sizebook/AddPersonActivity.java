package com.example.bbest.bbest_sizebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

    }

    public void submitNewRecord(View v){
        Toast.makeText(this, "Submiting new record", Toast.LENGTH_LONG).show();
        RecordsListController recordsListController = new RecordsListController();

        EditText nametextView = (EditText) findViewById(R.id.PersonNameTextEntry);
        EditText necktextView = (EditText) findViewById(R.id.NeckSizeEntryView);
        int necksize = Integer.parseInt(necktextView.toString());
        EditText chesttextView = (EditText) findViewById(R.id.ChestSizeEntryView);
        int chestsize = Integer.parseInt(chesttextView.toString());
        EditText busttextView = (EditText) findViewById(R.id.BustSizeEntryView);
        int bustsize = Integer.parseInt(busttextView.toString());
        EditText waisttextView = (EditText) findViewById(R.id.WaistSizeEntryView);
        int waistsize = Integer.parseInt(waisttextView.toString());
        EditText hiptextView = (EditText) findViewById(R.id.HipSizeEntryView);
        int hipsize = Integer.parseInt(hiptextView.toString());
        EditText inseamtextView = (EditText) findViewById(R.id.InseamLengthSizeEntryView);
        int inseamlength = Integer.parseInt(inseamtextView.toString());
        EditText commenttextView = (EditText) findViewById(R.id.CommentEntryView);

        recordsListController.addPerson(new Person(nametextView.getText().toString(), necksize,chestsize, bustsize, waistsize,hipsize,inseamlength, commenttextView.getText().toString()));
        //need call to close activity and remove from activity stack
        //recordCount();
        finish();
    }
}
