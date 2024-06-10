package CW;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String [] seat =new String [100];
    static int ID_index =-1;
    static Scanner input = new Scanner(System.in);

    static Student student = new Student();
    static Module module = new Module();


    public static void menu(){
        ID_index = -1;
        int option ;
        while (true) {
            System.out.println("\n \nStudent management system");
            System.out.println("*************************");

            System.out.println("1. Check available seat");
            System.out.println("2. Register student");
            System.out.println("3. Delete student");
            System.out.println("4. Find student");
            System.out.println("5. Store student details into files");
            System.out.println("6. Load student details from the file");
            System.out.println("7. view the list of student based on their names");
            System.out.println("8. extra controls");

            try {
                option = input.nextInt();           // Read user input to perform an action.

                switch (option) {
                    case 1:
                        seat_check();
                        break;
                    case 2:
                        register();
                        break;
                    case 3:
                        delete();
                        break;

                    case 4:
                        find();
                        break;

                    case 8:
                        extra_controls();
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.\n");
                        break;
                }
//                break;

            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number.\n");
                input.nextLine();           // Clears the invalid input entered by user.
            }
        }

    }

    public static void seat_check(){

         for (int i=0 ;i< seat.length ; i++){
             if (seat[i].equals("e")){
                 System.out.println("seats " + (i+1) +" is avilable ");
             }
         }
         menu();
    }

    public static void register(){
            try {
                System.out.print("Ender the seat number  (1 - 100): ");
                int seat_number= input.nextInt();

                if (1 <= seat_number && seat_number <=100 ){
                    System.out.print("Ender the student ID  : ");
                    String ID_num= input.next();

                    if (check_ID(ID_num)){
                        System.out.println("Student ID is already there in seat "+ (ID_index+1));
                    }
                    else{

                        char First_letter = ID_num.charAt(0);
                        int total = ID_num.length();

                        if (First_letter  == 'w' && total== 8) {

                            student.setIndex(seat_number - 1);
                            student.ID(ID_num);

                            seat[seat_number - 1]= "B";
                        }
                        else {
                            System.out.println("check the ID for correction");
                            System.out.println("e.g : w1234567 ");
                        }
                    }
                                                                            //print seat
                    for (String s : seat) {
                        System.out.print(s);
                        System.out.print(" ");
                    }

                }else {
                    System.out.println("\n \nInvalid seat Number\n");
                }


            }catch (InputMismatchException e) {
                System.out.println("Enter a input.\n");
                input.nextLine();
            }

         menu();
    }

    public static void delete(){
         System.out.print("Ender the student ID  : ");
         String ID= input.next();

        if (check_ID(ID)){
            seat[ID_index]= "e";
            Student.Student_ID[ID_index]=" - ";
            Student.Student_Name[ID_index] = null;
            System.out.println("Successfully deleted");
        }
        else {
            System.out.println("ID is not there");
        }
         menu();
    }

    public static void find(){
        System.out.print("Ender the student ID  : ");
        String ID= input.next();

        if (!check_ID(ID)){
            System.out.println("ID is not there");
        }
        else {
            System.out.println("ID"+ID +" is in the seat number "+ (ID_index+1));
        }

        menu();
    }
    public static boolean check_ID(String ID){
        for (int i = 0; i< Student.Student_ID.length ; i++) {
            if (Student.Student_ID[i].equals(ID)) {
                ID_index = i;
                return true;
            }
        }
        return false;
    }


    public static void extra_controls(){

        String option ;
        while (true) {

        System.out.println("\n\nextra controls");
        System.out.println("**************");

        System.out.println("a. Add student name");
        System.out.println("b. Module marks");
        System.out.println("c. Delete student");
        System.out.println("d. Find student");
        System.out.println("Enter \"#\" fpr main menu");


            try {
                 option = input.next();           // Read user input to perform an action.

                switch (option) {
                    case "a":
                        student.Name();
                        break;

                    case "b":
                        module.marks();
                        break;

                    case "c":
                        c_summary();
                        up_fourty();
                        break;

                    case "#":
                        menu();
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.\n");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number.\n");
                input.nextLine();           // Clears the invalid input entered by user.
            }
        }
    }

    public static void c_summary(){

        int count = 0;

        for (int i = 0 ; i<seat.length ; i++){
            if (seat[i].equals("B")){
                count = count +1 ;
            }
        }
        System.out.println("\nTotal no of students registed : " + count);

    }

    public static void up_fourty(){
        int count = 0;
        for (int i = 0 ; i<100 ; i++){
            if (40<module.Marks_1[i]&& 40<module.Marks_2[i] && 40<module.Marks_3[i]){
                count = count +1 ;
            }
        }
        System.out.println("\nTotal no of students who has up to 40 marks : " + count);
    }

    public static void main(String[] args) {
        for (int i = 0 ; i<seat.length ; i++){
            seat[i] = "e";
        }
        menu();
    }
}
