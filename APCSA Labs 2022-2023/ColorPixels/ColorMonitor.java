import java.util.*;

public class ColorMonitor 
{
    private Pixel[][] monitor;

    /**
     * Constructor for objects of class ColorMonitor
     */
    public ColorMonitor(int r, int c)
    {
        monitor = new Pixel[r][c];
    }

    public int getNumRows() { return -1;}

    public int getNumCols() { return -1;}

    /**
     * sets the pixel at row = r, column = c to pixel p
     */
    public void setPixel(int r, int c, Pixel p)
    {
        monitor[r][c] = p;
    }

    /**
     * returns the Pixel at row = r, column = c
     */
    public Pixel getPixel(int r, int c)
    {
        return monitor[r][c];
    }

    /**
     * counts the number of mostly red Pixels
     */
    public int numMostlyRed()
    {
        int count = 0;
        for (int j = 0; j<monitor.length; j++)
        {
            for (int i = 0; i<monitor[0].length; i++)
            {
                if (monitor[j][i].mostlyRed())
                {
                    count += 1;
                }
            }
        }
        return count;
    }

    /**
     * darkens the monitor according to the following algorithm
     *   for each Pixel
     *      Increase blue by someValue.
     *      Increase green by half somevalue (Use integer division).
     *      Both blue and green should not be greater than 255.
     *         If either value is greater than 255, reset the value to 255.
     */
    public void darken(int someValue)
    {
        for (int j = 0; j<monitor.length; j++)
        {
            for (int i = 0; i<monitor[0].length; i++)
            {
                monitor[j][i].setBlue(monitor[j][i].getBlue() + someValue);
                monitor[j][i].setGreen(monitor[j][i].getGreen() + (someValue/2));
                if (monitor[j][i].getBlue() > 255)
                {
                    monitor[j][i].setBlue(255);

                }

                if (monitor[j][i].getGreen() > 255)
                {
                    monitor[j][i].setGreen(255);

                }
            }
        }
    }

    /**
     *   determines if the specified location is a Bright spot.  A spot is
     *   considered bright if all three following conditions are true:
     *        1)  The red value of the pixel at the specified location is
     *            greater than (!=) all (8 possible?) surrounding pixels.
     *        2)  The blue value of the pixel at the specified location is 
     *            less than (!=) all (8 possible?) surrounding pixels.
     *        3)  The green value of the pixel at the specified location is
     *            greater than (!=) the (green) average of all (8 possible?) surrounding pixels.
     */
    public boolean isBrightSpot(int r, int c)
    {
        //    add code here
        double count = 0;
        double green=0;
        for (int i = r-1; i < r + 2; i++)
        {
            for (int j = c-1; j < c +2; j++)
            {
                if (i>=0&&i<monitor.length&&j>=0&&j<monitor[0].length&&(i!=r||j!=c))
                {
                    if (monitor[r][c].getRed()<=monitor[i][j].getRed()||monitor[r][c].getBlue()>=monitor[i][j].getBlue())
                    {
                        return false;
                    }
                    green+=monitor[i][j].getGreen();
                    count++;
                }
            }
        }
        return monitor[r][c].getGreen()>(green/count);
    }
}