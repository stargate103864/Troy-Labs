
/**
 * Write a description of class Matrix here.
 * 
 * need Matrix operations
 * 
 * @author Don Allen
 * @version March 2011
 */
public class MatrixPart2
{
/*
 *     preCondition:  m.length == n.length
 *                    m[i].length == n[i].length, 0 <= i < m.length
 */
    public static boolean haveSameNonZeros(int[][] m, int[][] n)
    {
       if(m.length == n.length && m[0].length == n[0].length)
       {
           for(int r = 0; r < n.length; r++){
               for(int c = 0; c < n[0].length; c++){
                   if((m[r][c] != 0 && n[r][c] == 0) || (n[r][c] != 0 && m[r][c] == 0)){
                       return false;
                   }
                                  }
           }
       }
       
       return true;
    }
}