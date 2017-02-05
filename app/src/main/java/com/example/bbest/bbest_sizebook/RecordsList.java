package com.example.bbest.bbest_sizebook;
import java.io.Serializable;
import java.util.Collection;
import java.util.Observable;
import java.util.ArrayList;
/**
 * Records List class to hold all the current records of Person objects
 * Created by bbest on 01/02/17.
 */

public class RecordsList implements Serializable {

    protected ArrayList<Person> recordList;
    protected ArrayList<Listener> listeners;

    //Constructor for RecordsList
    public RecordsList(){
        recordList = new ArrayList<Person>();
        listeners = new ArrayList<Listener>();

    }
//
//    private ArrayList<Listener> getListeners(){
//        if(listeners == null){
//            listeners = new ArrayList<Listener>();
//        }
//        return listeners;
//    }
// gets all of the Person records
    public Collection<Person> getRecords(){

        return recordList;
    }

//adds a new person to the list
    public void addRecord(Person newPerson){

        recordList.add(newPerson);
        notifyListeners();

    }

    public void notifyListeners() {
        for (Listener listerner: listeners) {
            listerner.update();
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

    public int size(){
        return recordList.size();
    }

    public boolean contains(Person person){

        return recordList.contains(person);
    }

    public void addListener(Listener l){
        listeners.add(l);
    }
    public void removeListener(Listener l){
        listeners.remove(l);

    }

}
