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

import static com.example.bbest.bbest_sizebook.RecordsListController.recordsList;

public class Records_List_Activity extends AppCompatActivity /*implements AdapterView.OnItemClickListener*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button AddPersonButton;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records__list);

        ListView listView = (ListView) findViewById(R.id.RecordsListView);
        Collection<Person> persons = RecordsListController.getRecordsList().getRecords();
        ArrayList<Person> list = new ArrayList<Person>(persons);
        ArrayAdapter<Person> personArrayAdapter = new ArrayAdapter<Person>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(personArrayAdapter);



        AddPersonButton = (Button) findViewById(R.id.AddRecordButton);
        AddPersonButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(getBaseContext(),"Clicked on Add button", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Records_List_Activity.this,AddPersonActivity.class);
                startActivity(intent);
            }
        });

    }




    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }*/

}
