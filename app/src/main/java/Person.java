/** Person class used to store physical measurements of said Person and possible comments
 * Person class is the model for this application storing all of the data.
 * Created by bbest on 24/01/17.
 */
import java.util.Observable;

public class Person extends Observable {
    //private int sizes for Person class measurements
    private String personName;
    private float neckSize;
    private float bustSize;
    private float chestSize;
    private float waistSize;
    private float hipSize;
    private float inseamLength;
    private String comment;

    //Person constructor
    public Person(){

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
    public float getNeckSize() {
        return neckSize;
    }

    public void setNeckSize(float neckSize) {

        this.neckSize = neckSize;
        setChanged();
        notifyObservers();
    }

//Bust Size methdos
    public float getBustSize() {
        return bustSize;
    }

    public void setBustSize(float bustSize) {

        this.bustSize = bustSize;
        setChanged();
        notifyObservers();
    }

//Chest Size methods
    public float getChestSize() {
        return chestSize;
    }

    public void setChestSize(float chestSize) {

        this.chestSize = chestSize;
        setChanged();
        notifyObservers();
    }

//Waist Size methods
    public float getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(float waistSize) {

        this.waistSize = waistSize;
        setChanged();
        notifyObservers();
    }

//Hip Size methods
    public float getHipSize() {
        return hipSize;
    }

    public void setHipSize(float hipSize) {

        this.hipSize = hipSize;
        setChanged();
        notifyObservers();
    }

// Inseam Length methods
    public float getInseamLength() {
        return inseamLength;
    }

    public void setInseamLength(float inseamLength) {

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
