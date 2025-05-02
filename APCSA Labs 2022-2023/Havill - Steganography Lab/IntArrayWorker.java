public class IntArrayWorker
{
    /** two dimensional matrix */
    private int[][] matrix = null;

    /**
     *   set matrix to the theMatrix
     *   @param theMatrix the one to use
     */
    public void setMatrix(int[][] theMatrix)
    {
        matrix = theMatrix;
    }

    /**
     *  Method to return the total 
     *  @return the total of the values in the array
     */
    public int getTotal()
    {
        int total = 0;
        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix[0].length; col++)
            {
                total = total + matrix[row][col];
            }
        }
        return total;
    }

    /**
     *  Method to return the total using a nested for-each loop
     *  @return the total of the values in the array
     */
    public int getTotalNested()
    {
        int total = 0;
        for (int[] rowArray : matrix)
        {
            for (int item : rowArray)
            {
                total = total + item;
            }
        }
        return total;
    }

    /**
     *  print the values in the array in rows and columns
     */
    public void print()
    {
        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix[0].length; col++)
            {
                System.out.print( matrix[row][col] + " " );
            }
            System.out.println();
        }
        System.out.println();
    }

    /** 
     *  returns the count of the number of times the
     *  value num is found in matrix
     */
    public int getCount(int num)
    {
        int count = 0;
        for (int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if (matrix[row][col] == num){
                    count++;
                }
            }
        }
        return count;
    }

    /** 
     *  returns the largest value in the matrix
     */
    public int getLargest()
    {
        int max = matrix[0][0];
        for (int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(matrix[row][col] > max){
                    max = matrix[row][col];
                }
            }
        }
        return max;
    }

    /** 
     *  returns the total of all integers in a column col
     */
    public int getColTotal(int col)
    {
        int total = 0;
        for (int row = 0; row < matrix.length; row++){
            total += matrix[row][col];
        }
        return total;
    }

    /** 
     *  returns the number of integers in the matrix
     *       greater than or equal to min
     *       and less than or equal to max
     */
    public int numValuesBetween(int min, int max)
    {
        int count = 0;
        for (int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if (matrix[row][col] >= min && matrix[row][col] <= max){
                    count++;
                }
            }
        }
        return count;
    }

    /** 
     *  returns true if num has the Cool property, false otherwise
     *  
     *  An integer has the Cool property if it satisfies exactly two of the following three conditions
     *  
     *  a) num is divisible by 11 or 17 (yes, 0 is divisible by both 11 and 17)
     *  b) num is positive (> 0) and contains 2 or more different digits
     *  c) The digit in the one’s place values does NOT occur in the rest of the number.
     *  
     */
    public boolean isCoolNumber(int num)
    {
        int count = 0;
        if (num == 0 || (num % 11 == 0 || num % 17 == 0)){
            count++;
        }
        if (num > 0){
            boolean b1 = false;
            boolean b2 = true;
            String numStr = Integer.toString(num);
            for (int i = 0; i < numStr.length() - 1; i++){
                if (numStr.charAt(i) != numStr.charAt(i+1)){
                    for (int j = i+1; j < numStr.length(); j++){
                        if(numStr.charAt(j) != numStr.charAt(i)){
                            b1 = true;
                        }
                    }
                }
            }
            
            int onesDigit = num % 10;
            int restOfNum = num / 10;
            while (restOfNum > 0){
                int digit = restOfNum % 10;
                if (digit == onesDigit){
                    b2 = false;
                }
                restOfNum /= 10;
            }
            if (b1){
                count ++;
            }
            if (b2){
                count++;
            }
        }
        return (count == 2);
    }

    /** 
     *  returns the index of the Column with the most number with the Cool Property
     *  
     *  if more than one columns tie for the most, return the index of any column with the most
     *  
     */
    public int getBestCoolColumn()
    {
        int maxCoolCount = 0;
        int bestColumnIndex = -1;
        
        for (int j = 0; j < matrix[0].length; j++){
            int coolCount = 0;
            
            for (int i = 0; i < matrix.length; i++){
                int currentNumber = matrix[i][j];
                if (isCoolNumber(currentNumber)){
                    coolCount++;
                }
            }
            if (coolCount > maxCoolCount){
                maxCoolCount = coolCount;
                bestColumnIndex = j;
            }
        }
        return bestColumnIndex;
    }
}