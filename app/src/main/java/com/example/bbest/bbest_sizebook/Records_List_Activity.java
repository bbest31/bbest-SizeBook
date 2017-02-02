package com.example.bbest.bbest_sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.bbest.bbest_sizebook.RecordsListController.recordsList;

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
                Intent intent = new Intent(Records_List_Activity.this,AddPersonActivity.class);
                startActivity(intent);
            }
        });
    }

    //onClick method for AddButton to go to AddPerson Activity
    public void addPerson(View v){


    }

    public void recordCount(){
        int size = recordsList.size();
        TextView view = (TextView) findViewById(R.id.CurrentRecordsNumberView);
        view.setText(size);
    }

}
