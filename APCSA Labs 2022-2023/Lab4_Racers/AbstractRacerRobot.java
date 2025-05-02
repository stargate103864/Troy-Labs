
/**
 * Abstract class AbstractRacerRobot - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class AbstractRacerRobot extends SmartBot
{
    // instance variables - replace the example below with your own

    public AbstractRacerRobot(int st, int ave, Direction dir, int beeps){
        
            super (st, ave, dir, beeps);
        
    }

    public abstract void runRace();
    public abstract void raceStride();
}
