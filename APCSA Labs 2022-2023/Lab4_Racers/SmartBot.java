import kareltherobot.*;
/**
 * Write a description of class Pinsetter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmartBot extends Robot
{
    /**
     * Constructor for objects of class Pinsetter
     */
    public SmartBot(int st, int ave, Direction dir, int beeps)
    {
        super (st,ave, dir, beeps);
    }

    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }

    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public void faceNorth()
    {
        if (!facingNorth())
        {
            turnLeft();
        }
        if (!facingNorth())
        {
            turnLeft();
        }
        if (!facingNorth())
        {
            turnLeft();
        }
        if (!facingNorth())
        {
            turnLeft();
        }
    }

    public void faceSouth()
    {
        if (!facingSouth())
        {
            turnLeft();
        }if (!facingSouth())
        {
            turnLeft();
        }if (!facingSouth())
        {
            turnLeft();
        }if (!facingSouth())
        {
            turnLeft();
        }

    }

    public void faceEast()
    {
        if (!facingEast())
        {
            turnLeft();
        }
        if (!facingEast())
        {
            turnLeft();
        }
        if (!facingEast())
        {
            turnLeft();
        }
        if (!facingEast())
        {
            turnLeft();
        }

    }

    public void faceWest()
    {
        if (!facingWest())
        {
            turnLeft();
        }
        if (!facingWest())
        {
            turnLeft();
        }
        if (!facingWest())
        {
            turnLeft();
        }
        if (!facingWest())
        {
            turnLeft();
        }

    }

    public boolean wallOnRight()
    {
        turnRight();
        if (!frontIsClear())
        {
            turnLeft();
            return true;
        }
        turnLeft();
        return false;
    }

    public boolean wallOnLeft()
    {
        turnLeft();
        if (!frontIsClear())
        {
            turnRight();
            return true;
        }
        turnRight();
        return false;
    }

    public boolean exactlyOneBeeperOnCorner()
    {
       if (nextToABeeper())
       {
           pickBeeper();
           if (!nextToABeeper())
           {
               putBeeper();
               return true;
           }
           putBeeper();
           return false;
       }
       return false;
    }
    public boolean twoOrMoreBeepersOnCorner()
    {
       if (nextToABeeper())
       {
           pickBeeper();
           if (!nextToABeeper())
           {
               putBeeper();
               return false;
           }
           putBeeper();
           return true;
       }
       return false;
    }
}