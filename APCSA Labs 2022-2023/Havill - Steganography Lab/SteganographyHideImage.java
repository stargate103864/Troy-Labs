import java.awt.Color;
import java.awt.Point;
import java.util.*;

/**
 * Write a description of class Steganography here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SteganographyHideImage extends Steganography
{
    /** 
     * Determines whether secret can be hidden in source, which is true if:
     *      the length of secret is less than or equal to length of source
     * and  the width of secret is less than or equal to width of source.
     * 
     * @param source is not null
     * @param secret is not null
     * @return true if secret can be hidden in source, false otherwise.
     */
    public static boolean canHide(Picture source, Picture secret)
    {
        Pixel[][]Pixels = source.getPixels2D();
        Pixel[][]secPixels = secret.getPixels2D();
        if(!(secPixels.length <= Pixels.length)) return false;
        if(!(secPixels[0].length <= Pixels[0].length)) return false;
        return true;
    }

    /**
     *   Creates a new Picture with data from secret hidden in data from source
     *   @param source is not null
     *   @param seecret is not null
     *   @return combined Picture with secret hidden in source
     *   precondition: canHide(source, secret) returns true
     */
    public static Picture hidePicture(Picture source, Picture secret)
    {
        Pixel[][] arr2 = secret.getPixels2D();
        Picture copy = new Picture(source);
        Pixel[][] pixels = copy.getPixels2D();
        for (int i = 0; i < arr2.length; i++){
            for (int j = 0; j < arr2[0].length; j++){
                setLow(pixels[i][j], arr2[i][j].getColor());
            }
        }
        return copy;
    }

    /**  
     * Returns true if secret can be hidden in source if the upper left corner of 
     *  secret is placed at row, row and column, col in source.
     * 
     * @param source is not null
     * @param secret is not null
     * @return true if secret can be hidden in source, false otherwise.
     */
    public static boolean canHideAt(Picture source, Picture secret, int row, int col)
    {
        Pixel[][]Pixels = source.getPixels2D();
        Pixel[][]secPixels = secret.getPixels2D();
        if(!(secPixels.length + row <= Pixels.length)) return false;
        if(!(secPixels[0].length + col <= Pixels[0].length)) return false;
        return true;
    }

    /**
     * Creates a new Picture with data from secret hidden inn data from source
     * @param source is not null
     * @param secret is not null
     * @param startRow represents the row of the Upper Left corner where the hidden picture will be placed
     * @param startCol represents the column of the Upper Left corner where the hidden picture will be placed
     * @return combined Picture with secret hhidden in source
     * precondition: secret.getHeight() + startRow <= source.getHeight()
     * precondition: secret.getWidth() + startRow <= source.getWidth() 
     */
    public static Picture hidePicture(Picture source, Picture secret, int startRow, int startCol)
    {
        Pixel[][] arr2 = secret.getPixels2D();
        Picture copy = new Picture(source);
        Pixel[][] pixels = copy.getPixels2D();
        for (int i = 0; i < arr2.length; i++){
            for (int j = 0; j < arr2[0].length; j++){
                setLow(pixels[i + startRow][j + startCol], arr2[i][j].getColor());
            }
        }
        return copy;
    }
}