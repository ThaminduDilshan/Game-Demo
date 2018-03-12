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
        obj[0]=null;
        obj[1] = null;
    }
    
    public synchronized void put(Object obj){
        if(obj instanceof Warrior){
            while(this.obj[1] != null){
                try{
                    wait(100);
                }catch(Exception e){}
            }
            this.obj[1] = obj;
        }else{
            this.obj[0] = obj;
        }
    }
    public synchronized Object get(){   //get other objects(Lotus or Fish or Treasure)
        return obj[0];
    }
    public synchronized Object getWar(){    //get warrior
        return obj[1];
    }
    public synchronized void clear(){
        obj[1] = null;
        notifyAll();
    }
}