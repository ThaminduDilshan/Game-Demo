package gamedemo;

import java.util.*;

/**
 *
 * @author THAMINDU
 */

//in this code x means horizontal move
//in this code y means vertical move

public abstract class Warrior implements Inhabitant,Runnable {

    private String name;
    int[] position;   //set position(y,x) in a list
    static int noOfWarriors;  //count the number of warrior objects created
    Binocular binocular;
    Fin fin;
    private boolean life;
    private boolean immortal;
    private boolean win;
    private Lake lk;

    public Warrior(String name, Lake lk) {
        this.name = name;
        life = true;
        immortal = false;
        win = false;
        fin = new Fin();
        this.lk = lk;
    }
    
    public void run(){
        while(true){
            if(fin==null || life==false){
                Lake.noOfAliveWar -= 1;
                if(Lake.noOfAliveWar==0){
                    System.out.println("GAME OVER... No winner!!!");
                    Lake.displayNot = "GAME OVER... No winner!!!";
                }
                break;
            }else{
                if(TreasureChest.getWon()==true){
                    break;
                }else{
                    swim(lk);
                }
                for (LotusFlower lotus : Lake.allLotus){
                    pluckPetal(lotus);
                }
                Lake.tc.win(this);
            }
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }
    }

    public abstract void eat();
    public abstract void sleep();
    public abstract void swim(Lake lk);
    
    //common normalSwim for both warriors
    public void normalSwim(Lake lk){
        if (fin != null) {
            //0 - up    1 - right   2 - down    3 - left
            ArrayList<Integer> dirList = new ArrayList<Integer>();    //this holds directions warrior can move
            dirList.add(0);
            dirList.add(1);
            dirList.add(2);
            dirList.add(3);

            //if a warrior in a edge, remove it from the list
            if (getPosition()[0] == 0) {   //check for upper edge
                dirList.remove((Integer) 0);
            }
            if (getPosition()[1] == 10) {   //check for right edge
                dirList.remove((Integer) 1);
            }
            if (getPosition()[0] == 10) {   //check for lower edge
                dirList.remove((Integer) 2);
            }
            if (getPosition()[1] == 0) {   //check for left edge
                dirList.remove((Integer) 3);
            }

            if (dirList.contains((Integer) 0)) {  //check for move up
                if (Lake.isWarriorIn(getPosition()[0] - 1, getPosition()[1])) {
                    dirList.remove((Integer) 0);
                }
            }
            if (dirList.contains((Integer) 1)) {  //check for move right
                if (Lake.isWarriorIn(getPosition()[0], getPosition()[1] + 1)) {
                    dirList.remove((Integer) 1);
                }
            }
            if (dirList.contains((Integer) 2)) {  //check for move down
                if (Lake.isWarriorIn(getPosition()[0] + 1, getPosition()[1])) {
                    dirList.remove((Integer) 2);
                }
            }
            if (dirList.contains((Integer) 3)) {  //check for move left
                if (Lake.isWarriorIn(getPosition()[0], getPosition()[1] - 1)) {
                    dirList.remove((Integer) 3);
                }
            }

            Random rand = new Random();
            if (!dirList.isEmpty()) {
                int dir = (Integer) dirList.get(rand.nextInt(dirList.size()));
                if (dir == 0) {   //move up
                    Lake.grid[getPosition()[0]][getPosition()[1]].clear();
                    lk.updateCordinate(getPosition()[0] - 1 ,getPosition()[1] ,this);
                    int[] pos = {getPosition()[0] - 1, getPosition()[1]};
                    setPosition(pos);
                } else if (dir == 1) {   //move right
                    Lake.grid[getPosition()[0]][getPosition()[1]].clear();
                    lk.updateCordinate(getPosition()[0] ,getPosition()[1]+1 ,this);
                    int[] pos = {getPosition()[0], getPosition()[1] + 1};
                    setPosition(pos);
                } else if (dir == 2) {   //move down
                    Lake.grid[getPosition()[0]][getPosition()[1]].clear();
                    lk.updateCordinate(getPosition()[0] + 1 ,getPosition()[1] ,this);
                    int[] pos = {getPosition()[0] + 1, getPosition()[1]};
                    setPosition(pos);
                } else {   //move left
                    Lake.grid[getPosition()[0]][getPosition()[1]].clear();
                    lk.updateCordinate(getPosition()[0] ,getPosition()[1]-1 ,this);
                    int[] pos = {getPosition()[0], getPosition()[1] - 1};
                    setPosition(pos);
                }
                String s = getName() + " move to (" + getPosition()[0] + "," + getPosition()[1] + ")";
                System.out.println(s);
                //Lake.displayNot = s;
            } else {
                String s = getName() + " currently can't swim!!!";
                System.out.println(s);
                Lake.displayNot = s;
            }

        } else {
            String s = getName() + " can't swim!!!";
            System.out.println(s);
            Lake.displayNot = s;
        }
    }
    
    public int getNoOfWarriors() {
        return noOfWarriors;
    }

    public void looseFins() {
        fin = null;
    }

    public boolean getLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public void die() {
        setLife(false);
    }

    public boolean getImmortal() {
        return immortal;
    }

    public void setImmortal(boolean immortal) {  //become immortal
        this.immortal = immortal;
    }

    public int getFins() {
        return fin.getFins();
    }

    public void setFins(Fin fin) {
        this.fin = fin;
    }

    public boolean getWin() {
        return win;
    }

    public void setWin(boolean win) {  //win the game
        this.win = win;
    }

    public void pluckPetal(LotusFlower lf) {  //pluck a petal
        if (getPosition()[0] == lf.getPosition()[0] && getPosition()[1] == lf.getPosition()[1]) {
            if (!immortal) {
                lf.loosePetals();
                setImmortal(true);
                String s = getName() + " pluks a petal and become immortal";
                System.out.println(s);
                Lake.displayNot = s;
            }
        }
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