package com.example.bbest.bbest_sizebook; /** Person class used to store physical measurements of Person and possible comments
 * Person class is a model for this application storing all of the data.
 * Created by bbest on 24/01/17.
 */
import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

public class Person implements Serializable {

    //private int sizes for com.example.bbest.bbest_sizebook.Person class measurements
    private String personName;
    private int neckSize;
    private int bustSize;
    private int chestSize;
    private int waistSize;
    private int hipSize;
    private int inseamLength;
    private String comment;
    private Date date;

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
        this.setDate(date);

    }

    //Getter and Setter methods for measurements
    //name methods
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {

        this.personName = personName;

    }
    public String toString(){

        return getPersonName();
    }
//Neck Size methods
    public int getNeckSize() {
        return neckSize;
    }

    public void setNeckSize(int neckSize) {

        this.neckSize = neckSize;


    }

//Bust Size methdos
    public int getBustSize() {
        return bustSize;
    }

    public void setBustSize(int bustSize) {

        this.bustSize = bustSize;


    }

//Chest Size methods
    public int getChestSize() {
        return chestSize;
    }

    public void setChestSize(int chestSize) {

        this.chestSize = chestSize;


    }

//Waist Size methods
    public int getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(int waistSize) {

        this.waistSize = waistSize;


    }

//Hip Size methods
    public int getHipSize() {
        return hipSize;
    }

    public void setHipSize(int hipSize) {

        this.hipSize = hipSize;


    }

// Inseam Length methods
    public int getInseamLength() {
        return inseamLength;
    }

    public void setInseamLength(int inseamLength) {

        this.inseamLength = inseamLength;


    }

//Comments methods
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {

        this.comment = comment;


    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
