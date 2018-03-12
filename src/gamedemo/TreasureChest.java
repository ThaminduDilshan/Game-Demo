package gamedemo;

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

    public void win(Warrior w) {  //make a warrior win
        if (w.getPosition()[0] == position[0] && w.getPosition()[1] == position[1]) {
            w.setWin(true);
            won = true;
            String s = w.getName() + " wins!!!";
            System.out.println(s);
            Lake.displayNot = s;
        } else {
            w.setWin(false);
        }
    }
}