/**
 * @author: Ian Havill & Kasey Wang
 * 
 * note: Some of the methods below are for you to complete.
 */

public class ClassPeriod 
{
    private int              myNumStudents;
    private Student[]        myStudents;
    private String           myClassName;

    public ClassPeriod(String classname){
        myClassName = classname;
        myNumStudents = 0;
        myStudents = new Student[10];
    }

    // add the Student to the myStudents vector. If the vector is full, create a new
    // one twice the size of the current one. Update myNumStudents accordingly.
    public void addStudent(Student st){
        if (myNumStudents == myStudents.length)
        {
            Student[] temp = new Student[2*myStudents.length];
            // copy students from myStudents to temp
            for (int i = 0; i < myNumStudents; i++)
            {
                temp[i] = myStudents[i];
            }
            myStudents = temp;
        }
        myStudents[myNumStudents] = st;
        myNumStudents++;
    }

    // Call the public findStudent method. Then, if the student is there,
    // remove student from the array, moving all other elements accordingly.
    public void removeStudent(Student st)
    {
        if (findStudent(st.getId()) != -1)
        {
            int index = 0;
            while (!myStudents[index].equals(st))
            {
                index++;
            }
            for (int i = index; i < myNumStudents - 2; i++)
            {
                myStudents[i] = myStudents[i + 1];
            }
            myNumStudents--;
        }
    }
    //while loop until you get to the index then use a for loop

    // This method is complete.
    // Create a NEW array of Students and return it.
    public Student[] getStudents(){
        Student temp[] = new Student[myNumStudents];
        for (int i=0; i < myNumStudents; i++){
            temp[i] = myStudents[i];
        }
        return temp;
    }

    // This method is complete.
    // Each Student object should be on a line by itself. You
    // should allow the Student class to determine its own
    // String value (this makes your current job easy!). Also,
    // the class name should be on the first line.
    public String toString(){
        String s = new String(myClassName + "\n");
        int i;
        for (i=0; i<myNumStudents-1; i++)
            s += myStudents[i].toString() + "\n";
        s += myStudents[myNumStudents-1];
        return s;
    }

    // Since our students are in no particular order within the array,
    // use a Linear/Sequential search to find the student with the id. Return
    // the array location where the id is found, otherwise -1 if not found.
    public int findStudent(int id){
        for (int i = 0; i < myNumStudents; i++)
        {
            if (myStudents[i].getId() == id)
            {
                return i;
            }
        }
        return -1;
    }
}

