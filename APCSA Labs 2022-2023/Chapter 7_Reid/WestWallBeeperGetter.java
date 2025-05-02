
/**
 * Write a description of class WestWallBeeperGetter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WestWallBeeperGetter extends SmartBot
{
   
    public WestWallBeeperGetter(int st, int ave, Direction dir, int beeps)

    {
        super (st,ave, dir, beeps);
    }

    public void getBeeper()
    {
        faceWest();
        if (!frontIsClear())
        {
            pickBeeper();
            turnAround();
        }
        else
        {
            move();
            getBeeper();
            move();
        }
    }

}
