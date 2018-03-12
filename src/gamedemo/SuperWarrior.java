package gamedemo;

/**
 *
 * @author THAMINDU
 */

public class SuperWarrior extends Warrior {

    public SuperWarrior(String name, Lake lk) {
        super(name,lk);
        binocular = new Binocular();  //give a binocular
        noOfWarriors++;
    }

    public LotusFlower lookLotus() {  //look for lotus flowers in the vicinity
        LotusFlower lotus;            //holds the flower which has the shortest path
        lotus = null;
        
        for (LotusFlower i : Lake.allLotus) {            //look for lotus flowers in the vicinity
            if (i.getPosition()[0] == getPosition()[0]) {
                if (Math.abs(i.getPosition()[1] - getPosition()[1]) == 1) {
                    lotus = i;
                    break;
                }
            } else if (i.getPosition()[1] == getPosition()[1]) {
                if (Math.abs(i.getPosition()[0] - getPosition()[0]) == 1) {
                    lotus = i;
                    break;
                }
            }
        }

        return lotus;
    }

    public void swim(Lake lk) {
        if (fin != null) {
            if (!getImmortal()) {        //not immortal
                LotusFlower lf = lookLotus();
                if(lf!=null){
                    String s = this.getName()+" saw the lotus at ("+lf.getPosition()[0]+","+lf.getPosition()[1]+")";
                    System.out.println( s );
                    Lake.displayNot = s;
                }
                int dir;
                if (lf != null) {           //warrior has a lotus flower in the vicinity
                    if (Math.abs(lf.getPosition()[1] - getPosition()[1]) < Math.abs(lf.getPosition()[0] - getPosition()[0])) {
                        //move vertical
                        //dir + => move down , - => move up
                        dir = lf.getPosition()[0] - getPosition()[0];
                        if (dir < 0) {  //move up
                            if (!Lake.isWarriorIn(getPosition()[0] - 1, getPosition()[1])) {
                                Lake.grid[getPosition()[0]][getPosition()[1]].clear();
                                lk.updateCordinate(getPosition()[0] - 1 ,getPosition()[1] ,this);
                                int[] pos = {getPosition()[0] - 1, getPosition()[1]};
                                setPosition(pos);
                                String s = getName() + " move to (" + getPosition()[0] + "," + getPosition()[1] + ")";
                                System.out.println(s);
                                //Lake.displayNot = s;
                            } else {
                                normalSwim(lk);
                            }
                        } else {          //move down
                            if (!Lake.isWarriorIn(getPosition()[0] + 1, getPosition()[1])) {
                                Lake.grid[getPosition()[0]][getPosition()[1]].clear();
                                lk.updateCordinate(getPosition()[0] + 1 ,getPosition()[1] ,this);
                                int[] pos = {getPosition()[0] + 1, getPosition()[1]};
                                setPosition(pos);
                                String s = getName() + " move to (" + getPosition()[0] + "," + getPosition()[1] + ")";
                                System.out.println(s);
                                //Lake.displayNot = s;
                                
                            } else {
                                normalSwim(lk);
                            }
                        }
                    } else {
                        //move horizontal
                        //dir + => move right , - => move left
                        dir = lf.getPosition()[1] - getPosition()[1];
                        if (dir < 0) {  //move left
                            if (!Lake.isWarriorIn(getPosition()[0], getPosition()[1] - 1)) {
                                Lake.grid[getPosition()[0]][getPosition()[1]].clear();
                                lk.updateCordinate(getPosition()[0] ,getPosition()[1]-1 ,this);
                                int[] pos = {getPosition()[0], getPosition()[1] - 1};
                                setPosition(pos);
                                String s = getName() + " move to (" + getPosition()[0] + "," + getPosition()[1] + ")";
                                System.out.println(s);
                                //Lake.displayNot = s;
                            } else {
                                normalSwim(lk);
                            }
                        } else {          //move right
                            if (!Lake.isWarriorIn(getPosition()[0], getPosition()[1] + 1)) {
                                Lake.grid[getPosition()[0]][getPosition()[1]].clear();
                                lk.updateCordinate(getPosition()[0] ,getPosition()[1]+1 ,this);
                                int[] pos = {getPosition()[0], getPosition()[1] + 1};
                                setPosition(pos);
                                String s = getName() + " move to (" + getPosition()[0] + "," + getPosition()[1] + ")";
                                System.out.println(s);
                                //Lake.displayNot = s;
                            } else {
                                normalSwim(lk);
                            }
                        }

                    }
                } else {              //no lotus in the vicinity
                    normalSwim(lk);
                }
            } else {                      //if immortal, super warrior is going to get treasure
                normalSwim(lk);
            }

        } else {
            String s = getName() + " can't swim!!!";
            System.out.println(s);
            Lake.displayNot = s;
        }
    }

    @Override
    public void eat() {
        //need to be overrided
    }

    @Override
    public void sleep() {
        //need to be overrided
    }
}