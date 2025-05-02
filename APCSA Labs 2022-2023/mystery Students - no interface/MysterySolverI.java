import java.util.*;

public class MysterySolverI
{
    public String mystery1(String input)
    {
        String str = new String();
        StringTokenizer strTok = new StringTokenizer(input);
        while(strTok.hasMoreTokens())
        {
            str = strTok.nextToken()+" "+str;
        }
        return str.substring(0,str.length()-1);
    }

    public String mystery2(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        Stack<String> s = new Stack<>();
        Queue<String> q = new LinkedList<>();
        String str = new String();
        while(strTok.hasMoreTokens())
        {
            String temp = strTok.nextToken();
            if(Integer.parseInt(temp)%2==1)
            {
                s.push(temp);
            }
            else
            {
                q.add(temp);
            }
        }
        while(!s.empty())
        {
            str += s.pop()+" ";
        }
        while(!q.isEmpty())
        {
            str += q.remove()+" ";
        }
        return str.substring(0,str.length()-1);
    }

    public String mystery3(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String str = new String();
        int temp = 0;
        while(strTok.hasMoreTokens())
        {
            temp = (int)Math.pow(Integer.parseInt(strTok.nextToken()),2);
            str = temp +" "+str;
        }
        return str.substring(0,str.length()-1);
    }

    public String mystery4(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String str = new String();
        int sum = Integer.parseInt(strTok.nextToken());
        str += sum;
        while(strTok.hasMoreTokens())
        {
            str = (sum *= Integer.parseInt(strTok.nextToken())) + " "+str;
        }
        return str;
    }

    public String mystery5(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String str = new String();
        int sum = Integer.parseInt(strTok.nextToken());
        str += sum;
        while(strTok.hasMoreTokens())
        {
            str += " " + (sum *= Integer.parseInt(strTok.nextToken()));
        }
        return str;
    }
}