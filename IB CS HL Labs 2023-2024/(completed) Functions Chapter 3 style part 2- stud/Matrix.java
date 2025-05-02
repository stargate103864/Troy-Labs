
/**
 * Write a description of class Matrix here.
 * 
 * need Matrix operations
 * 
 * @author Don Allen
 * @version March 2011
 */
public class Matrix
{
    // All methods will be static methods

    /**
     *    Matrix multiplication
     * 
     * @return     matrix x times matrix y 
     */
    public static int[][] product(int[][] x, int[][] y)
    {
        int[][] ans = new int[x.length][y[0].length];   // this is the correct dimension
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                for(int w = 0; w < x[j].length; w++){
                    ans[i][j] += x[i][w] * y[w][j];
                }
            }
        }
        return ans;
    }

    /* 
     *    Set teh diagonal of the Matrix to k
     *    You may assume m.length == m[h].length, 0 <= h < m.length
     */
    public static int[][] setDiagonal(int[][] m, int k)
    {
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                if(i == j){
                    m[i][j] = k;
                }
            }
        }
        return m;

    }
}
