package com.example.bbest.bbest_sizebook; /** com.example.bbest.bbest_sizebook.Person class used to store physical measurements of said com.example.bbest.bbest_sizebook.Person and possible comments
 * com.example.bbest.bbest_sizebook.Person class is the model for this application storing all of the data.
 * Created by bbest on 24/01/17.
 */
import java.util.Observable;

public class Person extends Observable {

    //private int sizes for com.example.bbest.bbest_sizebook.Person class measurements
    private String personName;
    private int neckSize;
    private int bustSize;
    private int chestSize;
    private int waistSize;
    private int hipSize;
    private int inseamLength;
    private String comment;

    //Person constructor
    public Person(String personName, int neckSize, int chestSize, int bustSize, int waistSize, int hipSize, int inseamLength, String comment){

    //Person person = new Person();
        this.setPersonName(personName);
        this.setNeckSize(neckSize);
        this.setChestSize(chestSize);
        this.setBustSize(bustSize);
        this.setWaistSize(waistSize);
        this.setHipSize(hipSize);
        this.setInseamLength(inseamLength);
        this.setComment(comment);

    }

    //Getter and Setter methods for measurements
    //name methods
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {

        this.personName = personName;
        setChanged();
        notifyObservers();
    }

//Neck Size methods
    public int getNeckSize() {
        return neckSize;
    }

    public void setNeckSize(int neckSize) {

        this.neckSize = neckSize;
        setChanged();
        notifyObservers();
    }

//Bust Size methdos
    public int getBustSize() {
        return bustSize;
    }

    public void setBustSize(int bustSize) {

        this.bustSize = bustSize;
        setChanged();
        notifyObservers();
    }

//Chest Size methods
    public int getChestSize() {
        return chestSize;
    }

    public void setChestSize(int chestSize) {

        this.chestSize = chestSize;
        setChanged();
        notifyObservers();
    }

//Waist Size methods
    public int getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(int waistSize) {

        this.waistSize = waistSize;
        setChanged();
        notifyObservers();
    }

//Hip Size methods
    public int getHipSize() {
        return hipSize;
    }

    public void setHipSize(int hipSize) {

        this.hipSize = hipSize;
        setChanged();
        notifyObservers();
    }

// Inseam Length methods
    public int getInseamLength() {
        return inseamLength;
    }

    public void setInseamLength(int inseamLength) {

        this.inseamLength = inseamLength;
        setChanged();
        notifyObservers();
    }

//Comments methods
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {

        this.comment = comment;
        setChanged();
        notifyObservers();
    }
}
