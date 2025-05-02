import java.util.*;

/**
 *
 * @author  Don Allen
 */
public class PictureTest extends junit.framework.TestCase
{
    public void testKeepOnlyBlue01()
    {
        Picture pict = new Picture("images\\beach.jpg");
        Pixel[][] pix1 = pict.getPixels2D();

        Picture pictCopy = new Picture(pict);
        pictCopy.keepOnlyBlue();
        Pixel[][] pix2 = pictCopy.getPixels2D();

        assertEquals("keepOnlyBlue check", 0, pix2[0][0].getRed());
        assertEquals("keepOnlyBlue check", 0, pix2[0][0].getGreen());
        assertEquals("keepOnlyBlue check", pix1[0][0].getBlue(), pix2[0][0].getBlue());
    }

    public void testNegatePixels02()
    {
        Picture pict = new Picture("images\\beach.jpg");
        Pixel[][] pix1 = pict.getPixels2D();

        Picture pictCopy = new Picture(pict);
        pictCopy.negatePixels();
        Pixel[][] pix2 = pictCopy.getPixels2D();

        assertEquals("negatePixels check", 255-pix1[0][0].getRed(), pix2[0][0].getRed());
        assertEquals("negatePixels check", 255-pix1[0][0].getGreen(), pix2[0][0].getGreen());
        assertEquals("negatePixels check", 255-pix1[0][0].getBlue(), pix2[0][0].getBlue());
    }

    public void testGrayscale03()
    {
        Picture pict = new Picture("images\\beach.jpg");
        Pixel[][] pix1 = pict.getPixels2D();
        
        Picture pictCopy = new Picture(pict);
        pictCopy.grayscale();
        Pixel[][] pix2 = pictCopy.getPixels2D();
        int ans = (pix1[0][0].getRed() + pix1[0][0].getGreen() + pix1[0][0].getBlue()) / 3;

        assertEquals("grayscale check", ans, pix2[0][0].getRed());
        assertEquals("grayscale check", ans, pix2[0][0].getGreen());
        assertEquals("grayscale check", ans, pix2[0][0].getBlue());
    }

    public void testMirrorVerticalRightToLeft04()
    {
        Picture pict = new Picture("images\\beach.jpg");
        Pixel[][] pix1 = pict.getPixels2D();

        Picture pictCopy = new Picture(pict);
        pictCopy.mirrorVerticalRightToLeft();
        Pixel[][] pix2 = pictCopy.getPixels2D();
        int w = pix2[0].length;

        assertEquals("mirrorVerticalRightToLeft check", pix2[0][0].getRed(), pix1[0][w-1].getRed());
        assertEquals("mirrorVerticalRightToLeft check", pix2[1][0].getGreen(), pix1[1][w-1].getGreen());
        assertEquals("mirrorVerticalRightToLeft check", pix2[2][0].getBlue(), pix2[2][w-1].getBlue());
    }

    public void testMirrorHorizontal05()
    {
        Picture pict = new Picture("images\\beach.jpg");
        Pixel[][] pix1 = pict.getPixels2D();

        Picture pictCopy = new Picture(pict);
        pictCopy.mirrorHorizontal();
        Pixel[][] pix2 = pictCopy.getPixels2D();
        int h = pix2.length;

        assertEquals("mirrorHorizontal check", pix1[0][0].getRed(), pix2[h - 1][0].getRed());
        assertEquals("mirrorHorizontal check", pix1[0][1].getGreen(), pix2[h - 1][1].getGreen());
        assertEquals("mirrorHorizontal check", pix1[0][2].getBlue(), pix2[h - 1][2].getBlue());
    }
}