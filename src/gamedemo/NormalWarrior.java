package gamedemo;

/**
 *
 * @author THAMINDU
 */
public class NormalWarrior extends Warrior {

    public NormalWarrior(String name, Lake lk) {
        super(name,lk);
        binocular = null;
        noOfWarriors++;
    }

    @Override
    public void swim(Lake lk){
        normalSwim(lk);
    }
    
    @Override
    public void eat() {   //how a warrior eat

    }

    @Override
    public void sleep() {  //how a warrior sleep

    }
}