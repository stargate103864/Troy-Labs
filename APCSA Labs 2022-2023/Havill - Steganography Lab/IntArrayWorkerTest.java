import java.util.*;

/**
 *
 * @author  Don Allen
 */
public class IntArrayWorkerTest extends junit.framework.TestCase
{
    public void testGetTotal01()
    {
        IntArrayWorker iaw = new IntArrayWorker();
        iaw.setMatrix(new int[][] {{1, 2, 3}, {4, 0, 6}, {11, 12, 0}, {0, 15, 16}});
        assertEquals("getTotal check", 70, iaw.getTotal());
    }

    public void testGetTotalNested02()
    {
        IntArrayWorker iaw = new IntArrayWorker();
        iaw.setMatrix(new int[][] {{1, 2, 3}, {4, 0, 6}, {11, 12, 0}, {0, 15, 16}});
        assertEquals("getTotalNested check", 70, iaw.getTotalNested());
    }

    public void testGetCount03()
    {
        IntArrayWorker iaw = new IntArrayWorker();
        iaw.setMatrix(new int[][] {{1, 2, 3}, {4, 0, 6}, {11, 12, 0}, {0, 15, 16}});
        assertEquals("getCount check", 3, iaw.getCount(0));
    }

    public void testGetLargest04()
    {
        IntArrayWorker iaw = new IntArrayWorker();
        iaw.setMatrix(new int[][] {{1, 2, 3}, {4, 0, 6}, {11, 12, 0}, {0, 15, 16}});
        assertEquals("getLargest check", 16, iaw.getLargest());
    }

    public void testGetColTotal05()
    {
        IntArrayWorker iaw = new IntArrayWorker();
        iaw.setMatrix(new int[][] {{1, 2, 3}, {4, 0, 6}, {11, 12, 0}, {0, 15, 16}});
        assertEquals("getColTotal check", 2+0+12+15, iaw.getColTotal(1));
    }

    public void testNumValuesBetween06()
    {
        IntArrayWorker iaw = new IntArrayWorker();
        iaw.setMatrix(new int[][] {{1, 2, 3}, {4, 0, 6}, {11, 12, 0}, {0, 15, 16}});
        assertEquals("numValuesBetween check", 2, iaw.numValuesBetween(5, 11));
    }

    public void testIsCoolNumber07()
    {
        IntArrayWorker iaw = new IntArrayWorker();
        assertEquals("isCoolNumber check", true, iaw.isCoolNumber(81));
        assertEquals("isCoolNumber check", true, iaw.isCoolNumber(849));
        assertEquals("isCoolNumber check", true, iaw.isCoolNumber(121));
        assertEquals("isCoolNumber check", false, iaw.isCoolNumber(1));
        assertEquals("isCoolNumber check", false, iaw.isCoolNumber(555));
        assertEquals("isCoolNumber check", false, iaw.isCoolNumber(911));
    }

    public void testGetBestCoolColumn08()
    {
        IntArrayWorker iaw = new IntArrayWorker();
        iaw.setMatrix(new int[][] {{1, 555, 911}, {555, 81, 911}, {849, 911, 1}, {1, 849, 121}});
        assertEquals("getBestCoolColumn check", 1, iaw.getBestCoolColumn());

    }
}