import java.awt.Color;

/**
 * Write a description of class Steganography here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Steganography
{
    public static void main(String[] args)
    {
        Picture beach = new Picture ("images\\beach.jpg");
        beach.explore();
        Picture copy = pictureClearLow(beach);
        copy.explore();
    }

    /**
     *   Clear the lower (rightmost) two bits in a pixel.
     */
    public static void clearLow( Pixel p )
    {
        p.setRed(p.getRed()/4*4);
        p.setBlue(p.getBlue()/4*4);
        p.setGreen(p.getGreen()/4*4);
    }

    /**
     *   Clear the lower (rightmost) two bits of ALL Pixel in Picture pix.
     *   
     *   @return new Picture
     */
    public static Picture pictureClearLow( Picture pix )//make a copy and alter the copy
    {
        Picture copy = new Picture(pix);
        Pixel[][] pixels = copy.getPixels2D();
        for(int x = 0; x < pixels.length; x++){
            for(int j = 0; j < pixels[0].length; j++){
                clearLow(pixels[x][j]);
            }
        }
        return new Picture(copy);
    }

    /**
     *   Set the lower 2 bits in Pixel p to the highest 2 bits in c
     *   you may NOT assume the lower two bits have been cleared
     *   
     *   @param Pixle p - set the lower 2 bits to the highest 2 bits of c
     *   @param Color - The highest 2 bits are set to the lowest 2 bits of p
     */
    public static void setLow (Pixel p, Color c)
    {
        p.setRed(p.getRed()/4*4 + c.getRed()/64*64/64);
        p.setGreen(p.getGreen()/4*4 + c.getGreen()/64*64/64);
        p.setBlue(p.getBlue()/4*4 + c.getBlue()/64*64/64);
    }

    /**
     *   Set the lower 2 bits of ALL Pixels p in Picture pix
     *   to the highest 2 bits in Color.PINK
     *   
     *   @return new Picture
     */
    public static Picture pictureSetLow( Picture pix )
    {
        Picture copy = new Picture(pix);
        Pixel[][] pixels = copy.getPixels2D();
        for (int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[0].length; c++){
                setLow(pixels[r][c], Color.PINK);
            }
        }
        return copy;
    }

    /**
     *    the rightmost two bits for each color value 
     *    become the (most significant) leftmost 2 bits for each color value
     */
    public static Picture revealPicture( Picture hidden )
    {
        Picture copy = new Picture(hidden);
        Pixel[][] pixels = copy.getPixels2D();
        Pixel[][] source = hidden.getPixels2D();

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[0].length; c++)
            {
                Color col = source[r][c].getColor();
                Pixel p = pixels[r][c];
                int red = p.getRed();
                p.setRed( (red%4) * 64);
                int green = p.getGreen();
                p.setGreen( (green%4) * 64);
                int blue = p.getBlue();
                p.setBlue( (blue%4) * 64);
            }
        }
        
        return copy;
    }

    public static void hideAndRevealImage()
    {
    }

    /*
     *   returns the digit in the tens place value of num.
     *   if num , 0, return a value less than or equal to 0
     *   
     *   if -10 < num < 10, return 0
     */
    public static int getTensDigit(int num)
    {
        return num / 10 % 10;    // 123 -> 12  ->
    }

    /*
     *   returns the digit in the hundreds place value of num.
     *   if num , 0, return a value less than or equal to 0
     *   
     *   if -100 < num < 100, return 0
     */
    public static int getHundredsDigit(int num)
    {
        return num / 100 % 10;
    }
}