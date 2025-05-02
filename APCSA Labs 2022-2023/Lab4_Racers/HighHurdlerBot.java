
/**
 * Write a description of class HighHurdlerBot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighHurdlerBot extends AbstractHurdlerRobot
{
    
    public HighHurdlerBot(int st, int ave, Direction dir, int beeps)
    {

        
            super(st, ave, dir, beeps);
        }
    
 
    public void up()
    {
        turnLeft();
        while(wallOnRight())
        {
            move();
        }
    }
 
    public void down()
    {
        move();
        while (frontIsClear())
        {
            move();
        }
        turnLeft();
    }

    public void over()
    {
        turnRight();
        move();
        while (wallOnRight())
        {
            move();
        }
        turnRight();
    }
    public void runRace()
    {
        while (!nextToABeeper())
        {
            if (frontIsClear())
            {
                raceStride();
            }
            else
            {
                up();
                over();
                down();
            }
        }
        pickBeeper();
    }
}
