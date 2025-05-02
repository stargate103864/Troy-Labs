import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * class FunWith1DArrays
 *
 * @author  Don Allen
 * @version 2016 Wittry Contest
 */
public class FunWith1DArrays
{
    /*
     *   A kingkonging has the Vasco property if
     *    1 - The String has a length of 5 or greater.
     *    2 - At least one letter in the String is repeated at least once
     *           (somewhere ? the letters do not need to be adjacent).
     */
    public static boolean hasVasco(String kingkong)
    {
        if(kingkong.length()>=5){
            for(char c : kingkong.toCharArray()){
                if(kingkong.indexOf(c)!=kingkong.lastIndexOf(c)){
                    return true;
                }
            }
        }
        return false;
    }

    /*
     *  An array has the Morath property if:
     *   1 -  The array has 5 elements or more;
     *   2 -  No String appears more than once in the array.
     *   3 -  50% or more of Strings in the array have the Vasco property
     */
    public static boolean isMorath(String[] kingkongs)
    {
        if(kingkongs.length<5){
            return false;      
        }

        for(int i=0; i<kingkongs.length; i++){
            for(int j=i+1; j<kingkongs.length; j++){
                if(kingkongs[i].equals(kingkongs[j])){
                    return false;
                }
            }
        }

        int numVasco = 0; 
        for(String kingkong : kingkongs){
            if(hasVasco(kingkong)){
                numVasco++;
            }
        }
        if(numVasco<(kingkongs.length+1)/2){
            return false;
        }
        return true;
    }

    /*
     *    has737   -  an int array has the 737 property if,
     *                every number which contains a 3 is adjacent to
     *                  (previous AND following) a number that contains 7
     *                That is, if num[ind] contains a 3, and BOTH
     *                    num[ind-1] and num[ind+1] contain a 7,
     *                    then num has the 737 property
     *    The following ints contain a 3:  13, 10003, 59834, -783, 3333, -30
     *    and the following ints contains a 7:  70, -948765, 378, 28974, -7
     *
     *    note     -  if num[ind] contains a 3, and
     *                    if either ind - 1 < 0 or ind + 1 >= num.length,
     *                    then the array does not contains the 737 property
     *    note     -  if no value in num contains a 3,
     *                    then the array num has the 737 property
     *
     *    precondition:  num.length >= 0 (num != null)
     *
     *    note -      if num.length == 0, return true since 
     */
    public static boolean has737(int[] num)
    {
        if(num.length==0){
            return true;
        }
        if(String.valueOf(num[0]).contains("3")){
            return false;
        }
        if(String.valueOf(num[num.length-1]).contains("3")){
            return false;
        }
        for(int i=1; i<num.length-1; i++){
            if(String.valueOf(num[i]).contains("3")){
                if(!String.valueOf(num[i-1]).contains("7") || !String.valueOf(num[i+1]).contains("7")){
                    return false;
                }
            }
        }

        return true;
    }

    /*
     *    remove all occurrences of the digit d, 0 <= d < 10 from the int num.
     *    for example:
     *       186 == removeD(158556, 5)
     *       2168 == removeD(201680, 0)
     *     & -123 == removeD(-123, 5)
     */
    public static int removeD(int num, int d)
    {
        char[] array = String.valueOf(num).toCharArray(); 
        for(int i=0; i<array.length; i++){
            if(array[i]==String.valueOf(d).charAt(0)){
                array[i] = 'a';
            }
        }
        String ans = "";
        for(char c : array){
            if(c!='a'){
                ans += String.valueOf(c);
            }
        }
        if(ans.equals("")){
            return 0;
        }

        return Integer.valueOf(ans);
    }

    /*
     *    returns a List of all the int(s) in the array num which are the largest
     *            after removing the digit d, 0 <= d < 10 from the int
     *
     *    The order of the numbers in the List is not important
     *    You may not alter the array num
     *    You may use your implementation of the method removedD
     *    You may assume num.length() > 0
     */
    public static List<Integer> largestWithOutDigitD(int[] num, int d)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int max = removeD(num[0],d); 
        for(int n : num){
            if(removeD(n,d)==max){
                ans.add(n);
            }
            if(removeD(n,d)>max){
                max = removeD(n,d);
                ans.clear();
                ans.add(n);
            }
        }
        return ans;
    }

    public static int degreeOfInversion(int[] num)
    {
        int ans = 0;
        for(int i=0; i<num.length; i++){
            for(int j=i+1; j<num.length; j++){
                if(num[j]<num[i]){
                    ans++;
                }
            }
        }

        return ans;
    }

    /*
     *    The rank of an element in an array of integers is the number of smaller elements in the array plus
     *    the number of equal elements that appear to its left.
     *    
     *    For example, consider the array [4, 3, 9, 3, 7]. The respective ranks of these elements are 2, 0, 4, 1, and 3;
     *    thus the rank array is the array [2, 0, 4, 1, 3].
     */   
    public static int[] arrayRank(Comparable[] items)
    {
        int[] ans = new int[items.length];
        int rank = 0;
        for(int i=0; i<items.length; i++){
            rank = 0;
            for(Comparable n : items){
                if(n.compareTo(items[i])<0){
                    rank++;
                }
            }
            for(int j=0; j<i; j++){
                if(items[i].compareTo(items[j])==0){
                    rank++;
                }
            }
            ans[i] = rank;
        }

        return ans;
    }
}