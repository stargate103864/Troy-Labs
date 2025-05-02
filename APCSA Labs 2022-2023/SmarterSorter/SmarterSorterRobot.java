import java.util.*;
/**
 * Write a description of class SmarterSorterRobot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SmarterSorterRobot extends SmartBot
{
    // instance variables - replace the example below with your own
    private int count;
    private PickerRobot[] pickers;
    private PutterRobot[] putters;
    private int[] beepers;
    /**
     * Constructor for objects of class SmarterSorterRobot
     */
    public SmarterSorterRobot(int st, int ave, Direction dir, int beeps)
    {
        // initialise instance variables
        super(st, ave, dir, beeps);
        count  = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void countBeeps(){
        while(nextToABeeper()){
            count++;
            move();
        }
    }
    public void makeBots(){
        pickers = new PickerRobot[count];
        for(int i = 0; i < count; i++){
            pickers[i] = new PickerRobot(1, i + 1, North, 0);
        }
    }
    public void moveBots(){
        for(int i = 0; i < count; i++){
            pickers[i].pickStack();
        }
    }
    public void queryCount(){
        beepers = new int[count];
        for(int i = 0; i < count; i++){
            beepers[i] = pickers[i].getCount();
        }
    }
    public void sortBeepersArray(){
         Arrays.sort(beepers);
         putters = new PutterRobot[beepers.length];
         for(int i = 0; i < beepers.length; i++){
             putters[i] = new PutterRobot(1, i + 1, North, beepers[i]);
         }
    }
    public void placeStacks(){
        for(int i = 0; i < putters.length; i++){
            putters[i].putStack();
        }
    }
    public void goHome(){
        for(int i = 0; i < putters.length; i++){
            putters[i].goHome();
        }
        for(int i = 0; i < pickers.length; i++){
            pickers[i].goHome();
        }
        goToOrigin();
        faceNorth();
        while(nextToABeeper()){
            move();
        }
    }
    public void sortBeepers(){
        countBeeps();
        makeBots();
        moveBots();
        queryCount();
        sortBeepersArray();
        placeStacks();
        goHome();
    }
}
