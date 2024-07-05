package CW;

public class Student {

    private String Student_ID ;
    private String S_Name ;

    public Student( String student_ID,String s_Name) {
        S_Name = s_Name;
        Student_ID = student_ID;
    }

    public String getS_Name() {
        return S_Name;
    }

    public void setS_Name(String s_Name) {
        S_Name = s_Name;
    }

    public String getStudent_ID() {
        return Student_ID;
    }


    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }
}
