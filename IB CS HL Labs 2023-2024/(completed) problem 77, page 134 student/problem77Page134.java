import java.util.*;
import java.lang.Math;
/**
 * problem77 Page134  Weird String Function
 *
 * @author  
 * @version (a version number or a date)
 */
public class problem77Page134
{
    private String a;
    private String b;
    private String c;
    private String string1;
    private String string2; 
    private String string3;
    /*
     *  domain is an array with three elements
     */
    public problem77Page134(String[] domain)
    {
        a = domain[0];
        b = domain[1];
        c = domain[2];
    }

    /*
     *  y is an array of length 3
     *  returns a String according to the description of problem 77-81 on page 134
     */
    public String weirdStringFunction(String[] y)
    {
        String ans = "";
        if(y[0] == a || y [0] == b || y[0] == c)
        {
            string1="1";
        }
        else
        {
            string1="0";
        }
        if(y[1] == a || y [1] == b || y[1] == c){
            string2="1";
        }
        else{string2 = "0";}
        if(y[2] == a || y [2] == b || y[2] == c){
            string3="1";
        }
        else{string3 = "0";}

        return string1+string2+string3;
    }
}