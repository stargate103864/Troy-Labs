
/**
 * Abstract class AbstractHurdlerRobot - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class AbstractHurdlerRobot extends AbstractRacerRobot
{
    public AbstractHurdlerRobot (int st, int ave, Direction dir, int beeps){
        super(st, ave, dir, beeps);
    }

    public void raceStride(){
        while (frontIsClear() && !nextToABeeper()){
            move();
        }
    }
    public abstract void up();
    public abstract void over();
    public abstract void down();
}
