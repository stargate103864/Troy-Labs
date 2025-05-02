import java.util.*;
import java.awt.*;

/**
 *
 * @author  Don Allen
 */
public class SteganographyTest extends junit.framework.TestCase
{
   public void testClearLow01()
   {
      Picture beach = new Picture ("beach.jpg");
      Pixel p = new Pixel(beach, /* column */ 100, /* row */ 50);
      Steganography.clearLow(p);
      assertEquals("clearLow check", 28, p.getRed());
      assertEquals("clearLow check", 40, p.getGreen());
      assertEquals("clearLow check", 68, p.getBlue());
    }

   public void testPictureClearLow02()
   {
      Picture beach = new Picture ("beach.jpg");
      beach = new Picture ("beach.jpg");

      Picture cleared = Steganography.pictureClearLow(beach);
      Pixel p = new Pixel(beach, /* column */ 100, /* row */ 50);
      assertEquals("pictureClearLow check", 29, p.getRed());
      Pixel clearedp = new Pixel(cleared, /* column */ 100, /* row */ 50);
      assertEquals("pictureClearLow check", 28, clearedp.getRed());
      assertEquals("pictureClearLow check", 40, clearedp.getGreen());
      assertEquals("pictureClearLow check", 68, clearedp.getBlue());
      assertEquals("pictureClearLow check", 29, p.getRed());
      assertEquals("pictureClearLow check", 40, p.getGreen());
      assertEquals("pictureClearLow check", 70, p.getBlue());
    }

   public void testSetLow03()
   {
      Picture beach = new Picture ("beach.jpg");
      Pixel p = new Pixel(beach, /* column */ 100, /* row */ 50);
      Color col = new Color(64, 129, 128+64+32);
      Steganography.setLow(p, col);
      assertEquals("setLow check", 29, p.getRed());
      assertEquals("setLow check", 42, p.getGreen());
      assertEquals("setLow check", 71, p.getBlue());
    }

   public void testPictureSetLow04()
   {
      Picture beach = new Picture ("beach.jpg");

      Picture cleared = Steganography.pictureSetLow(beach);
      Pixel p = new Pixel(beach, /* column */ 100, /* row */ 50);
      assertEquals("pictureSetLow check", 29, p.getRed());
      Pixel clearedp = new Pixel(cleared, /* column */ 100, /* row */ 50);
      assertEquals("pictureSetLow check", 31, clearedp.getRed());
      assertEquals("pictureSetLow check", 42, clearedp.getGreen());
      assertEquals("pictureSetLow check", 70, clearedp.getBlue());
      assertEquals("pictureSetLow check", 29, p.getRed());
      assertEquals("pictureSetLow check", 40, p.getGreen());
      assertEquals("pictureSetLow check", 70, p.getBlue());
    }

   public void testRevealPicture05()
   {
      Picture mess = new Picture ("mysteryImage.png");
      mess.explore();

      Picture mysteryimage = Steganography.revealPicture(mess);
      mysteryimage.explore();
      Pixel p = new Pixel(mess, /* column */ 100, /* row */ 50);
      assertEquals("revealPicture check", 255, p.getRed());
      Pixel clearedp = new Pixel(mysteryimage, /* column */ 100, /* row */ 50);
      assertEquals("revealPicture check", 192, clearedp.getRed());
      assertEquals("revealPicture check", 192, clearedp.getGreen());
      assertEquals("revealPicture check", 192, clearedp.getBlue());
      assertEquals("revealPicture chnaged parameter", 255, p.getRed());
      assertEquals("revealPicture chnaged parameter", 255, p.getGreen());
      assertEquals("revealPicture chnaged parameter", 255, p.getBlue());
      
      p = new Pixel(mess, /* column */ 77, /* row */ 147);
      assertEquals("revealPicture check", 255, p.getRed());
      clearedp = new Pixel(mysteryimage, /* column */ 77, /* row */ 147);
      assertEquals("revealPicture check", 192, clearedp.getRed());
      assertEquals("revealPicture check", 64, clearedp.getGreen());
      assertEquals("revealPicture check", 0, clearedp.getBlue());
      assertEquals("revealPicture chnaged parameter", 255, p.getRed());
      assertEquals("revealPicture chnaged parameter", 253, p.getGreen());
      assertEquals("revealPicture chnaged parameter", 252, p.getBlue());
    }

   public void testGetTensDigit06()
   {
      assertEquals("getTensDigit check", 4, Steganography.getTensDigit(83647));
      assertEquals("getTensDigit check", -5, Steganography.getTensDigit(-2651));
    }

   public void testGetHundredsDigit07()
   {
      assertEquals("getHundredsDigit check", 6, Steganography.getHundredsDigit(83647));
      assertEquals("getHundredsDigit check", -2, Steganography.getHundredsDigit(-9150247));
    }
}