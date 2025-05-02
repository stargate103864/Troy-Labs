
import java.util.ArrayList;
/**
 * The test class Warm01Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentName_Warm01Test extends junit.framework.TestCase
{
    

    public void testFindPosOfLargest00()
    {
        assertEquals(2, Warm01.findPosOfLargest(new int [] {2,4,5,1}));
    }
    
    public void testFindPosOfLargest01()
    {
        assertEquals(3, Warm01.findPosOfLargest(new int [] {1, 2,4,5}));
    }
    
    public void testFindPosOfLargest02()
    {
        assertEquals(0, Warm01.findPosOfLargest(new int [] {7,1, 2,4,5}));
    }
    
    
    public void testFindPosOfLargest03()
    {
        assertEquals(0, Warm01.findPosOfLargest(new int [] {7,1, 2,4,7}));
    }   
    
    public void testFindPosOfLargest04()
    {
        assertEquals(1, Warm01.findPosOfLargest(new int [] {5,7,7, 7,7 ,7}));
    }
    
    public void testFindLargest00()
    {
        ArrayList <Integer> problem = new ArrayList<Integer> ();
        int [] answer = {4, 2, 3, 1};

        for(int x : answer)
            problem.add(x);
        assertEquals(new Integer(4),Warm01.findLargest(problem));
    }
    
    public void testFindLargest01()
    {
        ArrayList <Integer> problem = new ArrayList<Integer> ();
        int [] answer = {1,-4, 4, 2, 3, 7};

        for(int x : answer)
            problem.add(x);
        assertEquals(new Integer(7),Warm01.findLargest(problem));
    }
    
    public void testFindLargest02()
    {
        ArrayList <Integer> problem = new ArrayList<Integer> ();
        int [] answer = {-400000, -2, -3000, -10000};

        for(int x : answer)
            problem.add(x);
        assertEquals(new Integer(-2),Warm01.findLargest(problem));
    }
    
    public void testFindLargest03()
    {
        ArrayList <Integer> problem = new ArrayList<Integer> ();
        int [] answer = {0, 0, 0};

        for(int x : answer)
            problem.add(x);
        assertEquals(new Integer(0),Warm01.findLargest(problem));
    }
    
    public void testFindLargest04()
    {
        ArrayList <Integer> problem = new ArrayList<Integer> ();
        int [] answer = {-1};

        for(int x : answer)
            problem.add(x);
        assertEquals(new Integer(-1),Warm01.findLargest(problem));
    }

    public void testFindPOArraylist00()
    {
        ArrayList <String> problem = new ArrayList<String> ();
        String [] answer = {"A", "B", "C", "D"};

        for(String x : answer)
            problem.add(x);
        assertEquals(3 ,Warm01.findPosOfLargest(problem));
    }
    
    public void testFindPOArraylist01()
    {
        ArrayList <String> problem = new ArrayList<String> ();
        String [] answer = {"A", "A", "B", "C", "C", "D", "E"};

        for(String x : answer)
            problem.add(x);
        assertEquals(6,Warm01.findPosOfLargest(problem));
    }
    
    public void testFindPOArraylist02()
    {
        ArrayList <String> problem = new ArrayList<String> ();
        String [] answer = {"Z", "A", "A", "B", "C", "C", "D", "E"};

        for(String x : answer)
            problem.add(x);
        assertEquals(0,Warm01.findPosOfLargest(problem));
    }
    
    public void testFindPOArraylist03()
    {
        ArrayList <String> problem = new ArrayList<String> ();
        String [] answer = { "A", "C", "C", "C", "C"};

        for(String x : answer)
            problem.add(x);
        assertEquals(1,Warm01.findPosOfLargest(problem));
    }
    
    public void testFindPOArraylist04()
    {
        ArrayList <String> problem = new ArrayList<String> ();
        String [] answer = {"2"};

        for(String x : answer)
            problem.add(x);
        assertEquals(0,Warm01.findPosOfLargest(problem));
    }
}

