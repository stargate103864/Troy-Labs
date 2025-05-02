/**
@Author:
Date:
Teacher:
Lab:
Misc:
 */
import kareltherobot.*;
import java.awt.Color;

public class MainDriver implements Directions
{
    public static void main(String args[])  {
        Carpeter karel = new Carpeter(5, 2, East, infinity);
        WestWallBeeperGetter karel2 = new WestWallBeeperGetter(8, 10, East, 0);
        BeeperMover2 karel3 = new BeeperMover2(3, 11, East, 0);
        int beeps = karel.carpetHallway();
        System.out.println(beeps);
        
        karel2.getBeeper();
        karel3.moveBeepersNorth();
    } 

    static {
        World.reset(); 
        World.readWorld("ch7_recursion.kwld"); 
        World.setBeeperColor(Color.magenta);
        World.setStreetColor(Color.blue);
        World.setNeutroniumColor(Color.green.darker());
        World.setDelay(5);  
        World.setVisible(true);
    }
}