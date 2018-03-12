package gamedemo;
import java.util.*;

/**
 *
 * @author THAMINDU
 */
public class KillerFish extends Fish implements Observer{
    public KillerFish(String name) {
        super(name);
    }
    
    @Override
    public void run(){
        
    }
    public synchronized void update(Observable e, Object arg){
        kill( (Warrior)arg );
    }

    public void kill(Warrior w) {  //kill a warrior
        if (w.getPosition()[0] == position[0] && w.getPosition()[1] == position[1]) {
            if (!w.getImmortal()) {     //check for immortal
                w.die();
                String s = getName() + " fish killed " + w.getName();
                System.out.println(s);
                Lake.displayNot = s;
            }
        }
    }
}