import java.util.*;
/**
 * Write a description of class MiscCollectionOfFunMethods here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiscCollectionOfFunMethodsII {

    public static int uglyNumberGetter(int n) {
        int count = 0;
        int num = 1;
        while (count != n)
        {
            while (!isUglyNumber(num))
            {
                num += 1;
            }
            num += 1;
            count += 1;
        }
        return (num - 1);
    }

    public static boolean isUglyNumber(int n)
    {
        while (n%2 == 0)
        {
            n = n/2;
        }
        while (n%3 == 0)
        {
            n = n/3;
        }
        while (n%5 == 0)
        {
            n = n/5;
        }
        return (n==1);
    }

    public  static  void  compact  (Object[] vec, Object item) {
        Object[] ans = new Object[vec.length];
        int index = 0;
        for (int i = 0; i < vec.length; i++)
        {
            if (!(vec[i].equals(item)))
            {
                ans[index] = vec[i];
                index +=1;
            }
        }
        for (int i = 0; i < vec.length; i++)
        {
            vec[i] = ans[i];
        }
    }

    public static String carRentalCode(String licensePlate) {
        int sum = 0;
        String sub = "";
        for (int x= 0; x< licensePlate.length(); x++)
        {
            if ((licensePlate.charAt(x) >= '0' && licensePlate.charAt(x) <= '9'))
            {
                sum += (int) licensePlate.charAt(x) -48;
            }
            else
            {
                sum += (int) licensePlate.charAt(x);
                sub += licensePlate.charAt(x);
            }
        }
        return (char) (65 + sum % 26) + String.valueOf(sum) + sub.toLowerCase();
    }

    public static boolean isPrimeNumber(int n)
    {
        if (n <= 1)
        {
            return false;
        }
        for (int x = 2; x < n; x++)
        {
            if (n % x == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static int[] primeNumberGenerator(int from, int to) {
        int[] ans = new int [2];
        int count = 0;
        for (int i = from; i < to + 1; i++)
        {
            if (isPrimeNumber(i))
            {
                count++;
                ans[1] = i;
            }
        }
        ans[0] = count;
        return ans;
    }

    public String toString() {
        // postcondition:   return a String with YOUR name and class period in it
        return "Ian, 1";
    }

    public static int digsum(int a)
    {
        int ans = 0;
        while (a > 0)
        {
            ans += a %10;
            a = a / 10;
        }
        return ans;
    }
    
   
    
    public static boolean isUnitSummation(int n)
    {
        n = Math.abs(n);
        int temp = n;
        int i = digsum(n) - (temp%10);
        int x = temp % 10;
        return (i == x);
    }

    public static int[] getUnitSummationBetween(int first, int last)
    {
        int count = 0;
        for (int i = first; i < last; i++)
        {
            if (isUnitSummation(i))
            {
                count++;
            }
        }
        int[] ans = new int [count];
        int index = 0;
        for (int x = first; x <= last; x++)
        {
            if (isUnitSummation(x))
            {
                ans[index] = x;
                index++;
            }

        }
        return ans;
    }
}
