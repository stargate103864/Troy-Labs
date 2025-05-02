
/**
 * Implement a class Date whose constructor receives the String with 
 * the month / the day / the year   
 * example "7/20/1969"
 * Supply methods getDayOfWeek.
 * The getDayOfWeek method return the name of the day of the week for the date.
 * Zeller's Rule
 * 
 * The following formula is named Zeller's Rule after a Reverend Zeller. 
 * [x] means the greatest integer that is smaller than or equal to x. 
 * You can find this number by just dropping everything after the decimal point. 
 * For example, [3.79] is 3. Here's the formula:
 * 
 *       f = k + [(13*m-1)/5] + D + [D/4] + [C/4] - 2*C.
 *       
 * k is the day of the month. Let's use 1/29/2064 as an example. 
 *                              For this date, k = 29.
 * m is the month number. Months have to be counted specially 
 *                              for Zeller's Rule: March is 1, April is 2, 
 *                              and so on to February, which is 12. 
 *                              In our example, m = 11.
 * D is the last two digits of the year. Because in our example we are using
 *                              January (see previous bullet) D = 63 even 
 *                              though we are using a date from 2064.
 * C stands for century: it's the first two digits of the year. 
 *                              In our case, C = 20.
 * 
 * Once we have found f, we divide it by 7 and take the remainder. 
 * Note that if the result f can be negative.
 * 
 * A remainder of 0 corresponds to Sunday, 
 * 1 means Monday, etc. 
 * 
 * For our example, 100 / 7 = 14, remainder 2, 
 * so January 29, 2064 will be a Tuesday.
 * 
 * 
 * You are supplied with a DateTest class that will test your Date class 
 * 
 * @author (your name) 
 * @version (a date)
 */

public class Date{
    private static final String [] DAYS ={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private int m;
    private int k;
    private int D; 
    private int C;
    private int f;
    public Date(String str)
    //return it then cut it
    {
        m = Integer.parseInt(str.substring(0, str.indexOf("/")));
        if (m ==1 || m == 2)
        {
            m += 10;
        }
        else
        {
            m -= 2;
        }

        k = Integer.parseInt(str.substring(str.indexOf("/") + 1, str.lastIndexOf("/")));
        
        String fullyear = str.substring(str.lastIndexOf("/")+ 1);
        
        
        D = Integer.parseInt(fullyear.substring(2));
        C = Integer.parseInt(fullyear.substring(0, 2));

        if (m==11||m==12)
        {
            D-=1;
        }
    }
    public String getDayOfWeek()
    {
        f = k + ((13*m-1)/5) + D + (D/4) + (C/4) - 2*C;
        while (f < 7)
        {
            f+= 7;
        }
        return DAYS[f%7];
    }

}