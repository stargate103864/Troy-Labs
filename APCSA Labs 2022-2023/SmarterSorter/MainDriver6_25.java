/**
   @Author:
      Date:	10-02-06
   Teacher:	Coglianese
       Lab: Ch6_25
      Misc: 
  */
import kareltherobot.*;
import java.awt.Color;

public class MainDriver6_25 implements Directions
{
    public static void main(String args[])  
	{
		SmarterSorterRobot alice= new SmarterSorterRobot(1, 1, East, 0);
		alice.sortBeepers();
	}
	
    static {
        World.reset(); 
        World.readWorld("Ch6_25.kwld"); 
        //World.setBeeperColor(Color.magenta);
        //World.setStreetColor(Color.blue);
        //World.setNeutroniumColor(Color.green.darker());
        World.setDelay(4);  
        World.setVisible(true);
    }
}