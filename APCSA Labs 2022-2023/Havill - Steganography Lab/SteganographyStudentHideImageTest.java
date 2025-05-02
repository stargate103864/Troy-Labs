import java.util.*;
import java.awt.Color;
/**
 *
 * @author  Don Allen
 */
public class SteganographyStudentHideImageTest extends junit.framework.TestCase
{
    public void testCanHide01()
    {
        Picture beach = new Picture ("images//beach.jpg");
        Picture arch = new Picture ("images//arch.jpg");
        assertEquals("canHide check", true, SteganographyHideImage.canHide(beach, arch));
        assertEquals("canHide check", false, SteganographyHideImage.canHide(arch, beach));
    }

    public void testHidePicture02()
    {
        Picture beach = new Picture ("images//beach.jpg");
        Picture arch = new Picture ("images//arch.jpg");

        Picture message = SteganographyHideImage.hidePicture(beach, arch);
        Pixel p = new Pixel(beach, /* column */ 100, /* row */ 50);
        assertEquals("hidePicture check", 29, p.getRed());
        Pixel mess = new Pixel(message, /* column */ 100, /* row */ 50);
        assertEquals("hidePicture check", 29, mess.getRed());
        assertEquals("hidePicture check", 41, mess.getGreen());
        assertEquals("hidePicture check", 68, mess.getBlue());
        assertEquals("hidePicture check", 29, p.getRed());
        assertEquals("hidePicture check", 40, p.getGreen());
        assertEquals("hidePicture check", 70, p.getBlue());
    }

    public void testCanHideAt03()
    {
        Picture beach = new Picture("images\\beach.jpg");
        Picture flower1 = new Picture("images\\flower1.jpg");

        assertEquals("canHideAt check", true, SteganographyHideImage.canHideAt(beach, flower1, 275, 510));
        assertEquals("canHideAt check", false, SteganographyHideImage.canHideAt(beach, flower1, 400, 600));
    }

    public void testHideImageOffset04()
    {
        Picture source = new Picture ("images//beach.jpg");
        Picture secret = new Picture ("images//swan.jpg");
        Picture hidden = SteganographyHideImage.hidePicture(source,  secret, 10, 25);

        Picture message = Steganography.revealPicture(hidden);

        Pixel beach = new Pixel(source, /* column */ 25, /* row */ 10);
        assertEquals("hidePicture #2 and reveal beach check", 9, beach.getRed());
        assertEquals("hidePicture #2 and reveal beach check", 10, beach.getGreen());
        assertEquals("hidePicture #2 and reveal beach check", 4, beach.getBlue());
        
        Pixel swan = new Pixel(secret, /* column */ 0, /* row */ 0);
        assertEquals("hidePicture #2 and reveal arch check", 71, swan.getRed());
        assertEquals("hidePicture #2 and reveal arch check", 71, swan.getGreen());
        assertEquals("hidePicture #2 and reveal arch check", 73, swan.getBlue());
        
        Pixel hide = new Pixel(hidden, /* column */ 25, /* row */ 10);
        assertEquals("hidePicture #2 and reveal with hidden image check", 9, hide.getRed());
        assertEquals("hidePicture #2 and reveal with hidden image check", 9, hide.getGreen());
        assertEquals("hidePicture #2 and reveal with hidden image check", 5, hide.getBlue());

        Pixel mess = new Pixel(message, /* column */ 25, /* row */ 10);
        assertEquals("hidePicture #2 and reveal reveal image check", 64, mess.getRed());
        assertEquals("hidePicture #2 and reveal reveal image check", 64, mess.getGreen());
        assertEquals("hidePicture #2 and reveal reveal image check", 64, mess.getBlue());
    }
}