package CW;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static String [] seat =new String [100];

    static ArrayList<Integer> ID = new ArrayList<Integer>();

    static Scanner input = new Scanner(System.in);

     public static void menu(){
         int option ;

         System.out.println("\n \nStudent management system");
         System.out.println("*************************");

         System.out.println("1. Check available seat");
         System.out.println("2. Register student");
         System.out.println("3. Delete student");
         System.out.println("4. Find student");
//         System.out.println("5. Store student details into files");
//         System.out.println("6. Load student details from the file");
//         System.out.println("7. view the list of student based on their names");
//         System.out.println("8. extra controls");



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

                     break;


                 case 8:
                     extra_controls();

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

    public static void seat_check(){
         int availability = 0 ;
         for (int i=0 ;i< seat.length ; i++){
             if (seat[i].equals("e")){
                 availability += 1;
             }
         }
         System.out.println("seats avilable :"+availability);
         menu();
    }

    public static int register(){

        System.out.print("Ender the student ID  : ");

        int ID_num= input.nextInt();

        System.out.println(ID_num);

        for (int i=0 ; i < ID.size() ; i++){
            if (ID_num == ID.get(i)){
                System.out.println("\nentered id is already there \n");
                return 0;
            }
        }

        ID.add(ID_num);
        System.out.println(ID_num + "Successfully added");
        menu();
        return 0;
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
