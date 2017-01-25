/** Person class used to store physical measurements of said Person and possible comments
 * Created by bbest on 24/01/17.
 */

public class Person {
    //private int sizes for Person class measurements
    private char personName;
    private int neckSize;
    private int bustSize;
    private int chestSize;
    private int waistSize;
    private int hipSize;
    private int inseamLength;
    private char comment;

    //Person constructor
    public Person(){

    }

    public char getPersonName() {
        return personName;
    }

    public void setPersonName(char personName) {
        this.personName = personName;
    }

    public int getNeckSize() {
        return neckSize;
    }

    public void setNeckSize(int neckSize) {
        this.neckSize = neckSize;
    }

    public int getBustSize() {
        return bustSize;
    }

    public void setBustSize(int bustSize) {
        this.bustSize = bustSize;
    }

    public int getChestSize() {
        return chestSize;
    }

    public void setChestSize(int chestSize) {
        this.chestSize = chestSize;
    }

    public int getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(int waistSize) {
        this.waistSize = waistSize;
    }

    public int getHipSize() {
        return hipSize;
    }

    public void setHipSize(int hipSize) {
        this.hipSize = hipSize;
    }

    public int getInseamLength() {
        return inseamLength;
    }

    public void setInseamLength(int inseamLength) {
        this.inseamLength = inseamLength;
    }

    public char getComment() {
        return comment;
    }

    public void setComment(char comment) {
        this.comment = comment;
    }
}
