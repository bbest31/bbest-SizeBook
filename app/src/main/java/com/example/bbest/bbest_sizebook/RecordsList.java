package com.example.bbest.bbest_sizebook;
import java.util.Collection;
import java.util.Observable;
import java.util.ArrayList;
/**
 * Records List class to hold all the current records of Person objects
 * Created by bbest on 01/02/17.
 */

public class RecordsList extends Observable {

    protected ArrayList<Person> recordList;

    //Constructor for RecordsList
    public RecordsList(){
        RecordsList recordsList = new RecordsList();

    }

// gets all of the Person records
    public Collection<Person> getRecords(){

        return recordList;
    }

//adds a new peron to the list
    public void addRecord(Person newPerson){

        recordList.add(newPerson);
    }

//removes a Person from the list
    public void removePerson(Person p){
        recordList.remove(p);

    }

//returns a Person object from the list, used for editing a specific Person object
    public Person getPerson(int i){

        return recordList.get(i);
    }

    public int size(){
        return recordList.size();
    }

    public boolean contains(Person person){
        return recordList.contains(person);
    }
}
