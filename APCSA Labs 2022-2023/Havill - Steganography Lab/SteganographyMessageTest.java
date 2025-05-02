import java.util.*;

/**
 *
 * @author  Don Allen
 */
public class SteganographyMessageTest extends junit.framework.TestCase
{
    public void testEncodeString01()
    {
        List<Integer> result = SteganographyMessage.encodeString("Hello World");
        assertEquals("encodeString check", 12, result.size());
        assertEquals("encodeString check", new Integer(8), result.get(0));
        assertEquals("encodeString check", new Integer(5), result.get(1));
        assertEquals("encodeString check", new Integer(12), result.get(2));
        assertEquals("encodeString check", new Integer(12), result.get(3));
        assertEquals("encodeString check", new Integer(15), result.get(4));
        assertEquals("encodeString check", new Integer(27), result.get(5));
        assertEquals("encodeString check", new Integer(23), result.get(6));
        assertEquals("encodeString check", new Integer(15), result.get(7));
        assertEquals("encodeString check", new Integer(18), result.get(8));
        assertEquals("encodeString check", new Integer(12), result.get(9));
        assertEquals("encodeString check", new Integer(4), result.get(10));
        assertEquals("encodeString check", new Integer(0), result.get(11));
    }

    public void testDecodeString02()
    {
        List<Integer> result = new ArrayList<Integer>();
        result.add(new Integer(8));
        result.add(new Integer(5));
        result.add(new Integer(12));
        result.add(new Integer(12));
        result.add(new Integer(15));
        result.add(new Integer(27));
        result.add(new Integer(23));
        result.add(new Integer(15));
        result.add(new Integer(18));
        result.add(new Integer(12));
        result.add(new Integer(4));
        result.add(new Integer(0));
        String ans = SteganographyMessage.decodeString(result);
        assertEquals("decodeString check", "HELLO WORLD", ans);
    }

    public void testGetBitPairs03()
    {
        int[] ans = SteganographyMessage.getBitPairs(8);
        assertEquals("getBitPairs check", 0, ans[0]);
        assertEquals("getBitPairs check", 2, ans[1]);
        assertEquals("getBitPairs check", 0, ans[2]);

        ans = SteganographyMessage.getBitPairs(27);
        assertEquals("getBitPairs check", 3, ans[0]);
        assertEquals("getBitPairs check", 2, ans[1]);
        assertEquals("getBitPairs check", 1, ans[2]);
    }

    public void testHideText04()
    {
        Picture beach = new Picture("images\\beach.jpg");
//        beach.explore();
        Picture message = SteganographyMessage.hideText(beach, "Hello World");
        Pixel p = new Pixel(beach, /* column */ 0, /* row */ 0);
        Pixel m = new Pixel(message, /* column */ 0, /* row */ 0);   // the "H"
        assertEquals("hideText check", 2, p.getRed());
        assertEquals("hideText check", 4, p.getGreen());
        assertEquals("hideText check", 3, p.getBlue());
        assertEquals("hideText check", 0, m.getRed());
        assertEquals("hideText check", 6, m.getGreen());
        assertEquals("hideText check", 0, m.getBlue());

        p = new Pixel(beach, /* column */ 8, /* row */ 0);
        m = new Pixel(message, /* column */ 8, /* row */ 0);   // the "r"
        assertEquals("hideText check", 5, p.getRed());
        assertEquals("hideText check", 8, p.getGreen());
        assertEquals("hideText check", 1, p.getBlue());
        assertEquals("hideText check", 6, m.getRed());
        assertEquals("hideText check", 8, m.getGreen());
        assertEquals("hideText check", 1, m.getBlue());
    }

    public void testRevealText05()
    {
        Picture beach = new Picture("images\\beach.jpg");
//        beach.explore();
        beach.getPixel(0, 0).setRed(0);    //  The H
        beach.getPixel(0, 0).setGreen(6);
        beach.getPixel(0, 0).setBlue(0);

        beach.getPixel(1, 0).setRed(1);    //  The E
        beach.getPixel(1, 0).setGreen(5);
        beach.getPixel(1, 0).setBlue(0);

        beach.getPixel(2, 0).setRed(0);    //  The L
        beach.getPixel(2, 0).setGreen(7);
        beach.getPixel(2, 0).setBlue(0);

        beach.getPixel(3, 0).setRed(0);    //  The L
        beach.getPixel(3, 0).setGreen(7);
        beach.getPixel(3, 0).setBlue(0);

        beach.getPixel(4, 0).setRed(3);    //  The O
        beach.getPixel(4, 0).setGreen(7);
        beach.getPixel(4, 0).setBlue(0);

        beach.getPixel(5, 0).setRed(3);    //  The SPACE
        beach.getPixel(5, 0).setGreen(6);
        beach.getPixel(5, 0).setBlue(1);

        beach.getPixel(6, 0).setRed(3);
        beach.getPixel(6, 0).setGreen(5);
        beach.getPixel(6, 0).setBlue(1);

        beach.getPixel(7, 0).setRed(3);
        beach.getPixel(7, 0).setGreen(7);
        beach.getPixel(7, 0).setBlue(0);

        beach.getPixel(8, 0).setRed(6);
        beach.getPixel(8, 0).setGreen(8);
        beach.getPixel(8, 0).setBlue(1);

        beach.getPixel(9, 0).setRed(0);
        beach.getPixel(9, 0).setGreen(3);
        beach.getPixel(9, 0).setBlue(0);

        beach.getPixel(10, 0).setRed(4);
        beach.getPixel(10, 0).setGreen(5);
        beach.getPixel(10, 0).setBlue(0);

        beach.getPixel(11, 0).setRed(0);
        beach.getPixel(11, 0).setGreen(0);
        beach.getPixel(11, 0).setBlue(0);

        String message = SteganographyMessage.revealText(beach);
//        assertEquals("hideText check", "H", message);
        assertEquals("hideText check", "HELLO WORLD", message);
    }
}