import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentTest extends junit.framework.TestCase
{
   public void testPixelIsMostlyRed01()
   {
      Pixel p = new Pixel(0, 0, 0);
      assertEquals(false, p.mostlyRed());
   }

   public void testColorMonitorNumMostlyRed01()
   {
      ColorMonitor m = new ColorMonitor(2, 4);
      m.setPixel(0, 0, new Pixel(10, 20, 30));
      m.setPixel(0, 1, new Pixel(10, 20, 30));
      m.setPixel(0, 2, new Pixel(10, 20, 30));
      m.setPixel(0, 3, new Pixel(10, 20, 30));

      m.setPixel(1, 0, new Pixel(10, 20, 30));
      m.setPixel(1, 1, new Pixel(10, 22, 34));
      m.setPixel(1, 2, new Pixel(10, 20, 30));
      m.setPixel(1, 3, new Pixel(10, 20, 30));

      assertEquals(0, m.numMostlyRed());
   }

   public void testColorMonitorGetPixel01()
   {
      ColorMonitor m = new ColorMonitor(2, 4);
      m.setPixel(0, 0, new Pixel(10, 20, 30));
      m.setPixel(0, 1, new Pixel(10, 20, 30));
      m.setPixel(0, 2, new Pixel(10, 20, 30));
      m.setPixel(0, 3, new Pixel(10, 20, 30));

      m.setPixel(1, 0, new Pixel(10, 20, 30));
      m.setPixel(1, 1, new Pixel(10, 22, 34));
      m.setPixel(1, 2, new Pixel(10, 20, 30));
      m.setPixel(1, 3, new Pixel(10, 20, 30));

       Pixel p = m.getPixel(1,1);
       assertEquals(10, p.getRed());
       assertEquals(22, p.getGreen());
       assertEquals(34, p.getBlue());

       p = m.getPixel(1,3);
       assertEquals(10, p.getRed());
       assertEquals(20, p.getGreen());
       assertEquals(30, p.getBlue());
    }

   public void testColorMonitorDarken01()
   {
      ColorMonitor m = new ColorMonitor(2, 4);
      m.setPixel(0, 0, new Pixel(10, 20, 30));
      m.setPixel(0, 1, new Pixel(10, 20, 30));
      m.setPixel(0, 2, new Pixel(10, 20, 30));
      m.setPixel(0, 3, new Pixel(10, 20, 30));

      m.setPixel(1, 0, new Pixel(10, 20, 30));
      m.setPixel(1, 1, new Pixel(10, 22, 34));
      m.setPixel(1, 2, new Pixel(10, 20, 30));
      m.setPixel(1, 3, new Pixel(10, 20, 30));

       Pixel p = m.getPixel(1,1);

      m.darken(10);
      p = m.getPixel(1,1);
      assertEquals(10, p.getRed());
      assertEquals(22+5, p.getGreen());
      assertEquals(34+10, p.getBlue());
   }

   public void testIsBrightSpot01()
   {
      ColorMonitor m = new ColorMonitor(3, 4);
      m.setPixel(0, 0, new Pixel(11, 12, 230));
      m.setPixel(0, 1, new Pixel(11, 206, 223));
      m.setPixel(0, 2, new Pixel(210, 201, 213));
      m.setPixel(0, 3, new Pixel(201, 51, 91));

      m.setPixel(1, 0, new Pixel(11, 192, 230));
      m.setPixel(1, 1, new Pixel(211, 196, 3));  // bright spot
      m.setPixel(1, 2, new Pixel(21, 51, 153));
      m.setPixel(1, 3, new Pixel(251, 96, 52));  // bright spot

      m.setPixel(2, 0, new Pixel(11, 196, 220));
      m.setPixel(2, 1, new Pixel(201, 206, 223));
      m.setPixel(2, 2, new Pixel(209, 125, 153));
      m.setPixel(2, 3, new Pixel(201, 51, 110));

      assertEquals(true, m.isBrightSpot(1, 1));
      assertEquals(true, m.isBrightSpot(1, 3));
      assertEquals(false, m.isBrightSpot(1, 2));
   }
}