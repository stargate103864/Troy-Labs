
/**
 * The test class CopyOfClassPeriodTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CopyOfClassPeriodTest extends junit.framework.TestCase
{
    public void testFindStudent01()
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
            assertEquals("Checking findStudent: ", i, classPer1.findStudent(stuA[i].getId()));
        }
        assertEquals("Checking NOT findStudent: ", -1, classPer1.findStudent(13));
    }

    public void testRemoveStudent01()
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
            assertEquals("Checking find: ", i, classPer1.findStudent(stuA[i].getId()));
        }

        classPer1.removeStudent(student1);
        stuB = classPer1.getStudents();
        for (int i=0; i<NUM_STUDENTS-1; i++) 
            assertEquals("Checking removeStudent: ", true, stuA[i+1].equals(stuB[i]));

        classPer1.removeStudent(student1);
        stuB = classPer1.getStudents();
        for (int i=0; i<NUM_STUDENTS-1; i++) 
            assertEquals("Checking removeStudent: ", true, stuA[i+1].equals(stuB[i]));
    }
}