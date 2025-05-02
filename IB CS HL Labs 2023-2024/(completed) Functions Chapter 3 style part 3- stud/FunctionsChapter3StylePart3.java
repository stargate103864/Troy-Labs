/*    implement ALL the methods in this class.
 * 
 *    
 *    This project is based on Chapter 3, section 5, Matrices of Relations
 *    
 *    Good luck
 */

import java.util.*;
import java.lang.Math;
/**
 *
 * @author  
 * @version (a version number or a date)
 */
/*
 *    For this project, you may assume all int[][] have square dimensions
 *    
 *    Remember to not change the parameter!!!!!!!!!
 */
public class FunctionsChapter3StylePart3
{
    /*
     *    add the fewest 1s to copy of matrix m so that the copy is reflexive 
     *    
     *    Remember to not change the parameter!!!!!!!!!
     */
    public static int[][] makeItReflexive(int[][] m)
    {
        int ans[][] = new int[m.length][m[0].length];
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                if(i == j){
                    ans[i][j] = 1;
                }
                else{
                    ans[i][j] = m[i][j];
                }
            }
        }
        return ans;
    }

    /*
     *    add the fewest 1s to copy of matrix m so that the copy is symmetric 
     *    
     *    Remember to not change the parameter!!!!!!!!!
     */
    public static int[][] makeItSymmetric(int[][] m)
    {  
        int ans[][] = new int[m.length][m[0].length];
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                if(i != j){
                    if(m[i][j] == 1){
                        ans[j][i] = 1;
                        ans[i][j] = 1;
                    }

                }
                else
                {
                    ans[i][j] = m[i][j];
                }

            }
        }
        return ans;
    }

    /*
     *    add the fewest 1s to copy of matrix m so that the copy is transitive 
     *    
     *    Remember to not change the parameter!!!!!!!!!
     */
    public static int[][] makeItTransitive(int[][] m)
    {
        int[][] ans = new int[m.length][m[0].length];

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = m[i][j];
            }
        }

        for (int k = 0; k < m.length; k++) {
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    ans[i][j] = ans[i][j] | (ans[i][k] & ans[k][j]);
                }
            }
        }

        return ans;
    }

    /*
     *    An int[][] is said to have the warrior property if the smallest value in each row is 10 or greater
     *    
     *    return a copy of m (do not change m) with each value less than 10 incresed by 5 until it is 10 or greater
     *    
     *    You may NOT assume m.length == m[0].length.
     *    
     *    Remember to not change the parameter!!!!!!!!!
     */
    public static int[][] makeItAWarrior(int[][] m)
    {
        int ans[][] = new int[m.length][m[0].length];
        for(int r = 0; r < ans.length; r++){
            for (int c = 0; c < ans[0].length; c++){
                ans[r][c] = m[r][c];
            }
        }

        for(int r = 0; r < ans.length; r++){
            for (int c = 0; c < ans[0].length; c++){
                while(ans[r][c] < 10){
                    ans[r][c] += 5;
                }
            }
        }
        return ans;
    }
}

