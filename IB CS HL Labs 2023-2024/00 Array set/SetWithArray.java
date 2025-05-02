// description of the class
//SetWithArray - 00 Array set
//Ian Havill
//9/26/2023
//Help from Aisheek Ghosh

import java.util.*;

/*
 *   You  may assume all int[] represent a set.  That is, it does NOT contain duplicates and will NOT contain empty elemnts
 */

public class SetWithArray
{
    private int[] x;

    public SetWithArray(int[] num)
    {
        x = num;
    }

    /*
     * returns an Set (array) containing all elements in x OR y
     */
    public int[] union(int[] y)
    {
        ArrayList<Integer> ans = uniquestuff(x,y);
        int[] whyme = new int[ans.size()];
        for(int j = 0; j < whyme.length; j++)
        {
            whyme[j] = ans.get(j);
        }
        return whyme;
    }

    public ArrayList<Integer> uniquestuff (int[] x, int[] y)
    {
        ArrayList<Integer> poop = new ArrayList<Integer>();
        for (int i = 0; i < x.length; i++)
        {
            if (!poop.contains(x[i]))
            {
                poop.add(x[i]);
            }
        }
        for (int i = 0; i < y.length; i++)
        {
            if (!poop.contains(y[i]))
            {
                poop.add(y[i]);
            }
        }
        return poop;
    }

    /*
     * returns an Set (array) containing all elements in x AND y
     * 
     *      if the intersection is empty, return an arrray of length 0
     * 
     */
    public int[] intersection(int[] y)
    {
        int count = 0; //intialize a counter to count the number of intersects
        int index = 0;//intialize a counter to add into the answer array
        //loop through both arrays and increase counter when an intersect is found
        for (int i = 0; i < x.length; i++)
        {
            for(int j = 0; j < y.length; j++)
            {
                if (x[i] == y[j])
                {
                    count++;
                }
            }
        }
        //create the answer array with the length set to the number of intersects
        int[] ans = new int[count];
        //loop through the arrays again and add every intersect into the answer array
        for (int i = 0; i < x.length; i++)
        {
            for(int j = 0; j < y.length; j++)
            {
                if (x[i] == y[j])
                {
                    ans[index] = x[i];
                    index++;
                }
            }
        }
        return ans;
    }

    /*
     * returns an Set (array) containing all elements in x that are not in y
     * 
     *      if the intersection is empty, return an arrray of length 0
     */
    public int[] difference(int[] y)
    {
        int n = 0;
        ArrayList<Integer> xval = new ArrayList<Integer>();
        ArrayList<Integer> yval = new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < x.length; i++)
        {
            xval.add(x[i]);   
        }
        for(int j = 0; j < y.length; j++)
        {
            yval.add(y[j]);   
        }
        for(int p = 0; p < xval.size(); p++)
        {
            if(!yval.contains(xval.get(p)))
            {
                ans.add(xval.get(p));
            }
        }
        int[] ihateschool = new int[ans.size()];
        for(int m = 0; m < ans.size(); m++)
        {
            ihateschool[m] = ans.get(m);   
        }
        return ihateschool;
    }

    /*
     * returns true if all elements of x are contained in y
     */
    public boolean isSubSetOf(int[] y)
    {
        int count = 0;
        for (int i = 0; i < x.length; i++)
        {
            for(int j = 0; j < y.length; j++)
            {
                if(x[i]== y[j])
                {
                    count += 1;
                }
            }
        }
        if (count == x.length)
        {
            return true;
        }
        return false;
    }

    /*
     * returns true if all elements in y are contained in x
     *              and if all elements in x are contained in y
     */
    public boolean isEqualTo(int[] y)
    {
        int count = 0;
        if(isSubSetOf(y))
        {
            count++;
        }
        int naeee = 0;
        for (int i = 0; i < x.length; i++)
        {
            for(int j = 0; j < y.length; j++)
            {
                if(x[i]== y[j])
                {
                    naeee += 1;
                }
            }
        }
        if (naeee == x.length)
        {
            count++;
        }
        if(x.length == y.length){count++;}
        return (count == 3);
    }

    /*
     * returns the set of elements which are in one of the set
     *         that is:  (x - y) union (y - x)
     * 
     *      if the union is empty, return an arrray of length 0
     */
    public int[] symmetricDifference(int[] y)
    {
        int n = 0;
        ArrayList<Integer> xval = new ArrayList<Integer>();
        ArrayList<Integer> yval = new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < x.length; i++)
        {
            xval.add(x[i]);   
        }
        for(int j = 0; j < y.length; j++)
        {
            yval.add(y[j]);   
        }
        for(int p = 0; p < xval.size(); p++)
        {
            if(!yval.contains(xval.get(p)))
            {
                ans.add(xval.get(p));
            }
        }
        for (int p = 0; p < yval.size(); p++)
        {
            if (!xval.contains(yval.get(p)))
            {
                ans.add(yval.get(p));
            }
        }
        int[] ihateschool = new int[ans.size()];
        for(int m = 0; m < ans.size(); m++)
        {
            ihateschool[m] = ans.get(m);   
        }
        return ihateschool;
    }

    /*
     * returns true if all the collection sets in s form a partition of x
     *         you may assume that x is a universal set.
     *         
     *         You might have to look up the definition of a partition and 
     */
    public boolean isPartition(List<int[]> s)
    {
        ArrayList<Integer> xvals = new ArrayList<Integer>();
        ArrayList<Integer> total = new ArrayList<Integer>();
        for (int[] k: s){
            for (int c : k){
                total.add(c);
            }
        }
        for (int i = 0; i < x.length; i++){
            xvals.add(x[i]);
        }
        if (total.size() != xvals.size()){return false;}
        for(int i = 0; i < xvals.size(); i++){
            if (total.contains(xvals.get(i))){
                total.remove(xvals.get(i));
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
