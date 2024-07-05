package CW;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    final static int array_length = 100;

    static String [] ID = new String[array_length];

    static Student [] students = new Student[array_length];

    static Module [] modules = new Module[array_length];

    static int ID_index=-1;

    static Scanner sc = new Scanner(System.in);


    public static void Menu() {
        int user_choice ;
        System.out.println("\t** WELCOME TO STUDENT ACTIVITY MANAGEMENT SYSTEM **\n");
        System.out.println("NOTE:Please click option 6 and load existing student details from the file!!");

        while (true) {
            System.out.println("\t\t\t------------------------------");
            System.out.println("\t\t\t\t\t\tMAIN MENU\t\t\t\t\t\t");
            System.out.println("\t\t\t------------------------------");
            System.out.println("1. Check available seats");
            System.out.println("2. Register a Student");
            System.out.println("3. Delete a Student");
            System.out.println("4. Find a Student");
            System.out.println("5. Store Student Details to the file");
            System.out.println("6. Load Student Details from the file");
            System.out.println("7. View Students name list");
            System.out.println("8. Extra Controls");
            System.out.println("9. Exit the program");

            try {
                System.out.println("\nEnter your choice: ");
                user_choice = sc.nextInt();
                sc.nextLine();
                if (user_choice >= 1 && user_choice <= 9) {
                    switch (user_choice) {
                        case 1: {
                            int a_seats = checkAvailableSeats();
                            System.out.println("There are " + a_seats + " seats available.");
                            break;
                        }
                        case 2: {
                            System.out.println("Press option 5 and store the registration details to the text file!!\n");
                            Register();
                            break;
                        }
                        case 3: {
                            Delete();
                            break;
                        }
                        case 4: {
                            Find();
                            break;
                        }
                        case 5: {
                            SaveData();
                            break;
                        }
                        case 6: {
                            retrieveData();
                            break;
                        }
                        case 7: {
                            view();
                            break;
                        }
                        case 8: {
                            extra_controls();
                            break;
                        }
                        case 9: {
                            System.out.println("Exited from program successfully! Have a good day!");
                            System.exit(0);
                            break;
                        }
                        default: {
                            System.out.println("Invalid input. Please Try again!!");
                            break;
                        }


                    }

                } else {
                    System.out.println("choice out of range. Please try again!! ");
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again!!");
                sc.nextLine();
            }


        }
    }

    public static void extra_controls(){

        while (true) {
            System.out.println("\n\n**");
            System.out.println("Extra controls");
            System.out.println(" ");

            System.out.println("a. Update student name");
            System.out.println("b. Insert Module marks");
            System.out.println("c. University Summary");
            System.out.println("d. Students Report");
            System.out.println("#. Return to Main Menu");


            try {
                System.out.println("Enter the choice: ");
                String option = sc.nextLine();

                switch (option) {
                    case "a": {
                        UpdateName();
                        System.out.println("Press option 5 and store the registration details to the text file!!");
                        break;
                    }

                    case "b": {
                        AddMarks();
                        System.out.println("Press option 5 and store the module1 details to the text file!!");
                        break;
                    }

                    case "c": {
                        Summary();
                        break;
                    }

                    case "d": {
                        report();
                        break;
                    }

                    case "#": {
                        Menu();
                        break;
                    }
                    default: {
                        System.out.println("Invalid option. Please try again.\n");
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again!!");
                sc.nextLine();
            }
        }
    }

    public static int checkAvailableSeats() {
        int a_seat =0;
        for (int i = 0; i < ID.length; i++) {
            if (ID[i].equals("-")) {
                a_seat = a_seat +1;
            }
        }
        return a_seat;

    }

    public static void Register() {
        String student_id ;
        int a_seat = checkAvailableSeats();

        if (a_seat != 0 ) {
            while (true) {
                System.out.println("Enter the Student ID (eg:w2084774):");
                student_id = sc.nextLine();


                if (StudentIDValidate(student_id)) {
                    if (!IDChecker(student_id)) {
                        String s_name;
                        while (true) {

                            try {
                                System.out.println("Enter the Student Full name: ");
                                s_name = sc.nextLine();
                                break;
                            } catch (Exception e) {
                                System.out.println("The name should be consists only alphabets");
                            }
                        }

                        Student student = new Student(student_id ,s_name);


                        for(int i=0; i<100 ; i++){
                            if(ID[i].equals("-")){

                                ID[i]=student_id;

                                students[i] = student ;                                                 // inserting the array object and array id

                                break;
                            }
                        }
                        System.out.println("Student successfully registered! Best of Luck!!");
                        break;

                    }
                    else{
                        System.out.println("The Student ID you entered is already existing!!. Try again!!");
                    }


                }
                else {
                    System.out.println("The student id should be 8 characters long and should start with 'w'");
                }
            }

        } else {
            System.out.println("There are no seats available to register the student");
        }
    }


    public static void Delete(){
        System.out.println("Enter the student id to be deleted: ");
        String del_id=sc.nextLine();
        if(StudentIDValidate(del_id)){
            if(IDChecker(del_id)){

                ID[ID_index]="-";

                students[ID_index].setStudent_ID("-");
                students[ID_index].setS_Name("-");

                modules[ID_index].setMaths(0);
                modules[ID_index].setCsf(0);
                modules[ID_index].setSd1(0);
                modules[ID_index].setTotal(0);
                modules[ID_index].setAverage(0);
                modules[ID_index].setGrade("N/A");


                System.out.println("The Student deleted successfully");
            }
            else{
                System.out.println("The inputted student id does not exists!!");
            }
        }
        else{
            System.out.println("The inputted id is invalid");
        }
    }

    public static void Find(){
        System.out.println("Enter the student id to be found: ");
        String f_id=sc.nextLine();
        if(StudentIDValidate(f_id)){
            if(IDChecker(f_id)){
                System.out.println("The student name belongs to this id is: "+students[ID_index].getS_Name());
            }
            else{
                System.out.println("The inputted student id does not exists!!");
            }
        }
        else{
            System.out.println("The inputted id is invalid");
        }

    }


    public static void SaveData() {
        try {

            //Creating a new file object
            File file = new File("student details.txt");

            //Creating a new PrintWritter object to write data to the student details.txt
            PrintWriter writer = new PrintWriter(file);

            // Writting an clarity message to say that details are stored in the respective order as this
            writer.println("Note: Details are stored in the order ID,Name,CSF Marks,Maths Marks,SD1 Marks,Total,Average,Grade");
            writer.println("-------------------------------------------------------------------------------------------------");

            //Using for loop and iterating over registered students
            for (int i = 0; i < array_length; i++) {
                if (!ID[i].equals("-")) {
                    //Storing the data in a variable details separated using commas
                    String details = (ID[i] + "," + students[i].getS_Name() + "," +  modules[i].getMaths() + "," +  modules[i].getCsf() + "," +modules[i].getSd1() + "," +modules[i].getTotal() + "," +modules[i].getAverage() + "," +modules[i].getGrade());

                    //Writting the student details to the file
                    writer.println(details);
                }

            }
            writer.close();
            System.out.println("Student details saved successfully to the file.");
            //If any error occurs when creating the file. Handling it by printing an error message for it
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, An error occured while saving to text file!");
        }
    }


    public static void retrieveData() {
        try {
            //Creating a file object
            File file = new File("student details.txt");

            //Creating a scanner object to read the student data in the file
            Scanner fileScanner = new Scanner(file);

//            //Skipping to read the 02 lines where the first line is note and next one is dashed line
//            fileScanner.nextLine();
//            fileScanner.nextLine();

            //Starring the index value from

            while (fileScanner.hasNextLine() && checkAvailableSeats() < 100) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");

                if (data.length < 8) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                // Use IDChecker to check for duplicates
                if(StudentIDValidate(data[0])) {
                    if (!IDChecker(data[0])) {

                        Student student = new Student(data[0], data[1]);

                        double maths  = Double.parseDouble(data[2]);
                        double csf = Double.parseDouble(data[3]);
                        double sd1 = Double.parseDouble(data[4]);
                        double marks = Double.parseDouble(data[5]);
                        double average = Double.parseDouble(data[6]);
                        String grade = data[7];

                        Module module = new Module(maths,csf, sd1,marks,average,grade);


                        for(int i=0; i<array_length ; i++){
                            if(ID[i].equals("-")){

                                ID[i] = data[0];

                                students[i] = student ;                                                 // inserting the array object and array id

                                modules[i] = module ;

                                break;
                            }
                        }



                    }
                    else{
                        continue; // Skip this line if ID already exists
                    }
                }



            }


            fileScanner.close();
            System.out.println("Student details retrieved successfully from the file.");
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, an error occurred when retrieving data: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Sorry, an error occurred when parsing the data: " + e.getMessage());
        }
    }





    public static void view (){

        int n = ID.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Change the comparison to sort in descending order
                if (students[j].getS_Name().compareTo(students[j + 1].getS_Name())>0){
                    // swap arr[j] and arr[j+1]
                    String temp = ID[j];
                    ID[j] = ID[j + 1];
                    ID[j + 1] = temp;

                    Student tempStudent = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = tempStudent;

                    Module tempModule = modules[j];
                    modules[j] = modules[j + 1];
                    modules[j + 1] = tempModule;
                }
            }
        }

        System.out.println("Students List Sorted in Alphabetical order");
        System.out.println("");
        System.out.println("NAME\t\t\t\t\tID");
        for (int i=0 ; i<array_length  ; i++) {
            if(!ID[i].equals("-")) {
                System.out.printf("%-20s\t%s\n", students[i].getS_Name(), ID[i]);
            }
        }
    }






    public static void UpdateName(){
        System.out.println("Enter the student Id: ");
        String u_id=sc.nextLine();
        if(StudentIDValidate(u_id)) {
            if (IDChecker(u_id)) {
                System.out.println("The current student name is: " + students[ID_index].getS_Name());
                while (true) {

                    System.out.println("Do you like to change the current student name ['Y'/'N']: ");
                    String option = sc.nextLine();
                    option = option.toUpperCase();
                    switch (option) {
                        case "Y": {
                            System.out.println("Enter the new student name to be updated: ");
                            String newname = sc.nextLine();
                            students[ID_index].setS_Name(newname);
                            break;
                        }
                        case "N": {
                            System.out.println("The Student Name does not updated!");
                            break;
                        }
                        default: {
                            System.out.println("Invalid input!!.Enter 'Y' or 'N");
                            break;
                        }
                    }
                    break;
                }
            } else {
                System.out.println("The inputted student id does not exists!!");
            }
        }
        else {
            System.out.println("The inputted id is invalid");
        }

    }



    public static void AddMarks(){
        double m_maths =0;
        double m_csf =0;
        double m_sd1 =0;
        double Total;
        double Average;
        String Grade;



        System.out.println("Enter the Student ID: ");

        String m_id =sc.nextLine();

        //Checking whether the inputted student id is a valid student id using the StudentIDValidate method in student class
        if(StudentIDValidate(m_id)) {
            //Checking whether the inputted student id is existing in the ID array using IDChecker method in student class
            if (IDChecker(m_id)) {

                //Using try block to enusre user enters numeral value as marks
                try {
                    //Asking the user to input the module marks  and storing it in respective variables temperorily
                    System.out.println("Enter the module marks for maths: ");
                    m_maths = sc.nextDouble();
                    System.out.println("Enter the module marks for CSF: ");
                    m_csf = sc.nextDouble();
                    System.out.println("Enter the module marks for SD1: ");
                    m_sd1 = sc.nextDouble();

                    //Printing an exception message if the user enters invalid inputs
                } catch (Exception e) {
                    System.out.println("The module marks should be in numeral value");
                }
                Total = m_maths + m_csf +m_sd1;

                Average = Total / 3 ;

                if(Average>=80){
                    Grade="Distinction";
                }
                else if (Average >= 70) {
                    Grade ="Merit";
                }
                else if (Average >= 40){
                    Grade ="Pass";
                }
                else{
                    Grade = "Fail";
                }


                Module module =new Module(m_maths,m_csf,m_sd1,Total,Average,Grade);

                modules[ID_index] =module ;


            }
            else {
                System.out.println("The inputted student id does not exists!!");
            }
        }
        else{
            System.out.println("The inputted id is invalid");
        }
    }




    public static void Summary(){
        //Initializing variables to count the number of students who got marks above 40 for each module
        int n_csf=0;
        int n_maths=0;
        int n_sd1=0;

        int not_available=0;

        //Using for loop to iterate and access the elements in csf,maths,sd1 array and incrementing the count if its above 40

        int Registation = array_length - checkAvailableSeats();

        for(int i=0; i<ID.length;i++){
            if (!modules[i].getGrade().equals("N/A")) {
                if (modules[i].getCsf() > 40) {
                    n_csf++;
                }
                if (modules[i].getMaths() > 40) {
                    n_maths++;
                }
                if (modules[i].getSd1() > 40) {
                    n_sd1++;
                }
            }

            if (!ID[i].equals("-")) {
                if (modules[i].getGrade().equals("N/A")){
                    not_available ++;
                }

            }
        }


        //Printing the summary of students who got marks above 40 for every modules
        System.out.println("The total number of registered students in the university: "+Registation);
        System.out.println("Total number of students who's marks added is :  "+(array_length-not_available));
        System.out.println("Total number of students scored more than 40 for Maths is: "+n_maths);
        System.out.println("\nTotal number of students scored more than 40 for CSF is: "+n_csf);
        System.out.println("Total number of students scored more than 40 for SD1 is: "+n_sd1);

    }



    public static void report() {

        int n = ID.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Change the comparison to sort in descending order
                if (modules[j].getAverage() < modules[j + 1].getAverage()) {

                    // swap arr[j] and arr[j+1]
                    String temp = ID[j];
                    ID[j] = ID[j + 1];
                    ID[j + 1] = temp;

                    Student tempStudent = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = tempStudent;

                    Module tempModule = modules[j];
                    modules[j] = modules[j + 1];
                    modules[j + 1] = tempModule;
                }
            }
        }



        // Printing the  report in sorted order according to average from highest to lowest

        //Printing the column headings of the report
        System.out.printf("%-20s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%s\n",
                "Student ID", "Name", "Maths", "CSF" ,"SD1","Total", "Average", "Grade");

        //printing the module details and student details of each and every student using for loop
        for (int i = 0; i < array_length ; i++) {
            //Checking whether the array elements are with the default value -1 where marks didnt enter yet
            if (!ID[i].equals("-")) {
                if (modules[i].getGrade().equals("N/A")) {

                    //If satisfies then printing "-" in the places of -1 value
                    System.out.printf("%-20s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%s\n",
                            ID[i], students[i].getS_Name(), "-", "-", "-", "-","-", modules[i].getGrade());
                } else {
                    //printing the id,name,marks,total,average and grade
                    System.out.printf("%-20s\t%-20s\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f\t%s\n",
                            ID[i],students[i].getS_Name(), modules[i].getMaths(), modules[i].getCsf(), modules[i].getSd1(),
                            modules[i].getTotal(), modules[i].getAverage(),modules[i].getGrade());
                }
            }
        }
    }


    public static boolean StudentIDValidate(String student_id) {
        if (student_id.length() == 8 && student_id.charAt(0) == 'w') {
            if (student_id.substring(1, 8).matches("[0-9]+")) {
                return true;
            }
        }
        return false;
    }

    public static  boolean IDChecker(String id){
        ID_index=-1;
        for (int i = 0; i<ID.length; i++) {
            if (ID[i].equals(id)) {
                ID_index = i;

                return true;
            }
        }
        return false;

    }

    public static void initializer(){
        for(int i=0; i<array_length  ;i++){
            ID[i]="-";
            students[i] = new Student("-", "-");
            modules[i] = new Module(0,0,0,0,0,"N/A");
        }
    }

    public static void main(String[] args) {
        initializer();
        Menu();
    }
}
