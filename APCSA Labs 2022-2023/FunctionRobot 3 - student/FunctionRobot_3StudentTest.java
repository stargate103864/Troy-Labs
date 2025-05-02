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
public class FunctionRobot_3StudentTest extends junit.framework.TestCase implements Directions
{
   // test wall on side methods

   public  void testWallOnLeftWithWallOnLeftOnly()
   {
        FunctionRobot_3 karel = new FunctionRobot_3(4, 2, North, 0);

        assertEquals(true, karel.wallOnLeft());        
        assertEquals(true, karel.facingNorth());
    }

   public  void testWallOnRightWithWallOnLeftOnly()
   {
        FunctionRobot_3 karel = new FunctionRobot_3(4, 2, North, 0);

        assertEquals(false, karel.wallOnRight());        
        assertEquals(true, karel.facingNorth());
    }

    public  void testWallOnLeftAndWallRightWithWallOnLeftOnly()
   {
        FunctionRobot_3 karel = new FunctionRobot_3(4, 2, North, 0);

        assertEquals(false, karel.wallOnLeftAndWallOnRight());        
        assertEquals(true, karel.facingNorth());
    }

   public  void testWallOnLeftOrWallOnRightWithWallOnLeft()
   {
        FunctionRobot_3 karel = new FunctionRobot_3(4, 9, North, 0);

        assertEquals(true, karel.wallOnLeftOrWallOnRight());        
        assertEquals(true, karel.facingNorth());
    }
    
    static {
        World.reset();
        World.readWorld("function1.kwld"); 
//        World.setBeeperColor(Color.magenta);
//        World.setStreetColor(Color.blue);
//        World.setNeutroniumColor(Color.green.darker().darker());
         World.setDelay(2);  
         World.setVisible(true);

    }
}