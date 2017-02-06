package com.example.bbest.bbest_sizebook;
/** Person class used to store physical measurements of Person and possible comments
 * Person class is a model for this application storing all of the data.
 * Created by bbest on 24/01/17.
 */
import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

public class Person implements Serializable {

    //private int sizes for Person class measurements
    private String personName;
    private Float neckSize;
    private Float bustSize;
    private Float chestSize;
    private Float waistSize;
    private Float hipSize;
    private Float inseamLength;
    private String comment;
    private Date date;

    //Person constructor
    public Person(String personName, Float neckSize, Float chestSize, Float bustSize, Float waistSize, Float hipSize, Float inseamLength, String comment, Date date){

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
    public Float getNeckSize() {
        return neckSize;
    }

    public void setNeckSize(Float neckSize) {

        this.neckSize = neckSize;


    }

//Bust Size methods
    public Float getBustSize() {
        return bustSize;
    }

    public void setBustSize(Float bustSize) {

        this.bustSize = bustSize;


    }

//Chest Size methods
    public Float getChestSize() {
        return chestSize;
    }

    public void setChestSize(Float chestSize) {

        this.chestSize = chestSize;


    }

//Waist Size methods
    public Float getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(Float waistSize) {

        this.waistSize = waistSize;


    }

//Hip Size methods
    public Float getHipSize() {
        return hipSize;
    }

    public void setHipSize(Float hipSize) {

        this.hipSize = hipSize;


    }

// Inseam Length methods
    public Float getInseamLength() {
        return inseamLength;
    }

    public void setInseamLength(Float inseamLength) {

        this.inseamLength = inseamLength;


    }

//Comments methods
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {

        this.comment = comment;


    }
//Date methods
    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }
}
