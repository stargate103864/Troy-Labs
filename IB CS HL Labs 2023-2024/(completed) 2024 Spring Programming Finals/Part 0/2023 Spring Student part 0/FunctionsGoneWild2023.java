import java.util.*;
import java.lang.Math;
/**
 * The test class FunctionsGoneWild2020.
 *
 * @author  Don Allen
 * @version 2023 Wittry Programming contest
 */
public class FunctionsGoneWild2023
{
    /*
     *   n > 1
     */
    public static String f1(int n)
    {
        String num = Integer.toString(n);
        String front = num.substring(0,num.length()/2);;
        String back = num.substring(num.length()/2);
        if(num.length()%2==1){
            back = num.substring(num.length()/2+1);
        }
        if(Integer.valueOf(front)>Integer.valueOf(back)){
            return "FRONT";
        } else if(Integer.valueOf(front)<Integer.valueOf(back)){
            return "BACK";
        }
        return "FRONTBACK";
    }

    /*
     *    Given the String "d3739d0" and the number 60,
     *           return the number that replaces d so that d3739d0 is divisible by 60?
     *    div != 0
     *    
     *    str contains:
     *          at least one non zero digit
     *          str.indexOf("-") < 0;
     *          str may contain more than one d
     */   
    public static int f2(String str ,int div)
    {
        String temp = str; 
        int d = 0;
        temp = temp.replace("d", String.valueOf(d));
        
        while(Integer.valueOf(temp)%div!=0){
            temp = str; 
            d++;
            if(d>9){
                return -1;
            }
            
            temp = temp.replace("d", String.valueOf(d));
        }
        
        
        return d;
    }

    /*
     *    
     */    
    public static int f3(int n)
    {
        if(n>=200){
            if(n%2==0){
                return f3((n*n+21)/5/(n-5))+n/3;
            } else{
                return f3((7*n-13)/3/(n-4)+n/5)+2;
            }
        }
        if(n>50){
            return f3(2*n%(1+n/4))+(2*n+1)/3;
        }
        int ans = 1;
        for(int i=0; i<n%5; i++){
            ans *= Math.abs(n-2);
        }
        return ans;
    }

    public static int f4(int a, int b, int c)
    {
        int ans = 0;
        for(int i=Math.max(a*b-c, a*c-b); i<=Math.min(2*a*b+c, 2*b*c+a);i++){
            ans += 2*c*c*(a+b)/(a+Math.abs(b-c))*i*i;
            ans += Math.max(b,c)*Math.max(a*b,Math.abs(a-c))/Math.max(Math.min(a*c,b*c),Math.min(2*b,3*c))*i;
        }
        return ans;
    }

    public static double f5(String num)
    {
        double dist = 0;
        for(int i=0; i<num.length()-1; i++){
            String firstNum = num.substring(i,i+1);
            String secondNum = num.substring(i+1, i+2);
            if(secondNum.equals("-")){
                num = num.substring(0, i+1) + firstNum + num.substring(i+2); 
                secondNum = firstNum;
            }
            
            int x1 = (Integer.valueOf(firstNum)-1)%3;
            int y1 = (Integer.valueOf(firstNum)-1)/3;
            int x2 = (Integer.valueOf(secondNum)-1)%3;
            int y2 = (Integer.valueOf(secondNum)-1)/3;
            if(firstNum.equals("0")){
                x1 = 1;
                y1 = 3;
            }
            if(secondNum.equals("0")){
                x2 = 1;
                y2 = 3;
            }
            dist += Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1), 0.5);
        }
        return dist;
    }

    public static double f6(double x, double y, double z)
    {
        if(Math.tan(x)>Math.cos((z+Math.PI)/3/y)){
            return Math.log(Math.pow(Math.E, 2*x-y))/Math.log(10);
        } else{
            return Math.PI*Math.log(Math.pow(y,Math.E+z));
        }
    }

    /*
     */
    public static boolean f7(String ms, String sq)
    {
        int counter = 0; 
        for(char c : ms.toCharArray()){
            if(c==sq.charAt(counter)){
                counter++;
            }
            if(counter>=sq.length()){
                return true;
            }
        }
        return false;
    }
    
    public static String deleteWord(String phrase, String index){
        for(char c : index.toCharArray()){
            if(phrase.indexOf(c)!=phrase.length()-1){
                phrase = phrase.substring(0,phrase.indexOf(c)) + phrase.substring(phrase.indexOf(c)+1);
            } else{
                phrase = phrase.substring(0, phrase.indexOf(c));
            }
        }
        return phrase; 
    }

    /*
     *     precondtion:  phrase will only contain:
     *                      Upper case letters
     *                      (Z)ERO, T(W)O, SI(X), FO(U)R, EI(G)HT
     *                      
     *                      (O)NE, T(H)(R)EE, (S)EVEN, (F)IVE
     *                      
     *                      (N)INE
     *                      
     *                   phrase.length() >= 0
     */
    public static String f8(String phrase)
    {
        List<Integer> ans = new ArrayList();
        while(phrase.contains("Z")){
            phrase = deleteWord(phrase, "ZERO");
            ans.add(0);
            System.out.println(phrase);
        }
        while(phrase.contains("W")){
            phrase = deleteWord(phrase, "TWO");
            ans.add(2);
            System.out.println(phrase);
        }
        while(phrase.contains("X")){
            phrase = deleteWord(phrase, "SIX");
            ans.add(6);
            System.out.println(phrase);
        }
        while(phrase.contains("U")){
            phrase = deleteWord(phrase, "FOUR");
            ans.add(4);
            System.out.println(phrase);
        }
        while(phrase.contains("G")){
            phrase = deleteWord(phrase, "EIGHT");
            ans.add(8);
            System.out.println(phrase);
        }
        while(phrase.contains("O")){
            phrase = deleteWord(phrase, "ONE");
            ans.add(1);
            System.out.println(phrase);
        }
        while(phrase.contains("H")){
            phrase = deleteWord(phrase, "THREE");
            ans.add(3);
            System.out.println(phrase);
        }
        while(phrase.contains("S")){
            phrase = deleteWord(phrase, "SEVEN");
            ans.add(7);
            System.out.println(phrase);
        }
        while(phrase.contains("F")){
            phrase = deleteWord(phrase, "FIVE");
            ans.add(5);
            System.out.println(phrase);
        }
        while(phrase.contains("N")){
            phrase = deleteWord(phrase, "NINE");
            ans.add(9);
            System.out.println(phrase);
        }
        Collections.sort(ans);
        
        String ansText = "";
        for(int i=0; i<ans.size(); i++){
            ansText += String.valueOf(ans.get(i));
        }
        return ansText;
    }

    public static boolean f9(boolean x, boolean y, boolean z)
    {
        return x&&!y || !x&&y&&z;
    }

    public static boolean f10(boolean j, boolean k, boolean m, boolean n)
    {
        return j&&k || !m&&n || !j&&m&&!n || !j&&!k&&!n;
    }
}