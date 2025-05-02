
/**
 * Write a description of class PutterRobot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PutterRobot extends SmartBot
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class PutterRobot
     */
    public PutterRobot(int st, int ave, Direction dir, int beeps)
    {
        // initialise instance variables
        super(st, ave, dir, beeps);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void putStack(){
        while(anyBeepersInBeeperBag()){
            putBeeper();
            move();
        }
    }
    public void goHome(){
        goToOrigin();
        faceNorth();
        while(nextToABeeper()){
            move();
        }
    }
}
