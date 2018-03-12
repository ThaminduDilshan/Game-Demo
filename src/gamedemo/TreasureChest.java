package gamedemo;

import java.io.*;

/**
 *
 * @author THAMINDU
 */

public class TreasureChest {

    private int[] position;   //set position(y,x) in a list
    private static boolean won = false;

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int[] getPosition() {
        return position;
    }
    
    public static boolean getWon(){
        return won;
    }

    public void win(Warrior w) {        //make a warrior win
        if (w.getPosition()[0] == position[0] && w.getPosition()[1] == position[1]) {
            w.setWin(true);
            won = true;
            System.out.println(w.getName() + " wins!!!");
            
            try{                                                                //writing result to permanent memory
                FileWriter fw = new FileWriter("LakeNozama_summary.txt");
                BufferedWriter buff = new BufferedWriter(fw);
                buff.write("Game Summary");
                buff.newLine();
                buff.write("------------------------------------");
                buff.newLine();
                buff.newLine();
                buff.write( "Winner               :  " + w.getName().substring(2) );
                buff.newLine();
                if( w.getName().charAt(0) == 'N' ){
                    buff.write( "Type                 :  Normal" );
                }else{
                    buff.write( "Type                 :  Super" );
                }
                buff.newLine();
                buff.write( "Winning time         :  " +w.getTime() );
                buff.newLine();
                buff.write( "Immortal             :  " + w.getImmortal() );
                buff.newLine();
                buff.write( "No of Alive Warriors :  " + Lake.noOfAliveWar );
                buff.close();
            }catch(IOException e){
                System.out.println("Error occured while writing to a file !!!");
            }
            
        } else {
            w.setWin(false);
        }
    }
}