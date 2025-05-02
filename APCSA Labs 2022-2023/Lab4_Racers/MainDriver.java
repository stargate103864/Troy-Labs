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
       SprinterBot karel = new SprinterBot(1, 1, East, 0);
       karel.runRace();
       HurdlerBot karel2 = new HurdlerBot(3, 1, East, 0);
       karel2.runRace();
       HighHurdlerBot karel3 = new HighHurdlerBot(6, 1, East, 0);
       karel3.runRace();
       SteepleChaserBot karel4 = new SteepleChaserBot(12, 1, East, 0);
       karel4.runRace();
    } 

    static {
        World.reset(); 
        World.readWorld("ch4_2.kwld"); 
        World.setBeeperColor(Color.magenta);
        World.setStreetColor(Color.blue);
        World.setNeutroniumColor(Color.green.darker());
        World.setDelay(5);  
        World.setVisible(true);
    }
}