package com.example.bbest.bbest_sizebook;
import java.util.Collection;
import java.util.Observable;
import java.util.ArrayList;
/**
 * Records List class to hold all the current records of com.example.bbest.bbest_sizebook.Person objects
 * Created by bbest on 01/02/17.
 */

public class RecordsList extends Observable {

    protected ArrayList<Person> recordList;

    //Constructor for RecordsList
    public RecordsList(){
        RecordsList recordsList = new RecordsList();

    }

    public Collection<Person> getPersons(){

        return recordList;
    }

    public void addRecord(Person newPerson){

        recordList.add(newPerson);
    }

    public void removePerson(Person p){
        recordList.remove(p);
        
    }

}
