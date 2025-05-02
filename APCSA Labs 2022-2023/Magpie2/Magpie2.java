import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:   
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *             Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
    private Scanner in;
    private ArrayList<String> bonk;
    private ArrayList<String> yeet;
    public Magpie2()
    {
        in = new Scanner (System.in);
    }
    public Magpie2(File f) throws FileNotFoundException
    {
        in = new Scanner(f);
        bonk = new ArrayList<String>();
        yeet = new ArrayList<String>();
    }
    /**
     * Get a default greeting     
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    private String addToMemory()
    {
        System.out.println("What information do you want to remember?");
        String w = in.nextLine();
        bonk.add(w);
        System.out.println("What information do you want to remember?");
        String d = in.nextLine();
        yeet.add(d);
        return("Ok, I'll remember " + d + "about " + w);
    }
    
    private String getFromMemory()
    {
        System.out.println("What item do you want to recall?");
        String w = in.nextLine();
        if (!bonk.contains(w))
            return ("could not find " + w);
        int ind = bonk.indexOf(w);
        return yeet.get(ind);
    }
    
    private void removeFromMemory()
    {
        System.out.println("What item do you want to remove or delete?");
        String w = in.nextLine();
        if(!bonk.contains(w))
        {
            System.out.println("could not find");
            for(int x = 0; x < yeet.size(); x++)
            {
                System.out.println(yeet.get(x));
            }
        }
        else
        {
            yeet.remove(bonk.indexOf(w));
            bonk.remove(bonk.indexOf(w));
            System.out.println("item was deleted");
        }
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if(statement.indexOf("remember") >= 0)
            response = addToMemory();
        else if(statement.indexOf("recall") >= 0)
            response = getFromMemory();
        else if(statement.indexOf("delete") >=0 || statement.indexOf("remove") >= 0)
        {
            removeFromMemory();
        }
        else if (statement.indexOf("no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0
                || statement.indexOf("family") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (statement.indexOf("Computer Science") >= 0)
        {
            response = "Yes, it is my favorite course.";
        }
        else if (statement.indexOf("about yourself") >= 0)
        {
            response = "I was created for the 2015 test.";
        }
        else if (statement.indexOf("liked") >= 0 && statement.indexOf("feared") >=0)
        {
            response = "FEARED.";
        }
        else if (statement.indexOf("questions") >= 0 && statement.indexOf("me") >=0)
        {
            response = "No, I am not interested in humans.";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }

        return response;
    }
}
