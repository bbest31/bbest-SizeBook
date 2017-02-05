package com.example.bbest.bbest_sizebook;

import android.widget.TextView;


/**
 * Created by bbest on 02/02/17.
 */
//Singleton
public class RecordsListController {
    private static RecordsList recordsList = null;
    static public RecordsList getRecordsList(){
        if (recordsList == null){
            recordsList = new RecordsList();
        }
        return recordsList;
    }

    public void addPerson(Person newPerson){

        getRecordsList().addRecord(newPerson);
    }
     public void removePerson(Person p){
         getRecordsList().removePerson(p);
     }

    public void getPerson(int i){
        getRecordsList().getPerson(i);
    }
}
