import java.util.*;
import java.io.*;

/**
 * The test class RememberStudentTester.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SaveInfoStudentTester extends junit.framework.TestCase
{
    public void testRememberRecallDelete() throws FileNotFoundException
    {
        File inputFile = new File("studentTestFile.txt");
        Magpie2 magpie21 = new Magpie2(inputFile);
        magpie21.getResponse("remember");   //  birthday  10-11-12
        magpie21.getResponse("remember");   //  price     $4.10
        magpie21.getResponse("remember");   //  day       Monday
        assertEquals("$4.10", magpie21.getResponse("recall"));   //  price
        magpie21.getResponse("delete");                          //  price
        assertEquals("10-11-12", magpie21.getResponse("recall"));      //  birthday
        assertEquals(true, magpie21.getResponse("recall").indexOf("could not find") >= 0);     //  price
    }
}