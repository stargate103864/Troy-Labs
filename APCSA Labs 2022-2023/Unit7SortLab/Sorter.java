/**
 * @author:
 * 
 * note: Some of the methods below are for you to complete.
 */

import java.util.Arrays; // to use the built in sort for Comparable[]

public final class Sorter 
{

    // This method is complete.
    // Use the sort in the Arrays class from Java. Also, use the 
    // StopWatch to return how long it took to sort the vector.
    public static long sortViaJavaArraysClass(Comparable vec[]){
        StopWatch timer = new StopWatch();
        timer.start();

        Arrays.sort(vec);

        timer.stop();
        return timer.getElapsedTime();
    }

    /** You implement these three methods using the algorithms/code
     * given in class. You may not, of course, use and pre-written library sorts!
     */

    public static long sortViaInsertion(Comparable vec[]){
        StopWatch timer = new StopWatch();
        timer.start();
        Comparable newCom = vec[0];
        for (int i = 1; i < vec.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (vec[i].compareTo(vec[j]) < 0)
                {
                    newCom = vec[i];
                    for (int x = i; x > j; x--)
                    {
                        vec[x] = vec[x - 1];
                    }
                    vec[j] = newCom;
                }
            }
        }

        timer.stop();
        return timer.getElapsedTime();
    }

    public static long sortViaSelection(Comparable vec[]){
        StopWatch timer = new StopWatch();
        timer.start();
        Comparable min, temp;
        int ind;
        for (int a = 0; a < vec.length - 1; a++)
        {
            min = vec[a];
            ind = a;
            for (int j = a; j < vec.length; j++)
            {
                if (vec[j].compareTo(min) < 0)
                {
                    ind = j;
                    min = vec[j];
                }
            }
            temp = vec[a];
            vec[a] = min;
            vec[ind] = temp;
        }

        timer.stop();
        return timer.getElapsedTime();
    }

    public static long sortViaMerge(Comparable vec[]){
        StopWatch timer = new StopWatch();
        timer.start();
        Comparable min, temp;
        int ind;
        for (int a = 0; a < vec.length - 1; a++)
        {
            min = vec[a];
            ind = a;
            for (int j = a; j < vec.length; j++)
            {
                if (vec[j].compareTo(min) < 0)
                {
                    ind = j;
                    min = vec[j];
                }
            }
            temp = vec[a];
            vec[a] = min;
            vec[ind] = temp;
        }

        timer.stop();
        return timer.getElapsedTime();
    }
}