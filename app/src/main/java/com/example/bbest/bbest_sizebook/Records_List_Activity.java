package com.example.bbest.bbest_sizebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Observer;

public class Records_List_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button AddPersonButton;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records__list);
        AddPersonButton = (Button) findViewById(R.id.AddRecordButton);
        AddPersonButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getBaseContext(),"Clicked on Add button", Toast.LENGTH_LONG).show();
            }
        });
    }

    //onClick method for AddButton to go to Add com.example.bbest.bbest_sizebook.Person Activity
    public void addPerson(View v){


    }

}
