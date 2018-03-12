package gamedemo;

import java.util.*;

/**
 *
 * @author 160253H
 */
public class Lake extends Observable{               // GRID
    public static GridLocation[][] grid = new GridLocation[11][11]; //first element => y=0,x=0
    public static ArrayList<LotusFlower> allLotus = new ArrayList<LotusFlower>();  //to hold all lotus flowers (purpose - for use of Superwarrior)
    public static Inhabitant[] inhabitCharac = new Inhabitant[10];
    public static TreasureChest tc;         //Lake has a treasure chest
    public static int noOfAliveWar;     //track no of alive warriors
    
    public Lake(){
        for(int i=0; i<11; i++){                        //add grid locations to the Grid
            for(int j=0; j<11; j++){
                grid[i][j] = new GridLocation(j, i);
            }
        }
        tc = new TreasureChest();  //make treasure chest
        Lake.grid[5][5].put(tc);
        int[] posTC = {5, 5};
        tc.setPosition(posTC);
        noOfAliveWar=0;
    }

    public static int[] placing() {
        Random rand = new Random();
        int y = rand.nextInt(11);
        int x = rand.nextInt(11);

        while ( !(Lake.grid[y][x].get() == null) ) {
            y = rand.nextInt(11);
            x = rand.nextInt(11);
        }
        int[] pos = {y, x};
        return pos;
    }

    public static int[] placingWarrior() {
        Random r = new Random();
        int x, y;
        int edge = r.nextInt(4);    //0-up  1-right  2-down  3-left
        switch (edge) {
            case 0:    //upper edge
                y = 0;
                x = r.nextInt(11);
                while (!(Lake.grid[y][x].getWar() == null)) {
                    x = r.nextInt(11);
                }
                break;
            case 1:    //right edge
                x = 10;
                y = r.nextInt(11);
                while (!(Lake.grid[y][x].getWar() == null)) {
                    y = r.nextInt(11);
                }
                break;
            case 2:   //lower end
                y = 10;
                x = r.nextInt(11);
                while (!(Lake.grid[y][x].getWar() == null)) {
                    x = r.nextInt(11);
                }
                break;
            default:        //(edge = 3) left edge
                x = 0;
                y = r.nextInt(11);
                while (!(Lake.grid[y][x].getWar() == null)) {
                    y = r.nextInt(11);
                }
                break;

        }
        int[] pos = {y, x};
        return pos;
    }
    
    public void updateCordinate(int y, int x, Object obj){          //update a cordinate (move)
        Lake.grid[y][x].put( obj );
        setChanged();
        notifyObservers(obj);                                       // notify to fishes
    }

    public static void createWarrior(String name, Inhabitant[] inh, int index, Lake lk) {
        Random r = new Random();
        int type = r.nextInt(2);    //0 - normal      1 - super
        if (type == 0) {        //create a normal warrior
            inh[index] = new NormalWarrior("N:" + name,lk);
            inh[index].setPosition(placingWarrior());
            lk.updateCordinate(inh[index].getPosition()[0], inh[index].getPosition()[1], inh[index]);
        } else {              //create a super warrior
            inh[index] = new SuperWarrior("S:" + name,lk);
            inh[index].setPosition(placingWarrior());
            lk.updateCordinate(inh[index].getPosition()[0], inh[index].getPosition()[1], inh[index]);
        }
        noOfAliveWar += 1;
    }

    public static boolean isWarriorIn(int y, int x) { //check whether a warrior in a given node
        if (Lake.grid[y][x].getWar() != null) {
            if (Lake.grid[y][x].getWar() instanceof SuperWarrior) {    //grid[y][x] instanceof Warrior
                return true;
            } else if (Lake.grid[y][x].getWar() instanceof NormalWarrior) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}