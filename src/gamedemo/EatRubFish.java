package gamedemo;

import java.util.*;

/**
 *
 * @author THAMINDU
 */
public class EatRubFish extends Fish implements Observer {

    public EatRubFish(String name) {
        super(name);
    }
    
    @Override
    public void run(){
        
    }
    
    public synchronized void update(Observable e, Object arg){
        eatRubber( (Warrior)arg );
    }

    public void eatRubber(Warrior w) {  //eat a fin of a warrior
        if (w.getPosition()[0] == position[0] && w.getPosition()[1] == position[1]) {
            w.looseFins();
            String s = getName() + " fish ate fin of " + w.getName();
            System.out.println(s);
            Lake.displayNot = s;
        }
    }
}