package gamedemo;

import java.util.Arrays;

/**
 *
 * @author 160253H
 */

//in this code x means horizontal move
//in this code y means vertical move

public class GameDemo {

    public static void main(String[] args) {
        Lake nozama = new Lake();

        Lake.createWarrior("Malinga", Lake.inhabitCharac, 0, nozama);    //create 4 warriors
        Lake.createWarrior("Kusal", Lake.inhabitCharac, 1, nozama);
        Lake.createWarrior("Asela", Lake.inhabitCharac, 2, nozama);
        Lake.createWarrior("Dikwella", Lake.inhabitCharac, 3, nozama);

        Lake.inhabitCharac[4] = new InnocentFish("Fish_Masakadza");              //make fishes
        Lake.inhabitCharac[4].setPosition(Lake.placing());
        Lake.grid[Lake.inhabitCharac[4].getPosition()[0]][Lake.inhabitCharac[4].getPosition()[1]].put( Lake.inhabitCharac[4] );

        Lake.inhabitCharac[5] = new InnocentFish("Fish_Raza");
        Lake.inhabitCharac[5].setPosition(Lake.placing());
        Lake.grid[Lake.inhabitCharac[5].getPosition()[0]][Lake.inhabitCharac[5].getPosition()[1]].put( Lake.inhabitCharac[5] );

        Lake.inhabitCharac[6] = new EatRubFish("Fish_Akmal");
        Lake.inhabitCharac[6].setPosition(Lake.placing());
        Lake.grid[Lake.inhabitCharac[6].getPosition()[0]][Lake.inhabitCharac[6].getPosition()[1]].put( Lake.inhabitCharac[6] );

        Lake.inhabitCharac[7] = new EatRubFish("Fish_Afridi");
        Lake.inhabitCharac[7].setPosition(Lake.placing());
        Lake.grid[Lake.inhabitCharac[7].getPosition()[0]][Lake.inhabitCharac[7].getPosition()[1]].put( Lake.inhabitCharac[7] );

        Lake.inhabitCharac[8] = new KillerFish("Fish_Gayle");
        Lake.inhabitCharac[8].setPosition(Lake.placing());
        Lake.grid[Lake.inhabitCharac[8].getPosition()[0]][Lake.inhabitCharac[8].getPosition()[1]].put( Lake.inhabitCharac[8] );

        Lake.inhabitCharac[9] = new KillerFish("Fish_Pollard");
        Lake.inhabitCharac[9].setPosition(Lake.placing());
        Lake.grid[Lake.inhabitCharac[9].getPosition()[0]][Lake.inhabitCharac[9].getPosition()[1]].put( Lake.inhabitCharac[9] );

        LotusFlower lf1 = new LotusFlower();  //make lotus flowers
        lf1.setPosition(Lake.placing());
        Lake.grid[lf1.getPosition()[0]][lf1.getPosition()[1]].put(lf1);
        Lake.allLotus.add(lf1);

        LotusFlower lf2 = new LotusFlower();
        lf2.setPosition(Lake.placing());
        Lake.grid[lf2.getPosition()[0]][lf2.getPosition()[1]].put(lf2);
        Lake.allLotus.add(lf2);

        LotusFlower lf3 = new LotusFlower();
        lf3.setPosition(Lake.placing());
        Lake.grid[lf3.getPosition()[0]][lf3.getPosition()[1]].put(lf3);
        Lake.allLotus.add(lf3);

        LotusFlower lf4 = new LotusFlower();
        lf4.setPosition(Lake.placing());
        Lake.grid[lf4.getPosition()[0]][lf4.getPosition()[1]].put(lf4);
        Lake.allLotus.add(lf4);

        LotusFlower lf5 = new LotusFlower();
        lf5.setPosition(Lake.placing());
        Lake.grid[lf5.getPosition()[0]][lf5.getPosition()[1]].put(lf5);
        Lake.allLotus.add(lf5);

        for (int i = 0; i <= 10; i++) {           // **just for view the grid
            for(int j=0; j<=10; j++){
                if( Lake.grid[i][j].getWar() == null ){
                    System.out.print("(" + Lake.grid[i][j].get() + ") " );
                }else{
                    System.out.print("(" + Lake.grid[i][j].getWar() + ") " );
                }
            }
            System.out.println();
        }

        for (int i = 0; i < Lake.inhabitCharac.length; i++) {             //print inhabitants
            int[] pos = Lake.inhabitCharac[i].getPosition();
            System.out.println(Lake.inhabitCharac[i].getName() + " is at (" + pos[0] + "," + pos[1] + ")");
        }
        
        //observe Fishes for the Lake
        nozama.addObserver((EatRubFish)Lake.inhabitCharac[6]);
        nozama.addObserver((EatRubFish)Lake.inhabitCharac[7]);
        nozama.addObserver((KillerFish)Lake.inhabitCharac[8]);
        nozama.addObserver((KillerFish)Lake.inhabitCharac[9]);
        
        //adding observers to Warrior class (to notify when their is a winner)
        Warrior.addObserver( (Warrior)Lake.inhabitCharac[0] );
        Warrior.addObserver( (Warrior)Lake.inhabitCharac[1] );
        Warrior.addObserver( (Warrior)Lake.inhabitCharac[2] );
        Warrior.addObserver( (Warrior)Lake.inhabitCharac[3] );
        
        //creating threads
        Thread war1 = new Thread( (Warrior)Lake.inhabitCharac[0] );
        Thread war2 = new Thread( (Warrior)Lake.inhabitCharac[1] );
        Thread war3 = new Thread( (Warrior)Lake.inhabitCharac[2] );
        Thread war4 = new Thread( (Warrior)Lake.inhabitCharac[3] );
        Thread if1 = new Thread( (Fish)Lake.inhabitCharac[4] );
        Thread if2 = new Thread( (Fish)Lake.inhabitCharac[5] );
        Thread erf1 = new Thread( (Fish)Lake.inhabitCharac[6] );
        Thread erf2 = new Thread( (Fish)Lake.inhabitCharac[7] );
        Thread kf1 = new Thread( (Fish)Lake.inhabitCharac[8] );
        Thread kf2 = new Thread( (Fish)Lake.inhabitCharac[9] );
        
        //starting inhabitant threads
        war1.start();
        war2.start();
        war3.start();
        war4.start();
        if1.start();
        if2.start();
        erf1.start();
        erf2.start();
        kf1.start();
        kf2.start();
    }
}