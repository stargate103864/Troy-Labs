
/**
 * Write a description of class BeeperMover2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeeperMover2 extends SmartBot
{
    public BeeperMover2(int st, int ave, Direction dir, int beeps)

    {
        super (st,ave, dir, beeps);
    }

    public void moveBeepersNorth()
    {
        findStart();
        pickAndTranslateSelfToTheNorth();
        dropRow();
    }

    public void findStart()
    {
        if (!nextToABeeper())
        {
            move();
            findStart();
        }
    }

    public void pickAndTranslateSelfToTheNorth()
    {
        if (nextToABeeper())
        {
            pickBeeper();
            move();
            pickAndTranslateSelfToTheNorth();
            move();
        }
        else
        {
            faceNorth();
        }
    }

    public void dropRow()
    {
        faceWest();
        if (anyBeepersInBeeperBag())
        {
            move();
            putBeeper();
            dropRow();
        }
        else
        {
            move();
        }
    }

}

