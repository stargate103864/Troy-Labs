/**
  * note: This file is complete. Play around with it all you like.
  */
import chn.util.*;
import java.util.Properties;
import java.util.Enumeration;

public class ArrayRecordsSortSearchApplication {

	private static final String STUDENT_FILENAME = "students15.txt";
	
	public static void main(String args[]) {
		Student[] sortedStudents = null;
		ClassPeriod p1 = new ClassPeriod("PERIOD 1");
		readClass(p1);
		
		ConsoleIO console = new ConsoleIO();
		char choice;
		do {
			showMenu();
			choice = console.readLine().charAt(0);
			System.out.println();
			switch (choice) {
			 case '1':
				showStudents(p1.getStudents());
				break;
			 case '2':
				break;
			 case '3':
			  sortedStudents = p1.getStudents();
				sortViaArraysClass(sortedStudents);
				break;
			 case '4':
			  sortedStudents = p1.getStudents();
				sortViaInsertion(sortedStudents);
				break;
			 case '5':
			  sortedStudents = p1.getStudents();
				sortViaSelection(sortedStudents);
				break;
			 case '6':
			  sortedStudents = p1.getStudents();
				sortViaMerge(sortedStudents);
				break;
			 case '7':
			  showStudents(sortedStudents);
			  break;
			 case '8':
			 	break;
			 default:
			 	System.out.println("That's not a choice");
			 	break;
			}
		} while (choice != '8');
	}
	
	public static void showMenu() {
		String nameOfUserOnThisMachine = System.getProperties().getProperty("user.name");
	  System.out.println("\nHello " + nameOfUserOnThisMachine + "!");
	  System.out.println();
		System.out.println("1)  Show students in original order");
		System.out.println("2)");
		System.out.println("3)  Sort via sort in Arrays Class");
		System.out.println("4)  Sort via Insertion");
		System.out.println("5)  Sort via Selection");
		System.out.println("6)  Sort via Merge");
		System.out.println("7)  Show students in sorted order");
		System.out.println("8)  Quit?");
		System.out.print("choice: ");
	}
	
	public static void showStudents(Student[] studs){
		for (int i=0; i<studs.length; i++)
			System.out.println(studs[i]);
	}
	
	// Remember, in order for this to work, the .txt file must be with the .class
	//           file of your project.
	public static void readClass(ClassPeriod p1){
		System.out.println("Please wait while data file loads...");
		FileInput infile = new FileInput(STUDENT_FILENAME);
		do {
			int id = infile.readInt();
			double gpa = infile.readDouble();
			String name = infile.readLine();
			
			Student s = new Student(name,id,gpa);
			p1.addStudent(s);
		} while ( infile.hasMoreLines() );
		infile.close();
	}

	public static void sortViaInsertion(Student[] studs){
		long time = Sorter.sortViaInsertion(studs);
		System.out.print("\nIt took " + time + " milliseconds to sort these");
		System.out.println(" with the insertion sort");
	}
	
	public static void sortViaSelection(Student[] studs){
		long time = Sorter.sortViaSelection(studs);
		System.out.print("\nIt took " + time + " milliseconds to sort these");
		System.out.println(" with the selection sort");
	}
			
	public static void sortViaArraysClass(Student[] studs){
		long time = Sorter.sortViaJavaArraysClass(studs);
		System.out.print("It took " + time + " milliseconds to sort these");
		System.out.println(" with the Arrays class");
	}

	public static void sortViaMerge(Student[] studs){
		long time = Sorter.sortViaMerge(studs);
		System.out.print("\nIt took " + time + " milliseconds to sort these");
		System.out.println(" with the merge sort");
	}
}
