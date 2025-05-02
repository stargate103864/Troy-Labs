
/**
 * Write a description of class SprinterBot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SprinterBot extends AbstractRacerRobot
{
    
    public SprinterBot(int st, int ave, Direction dir, int beeps)
    {
        super(st, ave, dir, beeps);
    }

    public void runRace()
    {
        while (!nextToABeeper())
        {
            raceStride();
        }
    }
    public void raceStride()
    {
        if (!nextToABeeper())
        {
            move();
        }
    }
}
