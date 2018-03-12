package gamedemo;

import java.util.*;

/**
 *
 * @author THAMINDU
 */
public class InnocentFish extends Fish implements Observer {

    public InnocentFish(String name) {
        super(name);
    }
    
    @Override
    public void run(){
        
    }
    
    public synchronized void update(Observable e, Object arg){
    }
}