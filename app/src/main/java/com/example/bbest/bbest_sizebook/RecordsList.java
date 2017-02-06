package com.example.bbest.bbest_sizebook;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Observable;
import java.util.ArrayList;
/**
 * Records List class to hold all the current records of Person objects
 * Created by bbest on 01/02/17.
 */

public class RecordsList implements Serializable {

    protected ArrayList<Person> recordList = null;
     protected transient ArrayList<Listener> listeners = null;

    //Constructor for RecordsList
    public RecordsList(){
        recordList = new ArrayList<Person>();
        listeners = new ArrayList<Listener>();

    }


// gets all of the Person records
    public Collection<Person> getRecords(){

        return recordList;
    }

//adds a new person to the list
    public void addRecord(Person newPerson){

        recordList.add(newPerson);
        notifyListeners();

    }
    //gets all Listeners looking at the List
    private ArrayList<Listener> getListeners(){
        if(listeners == null){
            listeners = new ArrayList<Listener>();
        }
        return listeners;
    }
    //notifies any Listeners looking at the List that the List has been updated.
    public void notifyListeners() {
        for (Listener listener: getListeners()) {
            listener.update();
        }
    }


    //removes a Person from the list
    public void removePerson(Person p){
        recordList.remove(p);
        notifyListeners();

    }

//returns a Person object from the list, used for editing a specific Person object
    public Person getPerson(int i){
        return recordList.get(i);
    }
    
//size of list
    public int size(){
        return recordList.size();
    }
    
    //probably won't use
    public boolean contains(Person person){

        return recordList.contains(person);
    }
    
    //adds a Listener
    public void addListener(Listener l){

        getListeners().add(l);
    }
    //removes a Listener
    public void removeListener(Listener l){
        getListeners().remove(l);

    }

}
