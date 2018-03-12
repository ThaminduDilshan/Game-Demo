package gamedemo;

/**
 *
 * @author THAMINDU
 */
public class LotusFlower {

    private int petals;
    private int[] position;   //set position(y,x) in a list

    public LotusFlower() {
        petals = 100;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int[] getPosition() {
        return position;
    }

    public void loosePetals() {     //eat a petal by a warrior
        setPetals(getPetals() - 1);
    }

    public int getPetals() {
        return petals;
    }

    public void setPetals(int petals) {
        this.petals = petals;
    }

}