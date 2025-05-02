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
        turnAround();
        turnLeft();
    }

    public void faceNorth()
    {
        while(!facingNorth()){
            turnLeft();
        }
    }

    public void faceSouth()
    {
        while(!facingSouth()){
            turnLeft();
        }
    }

    public void faceEast()
    {
        while(!facingEast()){
            turnLeft();
        }
    }

    public void faceWest()
    {
        while(!facingWest()){
            turnLeft();
        }
    }
    public void goToOrigin(){
        faceSouth();
        while(frontIsClear()){
            move();
        }
        faceWest();
        while(frontIsClear()){
            move();
        }
    }
    public boolean wallOnRight()
    {
       turnRight();
       if(!frontIsClear()){
           turnLeft();
           return true;
       }
       turnLeft();
       return false;
    }

    public boolean wallOnLeft()
    {
       turnLeft();
       if(!frontIsClear()){
           turnRight();
           return true;
       }
       turnRight();
       return false;
    }

    public boolean exactlyOneBeeperOnCorner()
    {
       if(nextToABeeper()){
           pickBeeper();
           if(nextToABeeper()){
               putBeeper();
               return false;
           }
           putBeeper();
           return true;
       }
       return false;
    }

    public boolean twoOrMoreBeepersOnCorner()
    {
       if(nextToABeeper()){
           pickBeeper();
           if(nextToABeeper()){
               putBeeper();
               return true;
           }
           putBeeper();
           return false;
       }
       return false;
    }
}