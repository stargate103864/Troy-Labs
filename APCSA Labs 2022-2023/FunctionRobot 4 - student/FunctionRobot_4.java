import kareltherobot.*;
import java.awt.Color;

/**

- Write a description of class FunctionRobot_4 here.
- 
- @author (your name)
- @version (a version number or a date)
 */
public class FunctionRobot_4 extends FunctionRobot_3
{
    public FunctionRobot_4(int st, int ave, Direction dir, int num)
    {
        super(st, ave, dir, num);
    }

    //  returns the number of beepers the robot is currently occupying
    //  all beepers collected from current corner must be returned
    //
    //  you may create a variable to count :)

    public int numBeepersOnCorner()
    {
        int ans = 0;
        while ( nextToABeeper() )
        {
            pickBeeper();
            ans++;
        }
        for (int n = 0; n < ans; n++)
        {
            putBeeper();
        }
        return ans;
    }

    //  returns the direction (North, South, East, or West) of the adjacent corner
    //  with the most beepers.
    //  return null if the corner the robot is currently occupying has the most
    //  If 2 or more corners tie for the most beepers, return any of those directions (null should not be returned)
    //
    //  you may create ONE variable to count :)
    //  Robot must face its original direction when done
    public int collectInfo()
    {
        if (frontIsClear())
        {
            move();
        }
        int numb =  numBeepersOnCorner();
        turnAround();
        if (frontIsClear())
        {
            move();
        }
        turnAround();
        return numb;
    }

    public Direction directionToMostBeepers()
    {
        Direction ans = null;
        int temp = 0;
        temp = (numBeepersOnCorner());
        for (int n = 0; n < 4; n++)
        {

            collectInfo();
            if (collectInfo() > temp)
            {
                temp = (collectInfo());

                ans = getDirection();
            }

            turnRight();

        }

        return ans;

    }

    public Direction getDirection()
    {
        if (facingNorth())
        {
            return North;
        }
        if (facingSouth())
        {
            return South;
        }
        if (facingEast())
        {
            return East;
        }
        return West;

    }

    //  The robot should move forward until it is on a corner with a Robot or Beeper
    //  You may not assume no walls and must stop at the wall and return false
    //  If no wall is encountered, return true
    public boolean moveTillNextToRobotOrBeeper()
    {
        if (nextToABeeper() || nextToARobot())
        {
         if (frontIsClear())
         {
             return true;
            }
        }
        else
        {
            if (frontIsClear())
            {
                move();
                moveTillNextToRobotOrBeeper();
            }
            if (!frontIsClear())
            {
                return false;
            }
        }
        return false;
        
    }

    //  move forward to the first corner containing beepers.
    //  If the robot starts on a corner with beeper(s), the robot should not move
    //
    //  You may assume no walls!
    //
    //  Once on the corner, the Robot should turn to face:
    //     North if the number of beepers is divisible by 4
    //     South if the number of beepers is 1 mod 4
    //     East if the number of beepers is 2 mod 4
    //     West if the number of beepers is 3 mod 4
    // return the new direction the robot is facing
    public Direction moveToBeeperStackAndTurn()
    {
        while(!nextToABeeper())
        {
            move();
        }
        int count = 0;
        while (nextToABeeper())
        {
            pickBeeper();
            count ++;
        }
        for (int n = 0; n < count; n++)
        {
            putBeeper();
        }
        if (count % 4 == 0)
        {
            faceNorth();
        }
        if (count % 4 == 1)
        {
            faceSouth();
        }
        if (count % 4 == 2)
        {
            faceEast();
        }
        if (count % 4 == 3)
        {
            faceWest();
        }
        if (facingNorth())
        {
            return North;
        }
        if (facingSouth())
        {
            return South;
        }
        if (facingEast())
        {
            return East;
        }
        return West;

    }

    //  The robot should move forward until 3 or more of the following four conditions are satisfied
    //    1)  it is on a corner with a Robot and Beeper
    //    2)  it is on a corner with a Robot to its right and Beeper to its left
    //    3)  it is on a corner with a Robot and either a Robot to its left or Beeper to its right
    //    4)  it is on a corner with a total of four or more beepers nearby.
    //           nearby implies on current corner or adjacent corners to the North, South, East or West
    //           you mayNOT  assume no nearby walls (wall may exist between current corner and the adjacent four corners)
    //           you may NOT assume no walls on the other three corners of the adjacent walls except as required
    //                when moving forward
    public boolean beeperOnRight()
    {
        turnRight();
        if (frontIsClear())
        {
            move();
        }
        if (nextToABeeper())
        {
            turnAround();
            if (frontIsClear())
            {
                move();
            }
            turnRight();
            return true;
        }
        turnAround();
        if (frontIsClear())
        {
            move();
        }
        turnRight();
        return false;
    }

    public boolean robotOnLeft()
    {
        turnLeft();
        if (frontIsClear())
        {
            move();
        }
        if (nextToARobot())
        {
            turnAround();
            if (frontIsClear())
            {
                move();
            }
            turnLeft();
            return true;
        }
        turnAround();
        if (frontIsClear())
        {
            move();
        }
        turnLeft();
        return false;
    }

    public boolean robotOnRight()
    {
        turnRight();
        if (frontIsClear())
        {
            move();
        }
        if (nextToARobot())
        {
            turnAround();
            if (frontIsClear())
            {
                move();
            }
            turnRight();
            return true;
        }
        turnAround();
        if (frontIsClear())
        {
            move();
        }
        turnRight();
        return false;
    }

    public boolean beeperOnLeft()
    {
        turnLeft();
        if (frontIsClear())
        {
            move();
        }
        if (nextToABeeper())
        {
            turnAround();
            if (frontIsClear())
            {
                move();
            }
            turnLeft();
            return true;
        }
        turnAround();
        if (frontIsClear())
        {
            move();
        }
        turnLeft();
        return false;
    }

    public boolean condition1()//    1)  it is on a corner with a Robot and Beeper
    {
        if (nextToARobot() && nextToABeeper())
        {
            return true;
        }
        return false;
    }

    public boolean condition2()//    2)  it is on a corner with a Robot to its right and Beeper to its left
    {
        if (robotOnRight() && beeperOnLeft())
        {
            return true;
        }
        return false;
    }

    public boolean condition3()//    3)  it is on a corner with a Robot and either a Robot to its left or Beeper to its right
    {
        if (nextToARobot() && (robotOnLeft() || beeperOnRight()))
        {
            return true;
        }
        return false;
    }

    public boolean condition4()//    4)  it is on a corner with a total of four or more beepers nearby.
    {
        int newt = 0;
        for (int n = 0; n < 4; n++)
        {
            newt = newt + collectInfo();
            turnLeft();

        }
        if (newt >= 4)
        {
            return true;
        }
        return false;

    }
    public boolean threeConditions()
    {
        int con = 0;
        if (condition1())
        {
            con ++;
        }
        if (condition2())
        {
            con ++;
        }
        if (condition3())
        {
            con ++;
        }
        if (condition4())
        {
            con ++;
        }
        if (con >= 3)
        {
            return true;
        }
        return false;
    }

    //  Yes, if I was writing this, I would create a helper method.
    public void  moveTill()  // see comments
    {
        while (!threeConditions())
        {
            if (frontIsClear())
            {
                move();
            }
        }
    }
}