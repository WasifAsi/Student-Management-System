package CW;

public class Module {

    private double maths = -1 ;
    private double csf = -1 ;
    private double sd1 = -1 ;
    private double Total;
    private double Average;
    private String Grade;

    public Module(double maths, double csf, double sd1, double total, double average, String grade) {
        this.maths = maths;
        this.csf = csf;
        this.sd1 = sd1;
        Total = total;
        Average = average;
        Grade = grade;
    }

    public double getMaths() {
        return maths;
    }

    public void setMaths(double maths) {
        this.maths = maths;
    }

    public double getCsf() {
        return csf;
    }

    public void setCsf(double csf) {
        this.csf = csf;
    }

    public double getSd1() {
        return sd1;
    }

    public void setSd1(double sd1) {
        this.sd1 = sd1;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public double getAverage() {
        return Average;
    }

    public void setAverage(double average) {
        Average = average;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }
}




