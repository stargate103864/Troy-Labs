
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ClassPeriodTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClassPeriodTest
{
    /**
     * Default constructor for test class ClassPeriodTest
     */
    public ClassPeriodTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {

    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void findStudent01()
    {
        int NUM_STUDENTS = 5;
        Student [] stuA = new Student[NUM_STUDENTS];
        Student student1 = new Student("Alice", 1, 1.0);
        Student student2 = new Student("Bob", 2, 3.7);
        Student student3 = new Student("Clo", 5, 3.2);
        Student student4 = new Student("fdsa1", 4, 3.1);
        Student student5 = new Student("fdsa2", 6, 3.1);
        stuA =new Student[] {student1, student2 , student3 , student4,  student5}; 
        ClassPeriod classPer1 = new ClassPeriod("Period 1");
        classPer1.addStudent(student1);
        classPer1.addStudent(student2);
        classPer1.addStudent(student3);
        classPer1.addStudent(student4);
        classPer1.addStudent(student5);
        Student [] stuB = classPer1.getStudents();

        for (int i=0; i<NUM_STUDENTS; i++) 
        {
            assertEquals(true, stuA[i].equals(stuB[i]));
            assertEquals(i, classPer1.findStudent(stuA[i].getId()),"Checking findStudent: ");
        }
        assertEquals(-1, classPer1.findStudent(13),"Checking NOT findStudent: ");
    }

    @Test
    public void removeStudent01()
    {
        int NUM_STUDENTS = 5;
        Student [] stuA = new Student[NUM_STUDENTS];
        Student student1 = new Student("Alice", 1, 1.0);
        Student student2 = new Student("Bob", 2, 3.7);
        Student student3 = new Student("Clo", 5, 3.2);
        Student student4 = new Student("fdsa1", 4, 3.1);
        Student student5 = new Student("fdsa2", 6, 3.1);
        stuA =new Student[] {student1, student2 , student3 , student4,  student5}; 
        ClassPeriod classPer1 = new ClassPeriod("Period 1");
        classPer1.addStudent(student1);
        classPer1.addStudent(student2);
        classPer1.addStudent(student3);
        classPer1.addStudent(student4);
        classPer1.addStudent(student5);
        Student [] stuB = classPer1.getStudents();

        for (int i=0; i<NUM_STUDENTS; i++) 
        {
            assertEquals(true, stuA[i].equals(stuB[i]));
            assertEquals(i, classPer1.findStudent(stuA[i].getId()),"Checking find: ");
        }

        classPer1.removeStudent(student1);
        stuB = classPer1.getStudents();
        for (int i=0; i<NUM_STUDENTS-1; i++) 
            assertEquals(true, stuA[i+1].equals(stuB[i]),"Checking removeStudent: ");

        classPer1.removeStudent(student1);
        stuB = classPer1.getStudents();
        for (int i=0; i<NUM_STUDENTS-1; i++) 
            assertEquals(true, stuA[i+1].equals(stuB[i]),"Checking removeStudent: ");
    }
}

