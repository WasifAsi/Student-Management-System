package CW;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String [] seat =new String [100];
    static int ID_index =-1;
    static Scanner input = new Scanner(System.in);

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
                break;

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
                        seat[seat_number - 1]= ID_num;
                    }
                                                                            //print seat
                    for(int i = 0 ; i<seat.length ; i++){
                        System.out.print(seat[i]);
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
        for (int i=0 ;i< seat.length ; i++) {
            if (seat[i].equals(ID)) {
                ID_index = i;
                return true;
            }
        }
        return false;
    }


    public static void extra_controls(){
        System.out.println("extra controls");
        System.out.println("**************");

        System.out.println("a. Add student name");
        System.out.println("b. Module marks");
//        System.out.println("c. Delete student");
//        System.out.println("d. Find student");


    }

    public static void main(String[] args) {
        for (int i = 0 ; i<seat.length ; i++){
            seat[i] = "e";
        }

        menu();
    }
}
