
/**
 * The test class StudentStudentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentStudentTest extends junit.framework.TestCase
{
    public void testCompareToSameName()
    {
        Student student1 = new Student("Bob", 1, 3.1);
        Student student2 = new Student("Bob", 2, 3.1);
        Student student3 = new Student("Bob", 1, 0.0);
        Student student4 = new Student("Bob", 1, 3.1);
        assertEquals(false, student1.compareTo(student2)>0);
        assertEquals(false, student2.compareTo(student2)>0);
        assertEquals(true, student3.compareTo(student1)<0);
        assertEquals(false, student4.compareTo(student1)>0);
    }

    public void testEqualsSameName()
    {
        Student student1 = new Student("Bob", 1, 3.1);
        Student student2 = new Student("Bob", 2, 3.1);
        Student student3 = new Student("Bob", 1, 0.0);
        Student student4 = new Student("Bob", 1, 3.1);
        assertEquals(true, student1.equals(student2));
        assertEquals(false, student2.equals(student3));
        assertEquals(true, student2.equals(student4));
        assertEquals(true, student4.equals(student1));
        assertEquals(true, student4.equals(student4));
    }

    public void testAddStudent()
    {
        Student stu1 = new Student("Alan Turning", 1, 3.1);
        Student stu2 = new Student("Ada LoveLace", 2, 3.1);
        Student stu3 = new Student("Grace Hopper", 1, 0.0);
        Student stu4 = new Student("Chalres Babbage", 1, 3.1);

        ClassPeriod cp = new ClassPeriod("testPeriod");
        cp.addStudent(stu1);
        cp.addStudent(stu2);
        cp.addStudent(stu3);
        cp.addStudent(stu4);
        
        Student[] stus = cp.getStudents();
        assertEquals(true, stu1.getName().equals(stus[0].getName()));
        assertEquals(true, stu2.getName().equals(stus[1].getName()));
        assertEquals(true, stu3.getName().equals(stus[2].getName()));
        assertEquals(true, stu4.getName().equals(stus[3].getName()));

/*
 *    feel to add more students increasing the total number of student to 11
 *    or more. Then add assertEquals call to ensure you have correctly added 
 *    all the Students.
 */


    }

}

