package gamedemo;

/**
 *
 * @author 160253H
 */
public class GridLocation {         // grid has grid locations
    private int corX;
    private int corY;
    private Object[] obj;         //grid location has the object
    
    public GridLocation(int corX, int corY){
        this.corX = corX;
        this.corY = corY;
        obj = new Object[2];
        obj[0]=null;                        // Lotus,Fishes and Treasure Chest
        obj[1] = null;                      // Warriors
    }
    
    public synchronized void put(Object obj){       // put any Object to a grid location
        if(obj instanceof Warrior){                 // put a Warrior
            while(this.obj[1] != null){         //if a Warrior in, wait
                try{
                    wait();
                }catch(Exception e){}
            }
            this.obj[1] = obj;
        }else{                              //put a object other than a Warrior
            this.obj[0] = obj;
        }
    }
    public synchronized Object get(){   //get other objects(Lotus or Fish or Treasure)
        return obj[0];
    }
    public synchronized Object getWar(){    //get warrior
        return obj[1];
    }
    public synchronized void clear(){       //clear a node
        obj[1] = null;
        notifyAll();
    }
}