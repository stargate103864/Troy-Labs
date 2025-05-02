

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



}

