import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import kareltherobot.*;
/**
 * The test class FunctionRobot_3Test.
 *
 * @author  Coglianese      
 * @version (a version number or a date)
 */
public class FunctionRobotUpdate_3Test implements Directions
{
    /**
     * Default constructor for test class FunctionRobot_3Test
     */
    public FunctionRobotUpdate_3Test()
    {
    }

      @Test
    public  void testWallOnLeftWithWallOnLeftOnly()
    {
        FunctionRobot_3 karel = new FunctionRobot_3(4, 2, North, 0);

        assertEquals(true, karel.wallOnLeft());        
        assertEquals(true, karel.facingNorth());
    }

    @Test
    public  void testWallOnRightWithWallOnLeftOnly()
    {
        FunctionRobot_3 karel = new FunctionRobot_3(4, 2, North, 0);

        assertEquals(false, karel.wallOnRight());        
        assertEquals(true, karel.facingNorth());
    }

    @Test
    public  void testWallOnLeftAndWallRightWithWallOnLeftOnly()
    {
        FunctionRobot_3 karel = new FunctionRobot_3(4, 2, North, 0);

        assertEquals(false, karel.wallOnLeftAndWallOnRight());        
        assertEquals(true, karel.facingNorth());
    }

    @Test
    public  void testWallOnLeftOrWallOnRightWithWallOnLeft()
    {
        FunctionRobot_3 karel = new FunctionRobot_3(4, 9, North, 0);

        assertEquals(true, karel.wallOnLeftOrWallOnRight());        
        assertEquals(true, karel.facingNorth());
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        World.reset();
        World.readWorld("function1.kwld"); 
        //        World.setBeeperColor(Color.magenta);
        //        World.setStreetColor(Color.blue);
        //        World.setNeutroniumColor(Color.green.darker().darker());
        World.setDelay(2);  
        World.setVisible(false);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        World.reset();
    }
}
