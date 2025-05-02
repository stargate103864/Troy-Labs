
/**
 * Write a description of class LatticePoint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LatticePoint
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;

    /**
     * Constructor for objects of class LatticePoint
     */
    public LatticePoint(int a, int b)
    {
        x = a;
        y = b;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public boolean equals(Object obj)
    {
        LatticePoint lp = (LatticePoint)obj;
        return getX() == lp.getX() && getY() == lp.getY();
    }

    public int hashCode()
    {
        Integer x1 = new Integer(x);
        Integer y1 = new Integer(y);

        return x1.hashCode() + y1.hashCode();
    }
}
