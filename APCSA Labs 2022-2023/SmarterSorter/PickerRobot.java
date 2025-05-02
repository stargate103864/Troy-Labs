
/**
 * Write a description of class PickerRobot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PickerRobot extends SmartBot
{
    // instance variables - replace the example below with your own
    
    private int myBeeps;
    /**
     * Constructor for objects of class PickerRobot
     */
    public PickerRobot(int st, int ave, Direction dir, int beeps)
    {
        // initialise instance variables
        super(st, ave, dir, beeps);
        myBeeps = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void pickStack(){
        while(nextToABeeper()){
            pickBeeper();
            myBeeps++;
            move();
        }
    }
    public int getCount(){
        return myBeeps;
    }
    public void goHome(){
        goToOrigin();
        faceNorth();
        while(nextToABeeper()){
            move();
        }
    }
}
