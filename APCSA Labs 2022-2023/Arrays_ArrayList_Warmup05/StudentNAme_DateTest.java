

/**
 * The test class DateTest.
 *
 * @author  Coglianese
 * @version 1/9/09
 */
public class StudentNAme_DateTest extends junit.framework.TestCase{


    private static final String [] DAYS ={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public void testDateExample()
    {
        Date da = new Date("7/20/1969");
        assertEquals("Sunday", da.getDayOfWeek());  
        da = new Date("1/9/2009");
        assertEquals("Friday", da.getDayOfWeek());  
    }
    
    public void testFirstWeekOf2006()
    {
        for(int i = 1; i<=7; i++){
            Date da = new Date("1/"+ i +"/2006");
            assertEquals(DAYS[i-1], da.getDayOfWeek());  
        }
    }
    
    public void testLastWeekOf2006()
    {
        for(int i = 0; i < 7; i++){
            Date da = new Date("12/"+ (i+24)  +"/2006");
            assertEquals(DAYS[i], da.getDayOfWeek());  
        }
    }

    public void testFirstWeekOf2009()
    {
        for(int i = 1; i<=7; i++){
            Date da = new Date("1/"+ i +"/2009");
            assertEquals(DAYS[(i+3)%7], da.getDayOfWeek());  
        }
    }    
 
    public void testFirstWeekOf1109()
    {
        for(int i = 7; i<13; i++){
            Date da = new Date("2/"+ i +"/1109");
            assertEquals(DAYS[i%7], da.getDayOfWeek());  
        }
    }
    
    public void testFirstWeekOf1045()
    {
        for(int i = 16; i<23; i++){
            Date da = new Date("2/"+ i +"/1045");
            assertEquals(DAYS[i-16], da.getDayOfWeek());  
        }
    }      
    
}










