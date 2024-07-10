public class Student {
    //declaring private variable to store the student name and student id of the university enrollers
    private String ID;
    private String S_Name ;

    //Constructor to take the university student name and student id as arguments
    public Student( String student_ID,String s_Name) {
        S_Name = s_Name;
        ID =student_ID;
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
    public String getID() {
        return ID;
    }

    // Setter method to include the student id
    public void setID(String ID) {
        this.ID = ID;
    }
}