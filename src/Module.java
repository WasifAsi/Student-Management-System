public class Module {
    //declaring private variables to store module marks,average,total and Grade
    private double maths =0;
    private double csf =0;
    private double sd1 =0;
    private double Total;
    private double Average;
    private String Grade;

    //Constructor that take module marks of all three subjects,total,average and grade as the arguments given
    public Module(double maths, double csf, double sd1, double total, double average, String grade) {
        //Assigining the argument to the variable
        this.maths = maths;
        this.csf = csf;
        this.sd1 = sd1;
        Total = total;
        Average = average;
        Grade = grade;
    }
    //Getter to get the maths module marks
    public double getMaths() {
        return maths;
    }

    //Setter to update the maths module marks
    public void setMaths(double maths) {
        this.maths = maths;
    }
    //Getter to get the csf module marks
    public double getCsf() {
        return csf;
    }


    //Setter to update the csf module marks
    public void setCsf(double csf) {
        this.csf = csf;
    }

    //Getter to get the sd1 module marks
    public double getSd1() {
        return sd1;
    }

    //Setter to update the sd1 module marks
    public void setSd1(double sd1) {
        this.sd1 = sd1;
    }

    //Getter to get the total of all 3 module marks
    public double getTotal() {
        return Total;
    }

    //Setter to update the  module marks
    public void setTotal(double total) {
        Total = total;
    }

    //Getter to get the average of module marks
    public double getAverage() {
        return Average;
    }

    //Setter to update the average of all 3 module marks
    public void setAverage(double average) {
        Average = average;
    }

    //Getter to get the grade
    public String getGrade() {
        return Grade;
    }

    //Setter to update the grade of students
    public void setGrade(String grade) {
        Grade = grade;
    }
}