import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * The test class StringSimilarity.
 *
 * @author  Don Allen
 * @version 2015 Wittry Contest
 */
public class FunWith2DArrays
{
/*
 *  0 = up
 *  1 = up and right
 *  2 = right
 *  3 = right and down
 *  4 = down
 *  5 = down and left
 *  6 = left;
 *  7 = up and left
 */
   public static int[][] pathWalk(int size, int startRow, int startCol, int[] walk)
   {
      int ans[][] = new int[size][size];
      ans[startRow][startCol]++;
      for(int w : walk){
          if(w==0){
              startRow = (startRow+size-1)%size;
          }
          if(w==1){
              startRow = (startRow+size-1)%size;
              startCol = (startCol+1)%size;
          }
          if(w==2){
              startCol = (startCol+1)%size;
          }
          if(w==3){
              startRow = (startRow+1)%size;
              startCol = (startCol+1)%size;
          }
          if(w==4){
              startRow = (startRow+1)%size;
          }
          if(w==5){
              startRow = (startRow+1)%size;
              startCol = (startCol+size-1)%size;
          }
          if(w==6){
              startCol = (startCol+size-1)%size;
          }
          if(w==7){
              startRow = (startRow+size-1)%size;
              startCol = (startCol+size-1)%size;
          }
          ans[startRow][startCol]++;
      }
    
      return ans;
   }

/*
 *   return true if num has the Gynn property.
 *      A number has the Gynn property if all the digits of num are either 0, 1, 3, 4, 5, 6, 7 or 8
 *   otherwise rerturn false
 */
   public static boolean hasGynnProperty(int num)
   {
      ArrayList<String> ngocs = new ArrayList();
      ngocs.add("0");
      ngocs.add("1");
      ngocs.add("3");
      ngocs.add("4");
      ngocs.add("5");
      ngocs.add("6");
      ngocs.add("7");
      ngocs.add("8");
      ngocs.add("-");
      for(char c : String.valueOf(num).toCharArray()){
          if(!ngocs.contains(String.valueOf(c))){
              return false;
          }
      }
      
      return true;
   }

/*
 *   return true if 2D array num has the Gynn property.
 *   otherwise rerturn false
 */
   public static boolean hasArrayGynnProperty(int[][] num)
   {       
      for(int r=0; r<num.length; r++){
          int mengCount = 0;
          for(int c=0; c<num[r].length; c++){
              if(hasGynnProperty(num[r][c])){
                  mengCount++;
              }
          }
          if(mengCount<=num[r].length/2){
              
              for(int c=0; c<num[0].length; c++){
                  mengCount = 0;
                  for(int r2=0; r2<num.length; r2++){
                      if(hasGynnProperty(num[r2][c])){
                          mengCount++;
                      }
                  }
                  if(mengCount<=num.length/2){
                      return false;
                  }     
              }
              
          }
      }

      return true;
   }

/*
 *   return true if 2D array num has the Super Gynn property.
 *   otherwise rerturn false
 */
   public static boolean hasArraySuperGynnProperty(int[][] num)
   {
      for(int r=0; r<num.length; r++){
          int mengCount = 0;
          for(int c=0; c<num[r].length; c++){
              if(hasGynnProperty(num[r][c])){
                  mengCount++;
              }
          }
          if(mengCount<=num[r].length/2){
              return false;
          }
      }
      for(int c=0; c<num[0].length; c++){
          int mengCount = 0;
          for(int r=0; r<num.length; r++){
              if(hasGynnProperty(num[r][c])){
                  mengCount++;
              }
          }
          if(mengCount<=num.length/2){
              return false;
          }
      }

      return true;
   }
}