public class Student {
    //declaring private variable to store the student name and student id of the university enrollers
    private String Student_ID ;
    private String S_Name ;

    //Constructor to take the university student name and student id as arguments
    public Student( String student_ID,String s_Name) {
        S_Name = s_Name;
        Student_ID = student_ID;
    }

    //Getter method to get the student name
    public String getS_Name() {
        return S_Name;
    }

    // Setter method to include the student name
    public void setS_Name(String s_Name) {
        S_Name = s_Name;
    }

    //Getter method to get the student id
    public String getStudent_ID() {
        return Student_ID;
    }

    // Setter method to include the student id
    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }
}