import java.lang.*;
import java.util.*;
/**
 * @author  Don Allen
 * @version 2021 Wittry Contest
 */
public class nConnected
{
    /*
     *   nya != null
     *   
     */
    public static int getNConnected(String nya)
    {
        char prev = nya.charAt(0);
        int nyaeak = 0;
        int max = 0;
        for(char c : nya.toCharArray()){
            if(c==prev){
                nyaeak++;
            } else{
                if(nyaeak>max){
                    max = nyaeak;
                }
                nyaeak = 1;
                prev = c;
            }
        }
        if(nyaeak>max){
            max = nyaeak;
        }
        return max;
    }

    /*
     *   nya != null
     *   k > 0
     */
    public static String rotateKitems(String nya, int k)
    {
        String temp = nya.substring(k) + nya.substring(0,k);
        int max = getNConnected(temp);
        String ans = temp;
        while(!temp.equals(nya)){
            temp = temp.substring(k) + temp.substring(0,k);
            if(getNConnected(temp)==max){
                if(temp.compareTo(ans)<0){
                    ans = temp;
                }
            }
            if(getNConnected(temp)>max){
                max = getNConnected(temp);
                ans = temp;
            }
        }
        
        return ans;
    }

}