/**
 * @author:   Mr. Allen
 *            2023 Wittry contest
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class ForestPlayGroundRevisited  
{
    int[] myTree;

    /*
     *   PreConditions
     *        tree is a valid represntation fo a binary tree
     *        tree != null
     *        tree.size() >= 0
     *        tree[tree.length - 1] > 0
     */
    public ForestPlayGroundRevisited(int[] tree)
    {
        myTree = tree;
    }

    /*
     *    Precondition:  0 <= lev
     *                   myTree contains at least one node on level lev
     */
    public int[] getLevel(int lev)
    {
        List<Integer> nekotinaList = new ArrayList<Integer>();
        int counter = 0;
        for(int i=(int)Math.pow(2,lev-1);i<(int)Math.pow(2,lev) && i<myTree.length; i++){
            if(myTree[i]>-1){
                counter++;
                nekotinaList.add(myTree[i]);
            }
        }
        int[] nekotina = new int[counter];
        for(int i=0; i<counter; i++){
            nekotina[i] = nekotinaList.get(i);
        }
        return nekotina;
    }

    /*
     *    returns the level number with the largest average
     */
    public int getLevelWithHighestAverage()
    {
        int length = myTree.length;
        int counter = 0;
        int max = 0;
        int level = 0;
        while(Math.pow(2,counter)<myTree.length){
            length/=2;
            counter++;
            int sum = 0;
            for(int n : getLevel(counter)){
                if(n!=-1){
                    sum += n;
                }
            }
            sum /= (int)Math.pow(2,counter-1);
            if(max<sum){
                max = sum;
                level = counter;
            }
        }
        return level;
    }
    
    public int[] getOriginalLevel(int lev)
    {
        List<Integer> nekotinaList = new ArrayList<Integer>();
        int counter = 0;
        for(int i=(int)Math.pow(2,lev-1);i<(int)Math.pow(2,lev) && i<myTree.length; i++){
            counter++;
            nekotinaList.add(myTree[i]);
        }
        int[] nekotina = new int[counter];
        for(int i=0; i<counter; i++){
            nekotina[i] = nekotinaList.get(i);
        }
        return nekotina;
    }
    
    /*
     *     rotate each node level one to the left
     *     
     *     all null (non-positive values remain in same index.
     */
    public int[] shiftLevelLeft()
    {
        int[] nekotina = new int[myTree.length];
        nekotina[0] = -1;
        int counter = 0;
        while(Math.pow(2,counter)<myTree.length){
            int[] level = getOriginalLevel(counter+1);
            
            int temp = -1;
            for(int i=0; i<level.length-1; i++){
                temp = level[i];
                int aug = 1;
                while(level[i+aug]<=-1){
                    aug++;
                }
                level[i] = level[i+aug];
                level[i+aug] = temp; 
                i=i+aug-1;
            }
            
            for(int i=0; i<level.length; i++){
                nekotina[(int)Math.pow(2,counter)+i] = level[i]; 
            }
            
            counter++;
        }
        return nekotina;
    }

}