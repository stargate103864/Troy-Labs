import java.util.*;

public class MysterySolverII
{
  public String mystery6(String input)
  {
      StringTokenizer strTok = new StringTokenizer(input);
      String str = new String();
      int sum = 0;
      while(strTok.hasMoreTokens())
      {
          sum += Integer.parseInt(strTok.nextToken());
          str += sum + " ";
      }
      return str.substring(0,str.length()-1);
  }

  public String mystery7(String input)
  {
      StringTokenizer strTok = new StringTokenizer(input);
      int sum = 0;
      String ans = new String();
      while(strTok.hasMoreTokens())
      {
          sum += Integer.parseInt(strTok.nextToken());
          for(int i = 0;i<sum-1;i++)
          {
              ans += sum + " ";
          }
          ans+= sum + "\n";
      }
      return ans.substring(0,ans.length()-1);
  }
  
  public String mystery8(String input)
  {
      StringTokenizer strTok = new StringTokenizer(input);
      String str = new String();
      Stack<String> s = new Stack<>();
      int sum = 0;
      while(strTok.hasMoreTokens())
      {
          s.push(strTok.nextToken());
      }
      while(!s.empty())
      {
          sum += Integer.parseInt(s.pop());
          str += sum + " ";
      }
      return str.substring(0,str.length()-1);
  }
  
  public String mystery9(String input)
  {
      StringTokenizer strTok = new StringTokenizer(input);
        Stack<String> s = new Stack<>();
      Queue<String> q = new LinkedList<>();
      String str = new String();
      while(strTok.hasMoreTokens())
      {
          String temp = strTok.nextToken();
          if(Integer.parseInt(temp)%2 == 1)
          {
              q.add(temp);
          }
          else
          {
              s.push(temp);
          }
      }
      while(!q.isEmpty())
      {
          str += q.remove() +" ";
      }
      while(!s.empty())
      {
          str += s.pop() + " ";
      }
      return str.substring(0,str.length()-1);
  }
  
  public String mysteryF(String input)
  {
    String str = new String();
    int first = 1;
    int second = 1;
    int temp = 0;
    str += "1 1";
    for(int i = 0;i<Integer.parseInt(input)-2;i++)
    {
        temp = first+second;
        first=second;
        str += " " + (second=temp);
    }
    return str;
  }
}