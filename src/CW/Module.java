package CW;

import java.util.Scanner;

public class Module {
    static int [] Marks_1 = new int[100];
    static int [] Marks_2 = new int[100];
    static int [] Marks_3 = new int[100];
    static int [] Average  = new int[100];
    static Scanner input = new Scanner(System.in);

    Student student = new Student();
    static Main main = new Main();

    public static void marks(){

        int mark1,mark2 ,mark3 ;

        System.out.print("Ender the student ID  : ");
        String ID= input.next();

        if (main.check_ID(ID)){

            while (true){
                System.out.print("Ender the the Marks 1 : ");
                mark1= input.nextInt();

                if (0< mark1 && mark1<100  ){
                    Marks_1[main.ID_index]= mark1;
                    break;
                }
                else {
                    System.out.print("Mark 1 should between 1-100 ");
                }
            }

            while (true){
                System.out.print("Ender the the Marks 2 : ");
                mark2= input.nextInt();

                if (0< mark2 && mark2<100 ){
                    Marks_2[main.ID_index]= mark2;
                    break;
                }
                else {
                    System.out.print("Mark 1 should between 1-100 ");
                }
            }

            while (true){
                System.out.print("Ender the the Marks 3 : ");
                mark3= input.nextInt();

                if (0< mark3 && mark3<100 ){
                    Marks_3[main.ID_index]= mark3;
                    break;
                }
                else {
                    System.out.print("Mark 1 should between 1-100 ");
                }
            }

            int average = (mark1+mark2+mark3)/3;

            Average[main.ID_index]=average;


            System.out.println(Marks_1[main.ID_index]);
            System.out.println(Marks_2[main.ID_index]);
            System.out.println(Marks_3[main.ID_index]);
            System.out.println(Average[main.ID_index]);
        }
        else {
            System.out.print("That Id not in the database");
        }

        main.extra_controls();
    }
}
