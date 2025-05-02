import junit.framework.TestCase;
import java.util.*;

public class StudentMiscCollectionOfFunMethodsTest extends TestCase
{
  public void testCarRentalCode1()
  {
    String problemMsg = "Problem with: carRentalCode";
    String licensePlate = "123ABC456";
    assertEquals(problemMsg, "L219abc", MiscCollectionOfFunMethodsII.carRentalCode(licensePlate));
  }

  public void testGetUnitSummationBetween()
  {
    String problemMsg = "Problem with: isUnitSummation";
    
    ArrayList<Integer> sol = new ArrayList<Integer>();
    sol.add(101);
    sol.add(112);
    sol.add(123);
    sol.add(134);
    sol.add(145);
    sol.add(156);
    sol.add(167);
    sol.add(178);
    sol.add(189);
    int []  ans = MiscCollectionOfFunMethodsII.getUnitSummationBetween(100, 200);
    assertEquals(problemMsg, sol.size(), ans.length);
    for (int num : ans)
    {
       assertEquals(problemMsg, true, sol.contains(new Integer(num)));
       assertEquals(true, sol.remove(new Integer(num)));
    }
  }

  /*    int[] getUnitSummationBetween(int first, int last)  */

  public void testIsUnitSummation()
  {
    String problemMsg = "Problem with: isUnitSummation";
    assertEquals(problemMsg, true, MiscCollectionOfFunMethodsII.isUnitSummation(145));
    assertEquals(problemMsg, false, MiscCollectionOfFunMethodsII.isUnitSummation(146));
  }

  public void testIsUglyNumber()
  {
    String problemMsg = "Problem with: isUglyNumber";
    assertEquals(problemMsg, true, MiscCollectionOfFunMethodsII.isUglyNumber(2*2*3*3*3*5*5*5));
    assertEquals(problemMsg, false, MiscCollectionOfFunMethodsII.isUglyNumber(2*2*3*3*3*5*5*5*11));
  }

  public void testUglyNumberGetter()
  {
    String problemMsg = "Problem with: uglyNumberGetter";
    int n = 6;
    assertEquals(problemMsg, 6, MiscCollectionOfFunMethodsII.uglyNumberGetter(n));
  }
  
  public void testCompact()
  {
    String problemMsg = "Problem with: compact";
    Object[] vec = { "A", "B", "C" };
    Object item = "B";
    MiscCollectionOfFunMethodsII.compact(vec, item);

    boolean flag = (vec[0].equals("A")) && (vec[1].equals("C")) && (vec[2] == null);

    assertEquals(problemMsg, true, flag);
  }
  public void testPrimeNumberGenerator01()
  {
    String problemMsg = "Problem with: primeNumberGenerator01";
    int from = 5;
    int to = 7;
    int[] vec = MiscCollectionOfFunMethodsII.primeNumberGenerator(from, to);

    boolean flag = (vec[0] == 2) && (vec[1] == 7);
    assertEquals(problemMsg, true, flag);
  }

  public void testPrimeNumberGenerator()
  {
    String problemMsg = "Problem with: primeNumberGenerator";
    int from = 5;
    int to = 99;
    int[] vec = MiscCollectionOfFunMethodsII.primeNumberGenerator(from, to);

    boolean flag = (vec[0] == 23) && (vec[1] == 97);
    assertEquals(problemMsg, true, flag);
  }

  public void testSumDigits(Integer i) {
    String problemMsg = "Problem with: sumDigits";
    int digits = 123456;
    assertEquals(problemMsg, 21, MiscCollectionOfFunMethodsI.sumDigits(Integer.valueOf(digits)));
  }

  public void testIsDivisibleBy9_0(Integer i) {
    String problemMsg = "Problem with: isDivisibleBy9";
    int digits = 123456;
    assertEquals(problemMsg, true, MiscCollectionOfFunMethodsI.isDivisibleBy9(Integer.valueOf(digits)));
  }

  public void testSumDigits0()
  {
    assertEquals(6, MiscCollectionOfFunMethodsI.sumDigits(Integer.valueOf(123)));
  }

  public void testIsDivisibleBy9_0()
  {
    assertEquals(true, MiscCollectionOfFunMethodsI.isDivisibleBy9(Integer.valueOf(9)));
  }

  public void testAverage0()
  {
    int[] a = { 1, 2, 3 };
    assertEquals(2.0, MiscCollectionOfFunMethodsI.average(a), 0.01);
  }

  public void testToString()
  {
    MiscCollectionOfFunMethodsI miscColl1 = new MiscCollectionOfFunMethodsI();
    assertEquals("You should change your tester so it says Ian, 1", miscColl1.toString());
  }

  public void testStdDev0()
  {
    assertEquals(0.8165, MiscCollectionOfFunMethodsI.standardDeviation(new int[] { 1, 2, 3 }), 0.01);
  }

  public void testIsDivisibleBy9_1()
  {
    assertEquals(false, MiscCollectionOfFunMethodsI.isDivisibleBy9(Integer.valueOf(7)));
  }
}