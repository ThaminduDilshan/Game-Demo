package gamedemo;
/**
 *
 * @author THAMINDU
 */
public interface Inhabitant {              //common class for all inhabitant characters
    
    public int[] getPosition();
    public void setPosition(int[] position);
    public void setName(String name);
    public String getName();
    
}