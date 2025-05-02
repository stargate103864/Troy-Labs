////////////////////////////////////////////////////////////////////////////
//
//    H. Donald Allen            
//
//    Purpose         :  Hannah Counter.
//
//    Interface     :  None
//
//    Side-effects  :  None
//
////////////////////////////////////////////////////////////////////////////
/**
 * Write a description of class TearCalculator here.
 * 
 * @author Don Allen 
 * @version (a version number or a date)
 */
public class WordCounter
{
    // instance variables - replace the example below with your own
    private String[] myLetters;

    /**
     * Constructor for objects of class TearCalculator
     */
    public WordCounter(String[] letters)
    {
        myLetters = letters;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int countEmAll(String target)
    {
        int ans = 0;
        for (int i = 0; i < myLetters.length; i++){
            for (int j = 0; j < myLetters[i].length(); j++){
                ans+= countWord(0,i,j,target);
            }
        }
        return ans;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    private int countWord(int total, int row, int col, String target)
    {
        char womp = target.charAt(0);
        if(myLetters[row].charAt(col)==womp){
            if(target.length() == 1){
                return ++total;
            }
            for(int c = col-1; c<= col+1; c++){
                for(int r = row-1; r<=row+1; r++){
                    if(r >=0 && c>=0 && r < myLetters.length && c<myLetters[r].length() && (c!=col || r!= row)){
                        total = countWord(total, r,c,target.substring(1));
                    }
                }
            }
        }
        return total;
    }
}