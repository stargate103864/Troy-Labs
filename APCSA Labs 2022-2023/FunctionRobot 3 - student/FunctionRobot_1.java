import kareltherobot.*;
import java.awt.Color;

/**
 * Write a description of class FunctionRobot_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FunctionRobot_1 extends SmartBot
{
    public FunctionRobot_1(int st, int ave, Direction dir, int num)
    {
        super(st, ave, dir, num);
    }

    //  return the number of left turns needed to have this Robot face North
    //  Robots current direction is NOT changed!
    public int numberOfLeftTurnsToFaceNorth()
    {
        int ans = 0;
        while ( !facingNorth() ) 
        {
            turnLeft();
            ans++;
        }
        for (int k = ans; k < 4; k++)
        {
            turnLeft();
        }
        return ans;
    }

    //  return the number of left turns needed to have this Robot face South
    //  Robots current direction is NOT changed!
    public int numberOfLeftTurnsToFaceSouth()
    {
        int ans = 0;
        while ( !facingSouth() ) 
        {
            turnLeft();
            ans++;
        }
        for (int k = ans; k < 4; k++)
        {
            turnLeft();
        }
        return ans;
    }

    //  return the number of left turns needed to have this Robot face West
    //  Robots current direction is NOT changed!
    public int numberOfLeftTurnsToFaceWest()
    {
        int ans = 0;
        while ( !facingWest() ) 
        {
            turnLeft();
            ans++;
        }
        for (int k = ans; k < 4; k++)
        {
            turnLeft();
        }
        return ans;
    }

    //  return the number of left turns needed to have this Robot face East
    //  Robots current direction is NOT changed!
    public int numberOfLeftTurnsToFaceEast()
    {
        int ans = 0;
        while ( !facingEast() ) 
        {
            turnLeft();
            ans++;
        }
        for (int k = ans; k < 4; k++)
        {
            turnLeft();
        }
        return ans;
    }
}