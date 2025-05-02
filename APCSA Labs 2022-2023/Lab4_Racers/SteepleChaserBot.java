
/**
 * Write a description of class SteepleChaserBot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SteepleChaserBot extends AbstractHurdlerRobot
{

    public SteepleChaserBot(int st, int ave, Direction dir, int beeps)
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

    public void down()
    {
        move();
        while (frontIsClear())
        {
            move();
        }
        turnLeft();
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
