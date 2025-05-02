import kareltherobot.*;

public class Carpeter extends SmartBot
{
    public Carpeter(int st, int ave, Direction dir, int beeps)

    {
        super (st,ave, dir, beeps);
    }

    public int carpetHallway()
    {
        if (!nextToABeeper())
        {
            putBeeper();
            move();
            if (!frontIsClear())
            {
                turnRight();
            }
            return carpetHallway() + 1;
        }
        else
        {

            return 0;
        }
    }
}

