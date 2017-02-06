package com.example.bbest.bbest_sizebook;

import android.widget.TextView;

import java.io.IOException;
import java.util.Date;


/**RecordsListController handles the changing the of RecordsList and managing the Listeners for the list.
 * Created by bbest on 02/02/17.
 */
//Singleton
public class RecordsListController {


    private static RecordsList recordsList = null;
    //Constructor
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
    
//saves the list
  static  public void saveRecordsList(){
        try {
            RecordsListManager.getManager().saveRecordsList(getRecordsList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not deserialize RecordsList from RecordsListManager.");
        }
    }

    //Gets the list and adds a Person using the RecordsList method .addRecord()
    public void addPerson(Person newPerson){

        getRecordsList().addRecord(newPerson);
    }
  
    //This function edits an existing record so the view update properly
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
    //gets a person in the list by index
    public void getPerson(int i){
        getRecordsList().getPerson(i);
    }
}
