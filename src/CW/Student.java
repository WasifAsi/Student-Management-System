package CW;

import java.util.Scanner;

public class Student {

    private int Index ;
    static String [] Student_ID = new String[100];
    static String [] Student_Name = new String[100];

    static Scanner input = new Scanner(System.in);

    static Main main = new Main();

    public Student() {
        inizialise();
    }

    public static void inizialise (){
        for (int i = 0 ; i<Student_ID.length ; i++){
            Student_ID[i] = " - ";
        }
    }

    public void ID(String ID_num){
            Student_ID[Index] = ID_num;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public  void Name(){
        System.out.print("Ender the student ID  : ");
        String ID= input.next();

        if (main.check_ID(ID)){

            System.out.print("Ender the student Name : ");
            String name= input.next();

            Student_Name[main.ID_index] = name;

            System.out.println(Student_Name[main.ID_index]);
        }else {
            System.out.print("That Id not in the database");
        }
        main.extra_controls();
    }
}
