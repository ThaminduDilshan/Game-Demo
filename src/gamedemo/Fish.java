package gamedemo;

/**
 *
 * @author THAMINDU
 */
public abstract class Fish implements Inhabitant,Runnable {

    private String name;
    int[] position;   //set position(y,x) in a list
    
    public Fish(String name) {
        this.name=name;
    }
    
    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}