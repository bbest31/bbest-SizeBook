package com.example.bbest.bbest_sizebook;

import android.widget.TextView;

import java.io.IOException;
import java.util.Date;


/**
 * Created by bbest on 02/02/17.
 */
//Singleton
public class RecordsListController {


    private static RecordsList recordsList = null;

    static public RecordsList getRecordsList(){

        if(recordsList == null){
            try {
        recordsList = RecordsListManager.getManager().loadRecordsList();
        recordsList.addListener(new Listener() {
            @Override
            public void update() {
                saveRecordsList();
            }
        });
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not deserialize RecordsList from RecordsListManager.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not deserialize RecordsList from RecordsListManager.");

            }
        }
        return recordsList;
    }

  static  public void saveRecordsList(){
        try {
            RecordsListManager.getManager().saveRecordsList(getRecordsList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not deserialize RecordsList from RecordsListManager.");
        }
    }


    public void addPerson(Person newPerson){

        getRecordsList().addRecord(newPerson);
    }
    // public void removePerson(Person p){
    //     getRecordsList().removePerson(p);
   //  }
    static public void editRecord(int i,String name,int necksize,int chestsize, int bustsize,int waistsize, int hipsize, int inseamlength, String comment, Date date){
        Person person = getRecordsList().getPerson(i);
        person.setPersonName(name);
        person.setNeckSize(necksize);
        person.setChestSize(chestsize);
        person.setBustSize(bustsize);
        person.setWaistSize(waistsize);
        person.setHipSize(hipsize);
        person.setInseamLength(inseamlength);
        person.setComment(comment);
        person.setDate(date);
    }
    public void getPerson(int i){
        getRecordsList().getPerson(i);
    }
}
