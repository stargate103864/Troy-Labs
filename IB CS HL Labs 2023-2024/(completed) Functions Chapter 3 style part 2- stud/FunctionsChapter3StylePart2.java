/*    implewment (almost) ALL the methods in this class.
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
public class FunctionsChapter3StylePart2
{
    /*  add your own instance variables   */
    private int[][]matrix;
    public FunctionsChapter3StylePart2(int[][] r)
    {
        matrix = new int[r.length][r[0].length];
        for (int x = 0; x < r.length; x++) {
            for (int y = 0; y < r[0].length; y++) {
                matrix[x][y] = r[x][y];
            }
        }
    }

    public int getNumberRows()
    {
        return matrix.length;
    }

    public int getNumberCols()
    {
        return matrix[0].length;
    }

    /*
     *    replaces the current relation instance variable with r
     *    
     *    YES - this method gets used in the my (stipulator) tester
     */
    public void setRelation(int[][] r)
    {
        matrix = new int[r.length][r[0].length];

        // Copy values from r into the new matrix
        for (int x = 0; x < r.length; x++) {
            for (int y = 0; y < r[0].length; y++) {
                matrix[x][y] = r[x][y];
            }
        }
    }

    /*
     *    returns the current relation instance variable 
     */
    public int[][] getRelation()
    {  
        return matrix;
    }

    /*
     *    retruns the number of Order Pairs in the relation
     *      that is, the number of one's (1) in the Matrix
     */
    public int getSize()
    {
        int ans = 0;
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] == 1) ans++;
            }
        }
        return ans;
    }

    /*
     *    f is a function if
     *       for each x in X, there is exactly one y in Y with (x,y) in f
     *    returns true if the matrix forms a function
     *    returns false otherwise
     */
    public boolean isFunction()
    {
        for (int[]row : matrix) {
            int ans = 0;
            for (int cell : row) {ans += cell;}
            if (ans != 1) return false;
        }
        return true;
    }

    /* 
     *    A function f from X to Y is said to be one to one if 
     *    for each y in Y, there is at most one x in X with f(x) = y
     *
     *    returns true if the matrix is a function and the function is one to one
     *    returns false otherwise
     */
    public boolean is1To1()   // column sum is one for every column
    {
        for (int col = 0; col < matrix[0].length; col++) {
            int ans = 0;
            for (int x = 0; x < matrix.length; x++) {
                ans+= matrix[x][col];
            }
            if (ans > 1) return false;
        }
        return true;
    }

    /*
     *    A function from X to Y is said to be onto if
     *    the range of f == Y
     *
     *    returns true if the matrix is a function and the function is onto
     *    returns false otherwise
     */
    public boolean isOnTo()    // column sum > 0 for all columns
    {
        for (int y = 0; y < matrix[0].length; y++) {
            int ans = 0;
            for (int x = 0; x < matrix.length; x++) {
                ans += matrix[x][y];
            }
            if (ans == 0) return false;
        }
        return true;
    }

    /*
     *     returns true if the matrix is a function and the function is bijective
     *              that is both one to one and onto
     *     returns false otherwise
     */
    public boolean isBijective()
    {
        return isFunction() && isOnTo() && is1To1();
    }

    /*
     *   precondition:  comp is a function.
     *   
     *   returns a new FunctionsChapter3StylePart2 Object.
     *   The domain of the new Object is this.domain
     *   
     *   The coDomain of the new Object is comp.coDomain
     *   
     *   The new function is the composition: relation o b = b ( relation )
     *   
     *   See the tester for more information
     */
    public FunctionsChapter3StylePart2 getComposition(int[][] comp)
    {
        int[][] ans = new int[matrix.length][comp[0].length];
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < comp[0].length; y++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (matrix[x][k] == 1 && comp[k][y] == 1) {
                        ans[x][y] = 1;
                        break;
                    }
                }
            }
        }
        return new FunctionsChapter3StylePart2(ans);
    }

    /*
     *   precondition:  relation is a function.
     *   rel does not have to be both 1-1 and onto
     *   the inverse does not need to be a function
     */
    public int[][] getInverse()
    {
        int[][]ans = new int[matrix[0].length][matrix.length];
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                ans[y][x] = matrix[x][y];
            }
        }
        return ans;
    }

    /*
     * A relation is reflexive if (x, x) in R for every x in X
     * 
     *       returns true if the current relation is reflexive
     *       returns false otherwise
     *       
     *       You should not assume the matrix is a square matrix.
     *       That is, do not assume getNumRows() == getNumCols()
     *       
     *       Or should I say, if getNumRows() != getNumCols(), return false
     */
    public boolean isReflexive()
    {
        if (matrix.length != matrix[0].length) return false;
        for (int x=  0; x < matrix.length; x++) {
            if (matrix[x][x] != 1) return false;
        }
        return true;
    }

    /*
     *       A relation is symmetric if
     *       for all x, y in X, if (x,y) in R, then (y,x) in R
     * 
     *       returns true if the current relation is symmetric
     *       returns false otherwise
     */
    public boolean isSymmetric()
    {
        for (int x=  0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] != matrix[y][x]) return false;
            }
        }
        return true;
    }

    /*
     *       A relation is Antisymmetric if
     *       for all x, y in X, if (x,y) in R, and (y,x) in R, then x = y
     * 
     *    returns true if the current relation is Antisymmetric
     *    returns false otherwise
     */
    public boolean isAntiSymmetric()
    {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] == 1 && matrix[y][x] == 1 && x != y) return false;
            }
        }
        return true;
    }

    /*
     *       A relation is transitive:
     *       if (a,b) and (b,c) then (a,c)
     * 
     *       returns true if the current relation is transitive
     *       returns false otherwise
     */
    public boolean isTransitive()
    {
        for (int x = 0; x < matrix.length; x++) {
            for (int y =0; y < matrix[0].length; y++) {
                if (matrix[x][y] == 1) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        if (matrix[y][k] == 1 && matrix[x][k] != 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /*
     *    returns true is the relation is an Equivalence Relation
     *    returns false otherwise
     */
    public boolean isEquivalenceRelation()
    {
        return isReflexive() && isSymmetric() && isTransitive();
    }

    /* 
     *    returns true is the relation is an Partially Order
     *    returns false otherwise
     */
    public boolean isPartiallyOrder()
    {
        return isReflexive() && isAntiSymmetric() && isTransitive();
    }

    /* 
     *     look at the tester
     *
     *    returns [[a, c, ....d], [...], ...[]]
     */
    public String toString()
    {
        String ans = "[";
        for (int x = 0; x < matrix.length; x++) {
            ans += "[";
            for (int y = 0; y < matrix[0].length; y++) {
                ans += Integer.toString(matrix[x][y]);
                if (y != matrix[0].length - 1) ans += ", ";
            }
            ans += "]";
            if (x != matrix.length-1) ans += ", ";
        }
        return ans + "]";
    }
}