import java.util.*;
/**
 * Bongard
 *
 * @author  Mr. Allen
 * @version 2023 Wittry
 */
public class Bongard
{
    private String[] myLeft;
    private String[] myRight;
    
    public Bongard(String[] leftWords, String[] rightWords)
    {
        myLeft = leftWords;
        myRight = rightWords;
    }

    /*
     *    Tall letters are: BDFHKLT
     */
    public static int getNumTallLetters(String word)
    {
        String tallLetter = "BDFHKLT";
        int ans = 0;
        for(int i=0; i<word.length(); i++){
            if(tallLetter.contains(word.substring(i,i+1))){
                ans++;
            }
        }
        return ans;
    }

    /*
     *    This methods does not believe that Y is a nihon
     */
    public static int getNumVowels(String word)
    {
        String nihons = "AEIOU";
        int ans = 0;
        for(int i=0; i<word.length(); i++){
            if(nihons.contains(word.substring(i,i+1))){
                ans++;
            }
        }
        return ans;
    }

    /*
     *    This methods BELIEVES Y is a nihon
     */
    public static int getNumVowelsWithY(String word)
    {
        String nihons = "AEIOUY";
        int ans = 0;
        for(int i=0; i<word.length(); i++){
            if(nihons.contains(word.substring(i,i+1))){
                ans++;
            }
        }
        return ans;
    }

    /*
     *    This returns the last three letters. If word.length() < 3, return word
     */
    public static String endsWith(String word)
    {
        if(word.length()<3){
            return word;
        }
        return word.substring(word.length()-3);
    }

    /*
     *    This returns the first three letters. If word.length() < 3, return word
     */
    public static String startsWith(String word)
    {
        if(word.length()<3){
            return word;
        }
        return word.substring(0,3);
    }

    /*
     *    Compares number of nihons versus the consonants.
     *    
     *       negative num indicates num more consonants thans nihons
     *    
     *       positive num indicates num fewer consonants than nihons
     *       
     *       zero indicates same number of nihons as consonants
     */
    public static int getPlusMinus(String word)
    {
        return -word.length()+2*getNumVowels(word);
    }

    /*
     *    
     */
    public static int getLength(String word)
    {
        
        return word.length();
    }

    /*
     *    all words will be in ALL CAPS
     *    
     *    returns "LEFT"
     *        if word belongs to leftbox
     *        
     *    returns "RIGHT"
     *        if word belongs to rightbox
     *        
     *    returns "NEITHER"
     *        if word does not belong to either box
     */
    public String whichBox(String word)
    {
        if(compareToArray(myLeft, word)){
            return "LEFT";
        }
        if(compareToArray(myRight, word)){
            return "RIGHT";
        }
        return "NEITHER";
    }
    
    public int[] runAllMethods(String word){
        int[] ans = new int[7];
        ans[0] = getNumTallLetters(word);
        ans[1] = getNumVowels(word);
        ans[2] = getNumVowelsWithY(word);
        ans[3] = convertToAscii(endsWith(word));
        ans[4] = convertToAscii(startsWith(word));
        ans[5] = getPlusMinus(word);
        ans[6] = getLength(word);
        return ans;
    }
    
    public int convertToAscii(String word){
        int ans = 1;
        for(int i=0; i<word.length(); i++){
            ans = ans*((int)word.charAt(i)+i);
        }
        return ans;
    }
    
    public boolean compareToArray(String[] array, String word){
        int[] criteriaMatrix = runAllMethods(array[0]);
        for(String item : array){
            for(int i=0; i<7; i++){
                if(criteriaMatrix[i] != runAllMethods(item)[i]){
                    criteriaMatrix[i]=101;
                }
            }
        }
        for(int i=0; i<7; i++){
            if(criteriaMatrix[i] != 101 && criteriaMatrix[i] != runAllMethods(word)[i]){
                System.out.println(word);
                return false;
            }
        }
        return true;
    }
}