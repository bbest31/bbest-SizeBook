package com.example.bbest.bbest_sizebook;

import android.widget.TextView;


/**
 * Created by bbest on 02/02/17.
 */
//Singleton
public class RecordsListController {
    public static RecordsList recordsList = null;
    static public RecordsList getRecordsList(){
        if (recordsList == null){
            recordsList = new RecordsList();
        }
        return recordsList;
    }

    public void addPerson(Person newPerson){

        recordsList.addRecord(newPerson);
    }

}
