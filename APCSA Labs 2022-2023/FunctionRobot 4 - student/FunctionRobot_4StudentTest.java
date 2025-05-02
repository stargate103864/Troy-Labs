import kareltherobot.*;
import java.awt.Color;
import java.util.*;
import junit.framework.*;

/**
 * The test class MainDriver1UnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FunctionRobot_4StudentTest extends junit.framework.TestCase implements Directions
{
   /*
    *     numBeepersOnCorner
    *     directionToMostBeepers
    *     moveTillNextToRobotOrBeeper
    *     moveTil
    *     moveToBeeperStackAndTurn
    */

   public  void testNumBeepersOnCorner()
   {
        FunctionRobot_4 karel = new FunctionRobot_4(1,1, East, 0);

        assertEquals(0, karel.numBeepersOnCorner());
        karel.move();
        assertEquals(1, karel.numBeepersOnCorner());
        Robot temp = new Robot(1,2, North, 0);
        assertEquals(true, temp.nextToABeeper());
        karel.move();
        assertEquals(6, karel.numBeepersOnCorner());
    }

   public  void testDirectionToMostBeepers ()
   {
        FunctionRobot_4 karel = new FunctionRobot_4(5, 14, North, 0);

        assertEquals(null, karel.directionToMostBeepers());
        karel.move();
        assertEquals(East, karel.directionToMostBeepers());
        karel.move();
        assertEquals(West, karel.directionToMostBeepers());
        karel.move();
        assertEquals(North, karel.directionToMostBeepers());
        assertEquals(true, karel.facingNorth());
    }

   public  void testMoveTillNextToRobotOrBeeper()
   {
        FunctionRobot_4 karel = new FunctionRobot_4(14, 1, East, 1);
        karel.moveTillNextToRobotOrBeeper();

        Robot z1 = new Robot(14, 6, North, 0);
        assertEquals(true, z1.nextToARobot());
        assertEquals(true, karel.nextToABeeper());
    }

   public  void testMoveTill()
   {
        FunctionRobot_4 karel = new FunctionRobot_4(15, 1, East, 1);
        Robot a1 = new Robot(16, 5, North, 0);
        Robot a2 = new Robot(14, 4, North, 0);
        Robot b1 = new Robot(15, 6, North, 0);
        Robot c1 = new Robot(16, 7, North, 0);
//        Robot d1 = new Robot(15, 8, North, 0);
        Robot e1 = new Robot(15, 13, North, 0);
        Robot f1 = new Robot(15, 18, North, 0);
        karel.moveTill();

        assertEquals(true, f1.nextToARobot());
        assertEquals(true, karel.nextToABeeper());
    }

   public  void testMoveToBeeperStackAndTurn()
   {
        FunctionRobot_4 karel = new FunctionRobot_4(11, 7, West, 1);
        karel.moveToBeeperStackAndTurn();

        assertEquals(true, karel.facingWest());
        assertEquals(true, karel.nextToABeeper());
    }
    
    static {
        World.reset();
        World.readWorld("function4.kwld"); 
//        World.setBeeperColor(Color.magenta);
//        World.setStreetColor(Color.blue);
//        World.setNeutroniumColor(Color.green.darker().darker());
         World.setDelay(1);  
         World.setVisible(true);

    }
}