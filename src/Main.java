import java.io.File;

//Importing the FileNotFoundException class to handle the file related exceptios  arising
import java.io.FileNotFoundException;

//Importing the PrintWriter class to write on the files
import java.io.PrintWriter;

//Importing the scanner class to take inputs from the user
import java.util.Scanner;

public class Main {
    //Initializing and declaring the university enrolement capacity as 100
    final static int students_capacity = 100;

    //Initializing and Declaring String array to store Student ID of the students
    static String [] ID = new String[students_capacity];

    //Initializing and declaring Student object array to store student objects
    static Student[] students = new Student[students_capacity];

    //Initializing and declaring Module object array to store module objects
    static Module[] modules = new Module[students_capacity];

    //Declaring and initializing the id index to -1 value because if its -1 we can say id not found
    static int ID_index=-1;

    //Creating the scanner object to take the user input
    static Scanner sc = new Scanner(System.in);




    //Method for the main menu
    public static void MainMenu() {
        int user_choice ;
        System.out.println("\t** WELCOME TO STUDENT ACTIVITY MANAGEMENT SYSTEM **\n");
        System.out.println("NOTE:Please click option 6 and load existing student details from the file!!");

        //Using while true to print the main menu infinitely until user says to exit from the program
        while (true) {
            //Printing all the menu options
            System.out.println("\t\t\t------------------------------");
            System.out.println("\t\t\t\t\t\tMAIN MENU\t\t\t\t\t\t");
            System.out.println("\t\t\t------------------------------");
            System.out.println("1.Check available seats");
            System.out.println("2.Register a Student");
            System.out.println("3.Delete a Student");
            System.out.println("4.Find a Student");
            System.out.println("5.Store Student Details to the file");
            System.out.println("6.Load Student Details from the file");
            System.out.println("7.View Students name list");
            System.out.println("8.Extra Controls");
            System.out.println("9.Exit the program");

            //Asking the user choice to perform inside try block to handle exceptions
            try {
                System.out.println("\nEnter your choice: ");
                user_choice = sc.nextInt();
                sc.nextLine();
                //Checking whether the user input choice is in range
                if (user_choice >= 1 && user_choice <= 9) {

                    //Using switch to call the methods according to user input
                    switch (user_choice) {
                        case 1: {
                            int a_seats = checkAvailableSeats();
                            System.out.println("The university enrollment capacity is: "+students_capacity);
                            System.out.println("Number of available seats is: "+a_seats);
                            break;
                        }
                        case 2: {
                            Register();
                            System.out.println("Press option 5 and store the registration details to the text file!!\n");
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
                            LoadData();
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

                }
                //Printing an message if the user does not enter a choice that does not lie between 1-9
                else {
                    System.out.println("choice out of range. Please try again!! ");
                }

            }
            //Handling the exception if user enters choice which is not a integer value
            catch (Exception e) {
                //Printing an error message if user enters any other data type value except integer
                System.out.println("Invalid input. Please try again!!");

                //Consuming nextline to avoid exception cases input
                sc.nextLine();
            }


        }
    }




    //Method for extra controls assigned for task02
    public static void extra_controls(){
        //Using while true loop to loop indefinitely until the user select to go to the main menu
        while (true) {
            //Displaying the user the extra control options
            System.out.println("\n\n**************");
            System.out.println("Extra controls");
            System.out.println("***************");

            System.out.println("a.Update student name");
            System.out.println("b.Insert Module marks");
            System.out.println("c.University Summary");
            System.out.println("d.Students Report");
            System.out.println("#.Return to Main Menu");

            //Getting the choice input using try block to handle exceptions arising

            try {
                //Asking for the option to select from user and storing it in the option string variable
                System.out.println("Enter the choice: ");
                String option = sc.nextLine();

                //Using switch cases to access and call the methods according to the option user selects to perform
                switch (option) {
                    case "a": {
                        UpdateName();
                        //Printing a reminder statement to remind the user that he have to choose the save option to update in text file as well
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
                        MainMenu();
                        break;
                    }
                    default: {
                        System.out.println("Invalid option. Please try again.\n");
                        break;
                    }
                }

            }

            //Handling the exception if user enters choice which is not a integer value
            catch (Exception e) {
                //Printing the error message if the user gives any other data type input
                System.out.println("Invalid input. Please try again!!");

                //Consuming the nextline to clear the input stored in exception case
                sc.nextLine();
            }
        }
    }

    //Method to initialize the student details structures
    public static void initializer(){
        //Using for loops and iterating upto the student capacity value which is 100
        for(int i = 0; i< students_capacity; i++){
            //Initializing all the elements of student id array to "-" value
            ID[i]="-";

            //Creating the new student object with default values for student name and student id as "-"
            students[i] = new Student("-", "-");

            //Creating the new module object with default values for modules,total,average and grade
            modules[i] = new Module(0,0,0,0,0,"N/A");
        }
    }




    //Method to check the available seats in the intake
    public static int checkAvailableSeats() {
        //Declaring and initializing the available seats variable
        int a_seat =0;

        //Using for loop to iterate over the student id array and counting the number of empty seats by counting the number of "-"
        for (int i = 0; i < ID.length; i++) {
            //Checking whether the the current index is equalls to "-"
            if (ID[i].equals("-")) {
                //If yes, increasing the availabe seats value by 1
                a_seat++;
            }
        }
        //Returning the total number of available seats
        return a_seat;

    }


    //Method to validate whether the student id given as input by the user stick with the university id format
    public static boolean StudentIDValidate(String student_id) {
        //Checking whether there are 8 characters present in the id user inputted and check whether the first character is "w"
        if (student_id.length() == 8 && student_id.charAt(0) == 'w') {
            //Checking whether the characters from index 1 to index 7 are digits
            if (student_id.substring(1, 8).matches("[0-9]+")) {
                //Returning validation is true if it satisfies all the conditions
                return true;
            }
        }
        //If the user input condition does not met the university id format returning as false
        return false;
    }



    //Method to check whether the user input student id exists in the id array
    public static  boolean IDChecker(String id){
        //Initializing the id index to -1 which means the id is not found yet
        ID_index=-1;

        //Using for loop and itrating over the id array
        for (int i = 0; i<ID.length; i++) {
            //checking whether the id in the current index  match with the id given as input by the user
            if (ID[i].equals(id)) {
                //if id is found in the array storing the index of the array in the variable id_index
                ID_index = i;
                //Also returning the value as true
                return true;
            }
        }
        //If user inputted id is not found in the existing id array then returning the value as false
        return false;

    }


    //Method to enroll a student to the university
    public static void Register() {
        //Declaring the string variable to store the student id
        String student_id ;

        //Finding the number of available seats for the intake remaining and storing the value in a integer variable a_seats
        int a_seat = checkAvailableSeats();

        //Using if condition to  only proceed if there is available seats
        if (a_seat != 0 ) {
            //Using while true loop prompting and asking the user to enter the student id until user gives a valid id input
            while (true) {
                System.out.println("Enter the Student ID (eg:w2084774):");
                student_id = sc.nextLine();

                //Checking whether the user inputted student id satisfies the required id format
                if (StudentIDValidate(student_id)) {

                    //Checking whether user inputted student id already registered or not
                    if (!IDChecker(student_id)) {
                        String s_name;

                        //Using while true loop to keep prompting and asking for student name until the user enters a valid input
                        while (true) {
                            try {
                                System.out.println("Enter the Student Full name: ");
                                s_name = sc.nextLine();
                                //Breaking the loop if valid user name is entered
                                break;
                            }
                            //Printing an error message if user enters anything other than alphabets
                            catch (Exception e) {
                                System.out.println("The name should be consists only alphabets");
                            }
                        }

                        //Creating a student object with the id and the name of the  student enrolled
                        Student student = new Student(student_id ,s_name);


                        //Using for loop to find an empty slot in the id array where value is "-"
                        for(int i=0; i<100 ; i++){
                            if(ID[i].equals("-")){
                                //Storing the user given id in that slot
                                ID[i]=student_id;

                                //Storing the user given name in student object array in the same index value where student id stored in id array
                                students[i] = student ;
                                //Exiiting the loop after finding the empty slot
                                break;
                            }
                        }
                        //Printing an  registration success message and exiting out the loop
                        System.out.println("Student successfully registered! Best of Luck!!");
                        break;

                    }
                    //If the id user entered to register already exists in id array printing the message saying it
                    else{
                        System.out.println("The Student ID you entered is already existing!!. Try again!!");
                    }


                }
                //If the user inputted id does not met the id formt criteria printing the message notifying it
                else {
                    System.out.println("The student id should be 8 characters long and should start with 'w'");
                }
            }

        }
        //If the available seats count is equals to zero printing an message saying it
        else {
            System.out.println("There are no seats available to register the student");
        }
    }


    //Method to delete student details
    public static void Delete(){
        System.out.println("Enter the student id to be deleted: ");
        String del_id=sc.nextLine();
        //Checking whether the inputted id to be deleted met the id format and exists
        if(StudentIDValidate(del_id)){
            if(IDChecker(del_id)){

                //Replacing the id with "-" symbol in the respective index slot
                ID[ID_index]="-";

                //Replacing the student name and student id in the student object  in the respective slot with "-" symbol
                students[ID_index].setID("-");
                students[ID_index].setS_Name("-");

                //Resetting the module marks,total,average to zero in the repective index
                modules[ID_index].setMaths(0);
                modules[ID_index].setCsf(0);
                modules[ID_index].setSd1(0);
                modules[ID_index].setTotal(0);
                modules[ID_index].setAverage(0);

                //Replacing the student grade with string value "N/A"
                modules[ID_index].setGrade("N/A");


                System.out.println("The Student deleted successfully");
            }
            //Printing an error message if the user inputted id to be deleted does not exists in the id array
            else{
                System.out.println("The inputted student id does not exists!!");
            }
        }
        //Printing an error message if the user inputted id does not match the id format
        else{
            System.out.println("The inputted id is invalid");
        }
    }


    //Method to find the student name of the respective id input
    public static void Find(){
        System.out.println("Enter the student id to be found: ");
        String f_id=sc.nextLine();

        //Checking whether the inputted id to be found met the id format and exists
        if(StudentIDValidate(f_id)){
            if(IDChecker(f_id)){
                //if both condition satisfied and found, retrieving and displaying the student name belongs to the respective id
                System.out.println("The student name belongs to this id is: "+students[ID_index].getS_Name());
            }
            //Printing an error message if the user inputted id to be found does not exists
            else{
                System.out.println("The inputted student id does not exists!!");
            }
        }
        //Printing an error message if the user inputted id does not match the id format
        else{
            System.out.println("The inputted id is invalid");
        }

    }

    //Method to save student details to the text file
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
            for (int i = 0; i < students_capacity; i++) {
                if (!ID[i].equals("-")) {
                    //Storing the data in a variable details separated using commas
                    String details = (ID[i] + "," + students[i].getS_Name() + "," +  modules[i].getMaths() + "," +  modules[i].getCsf() + "," +modules[i].getSd1() + "," +modules[i].getTotal() + "," +modules[i].getAverage() + "," +modules[i].getGrade());

                    //Writting the student details to the file
                    writer.println(details);
                }

            }

            //Closing then PrintWriter object
            writer.close();

            System.out.println("Student details saved successfully to the file.");

        }
        //If any error occurs when creating the file. Handling it by printing an error message for it
        catch (FileNotFoundException e) {
            System.out.println("Sorry, An error occured while saving to text file!");
        }
    }

    //Method to load data back from the text file
    public static void LoadData() {
        try {
            //Creating a file object
            File file = new File("student details.txt");

            //Creating a scanner object to read the student data in the file
            Scanner fileScanner = new Scanner(file);

            //Skipping the header 2 lines
            fileScanner.nextLine();
            fileScanner.nextLine();

            //Using while loop to loop until the end line of the text file or until the 100 seat capacity is reached
            while (fileScanner.hasNextLine() && checkAvailableSeats() <= 100) {
                //Reading a line from the file
                String line = fileScanner.nextLine();
                //Splitting the read line by commas and getting the data pieces and storing it in data array
                String[] data = line.split(",");


                // Using IDChecker to check for duplicates and proceeding only if id is valid and not a duplicate
                if(StudentIDValidate(data[0])) {
                    if (!IDChecker(data[0])) {

                        //Creating the student object from the data retrieved
                        Student student = new Student(data[0], data[1]);

                        //converting back the marks from string to double
                        double maths  = Double.parseDouble(data[2]);
                        double csf = Double.parseDouble(data[3]);
                        double sd1 = Double.parseDouble(data[4]);
                        double marks = Double.parseDouble(data[5]);
                        double average = Double.parseDouble(data[6]);

                        String grade = data[7];

                        //Creating the module object from the data retrieved
                        Module module = new Module(maths,csf, sd1,marks,average,grade);

                        //Using for loop finding an empty space ("-") and storing the data in the found index in respective slots
                        for(int i = 0; i< students_capacity; i++){
                            if(ID[i].equals("-")){
                                ID[i] = data[0];
                                students[i] = student ;
                                modules[i] = module ;
                                //Breaking and exitting from the loop after finding a empty slot
                                break;
                            }
                        }



                    }
                    else{
                        //Skipping to the next line if the id is a duplicate
                        continue;
                    }
                }



            }

            //Closing the file scanner object
            fileScanner.close();

            System.out.println("Student details retrieved successfully from the file.");
        }
        //Printing an error message if file is not found
        catch (FileNotFoundException e) {
            System.out.println("Sorry, an error occurred when retrieving data: " + e.getMessage());
        }
        //Printing an error message if any error occured when passing the values from string to doubles
        catch (NumberFormatException e) {
            System.out.println("Sorry, an error occurred when parsing the data: " + e.getMessage());
        }
    }




    //Method to view the stuent details
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
        for (int i=0 ; i<students_capacity; i++) {
            if(!ID[i].equals("-")) {
                System.out.printf("%-20s\t%s\n", students[i].getS_Name(), ID[i]);
            }
        }
    }




    //Method to update student name
    public static void UpdateName(){
        System.out.println("Enter the student Id: ");
        String u_id=sc.nextLine();

        //Checking whether the inputted id to be updated with name met the id format and exists
        if(StudentIDValidate(u_id)) {
            if (IDChecker(u_id)) {
                //if found printing the current name belongs to that id
                System.out.println("The current student name is: " + students[ID_index].getS_Name());

                //using while true infinite loop to prompt the user and asking for the confirmation
                while (true) {
                    System.out.println("Do you like to change the current student name ['Y'/'N']: ");
                    String option = sc.nextLine();

                    //Converting the user input to uppercase to avoid case sensitive issues
                    option = option.toUpperCase();

                    //Using switch case to proceed based on user wish
                    switch (option) {
                        case "Y": {
                            System.out.println("Enter the new student name to be updated: ");
                            String updated_name = sc.nextLine();
                            //Updating the new student name in student object
                            students[ID_index].setS_Name(updated_name);
                            break;
                        }
                        case "N": {
                            //Printing a message saying name is not updated
                            System.out.println("The Student Name does not updated!");
                            break;
                        }
                        default: {
                            //Handling if the user enters anything other tha Y or N
                            System.out.println("Invalid input!!.Enter 'Y' or 'N");
                            break;
                        }
                    }
                    //Exitting from the loop is the user chooses an valid option
                    break;
                }
            }
            //Printing an error message if the user inputted id to be found does not exists
            else {
                System.out.println("The inputted student id does not exists!!");
            }
        }
        //Printing an error message if the user inputted id does not match the id format
        else {
            System.out.println("The inputted id is invalid");
        }

    }


    //Method to add the module marks and finding grade, average and total
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

                while(true) {

                    //Using try block to enusre user enters numeral value as marks
                    try {
                        //Asking the user to input the module marks  and storing it in respective variables temperorily
                        System.out.println("Enter the module marks for maths: ");
                        m_maths = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Enter the module marks for CSF: ");
                        m_csf = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Enter the module marks for SD1: ");
                        m_sd1 = sc.nextDouble();
                        sc.nextLine();
                        break;


                    }
                    //Printing an exception message if the user enters invalid inputs
                    catch (Exception e) {
                        System.out.println("The module marks should be in numeral value");
                        sc.nextLine();
                    }
                }

                //calculating the total marks by adding the marks of all 3 modules and storing it in total variable
                Total = m_maths + m_csf +m_sd1;

                //Calculating the average by dividing the total by 3 since, there is only 3 modules
                Average = Total / 3 ;

                //Finding and storing the grade if the student based on his average
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

                //Creating a module object with the marks,total,average and grade found
                Module module =new Module(m_maths,m_csf,m_sd1,Total,Average,Grade);

                //Updating the modules array with the module object created
                modules[ID_index] =module ;


            }
            //Printing an error message if the user inputted id to be found does not exists
            else {
                System.out.println("The inputted student id does not exists!!");
            }
        }
        //Printing an error message if the user inputted id does not match the id format
        else{
            System.out.println("The inputted id is invalid");
        }
    }




    public static void Summary(){
        //Initializing variables to count the number of students who got marks above 40 for each module
        int n_csf=0;
        int n_maths=0;
        int n_sd1=0;
        //Variable to store the number of students whose marks are not updated yet
        int not_available=0;

        //Finding the number of registered students and storing it in a variable registration
        int Registration = students_capacity - checkAvailableSeats();

        //Using for loop to iterate to the number of registered id length
        for(int i=0; i<ID.length;i++){
            //Checking whether the grade of the student is not equalls to not appliable
            if (!modules[i].getGrade().equals("N/A")) {
                //if satisfies counting the number of students who got above 40 for each modules
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

            //Counting the number of students whos grade is (N/A) and incrementing
            if (!ID[i].equals("-")) {
                if (modules[i].getGrade().equals("N/A")){
                    not_available ++;
                }

            }
        }


        //Printing the summary of students who got marks above 40 for every modules
        System.out.println("The total number of registered students in the university: "+Registration);
        System.out.println("Total number of students who's marks added is :  "+(not_available));
        System.out.println("\nTotal number of students scored more than 40 for Maths is: "+n_maths);
        System.out.println("Total number of students scored more than 40 for CSF is: "+n_csf);
        System.out.println("Total number of students scored more than 40 for SD1 is: "+n_sd1);

    }


    //Method to  bubble sort average from highest to loweest and print student statistics accordingly
    public static void report() {
        //Setting the bottom index for the bubble sort
        int bottom = modules.length - 2;

        //Boolean flag to track with  swapping occurs
        boolean exchanged = true;

        // Bubble sorting in descending order based on module averages
        while (exchanged) {

            //Resetting the boolean flag to the value of false
            exchanged = false;

            //Using for loop to loop through all the elements except the last sorted element
            for (int i = 0; i <= bottom; i++) {
                //Comparing the module average next to each other using if conditions
                if (modules[i].getAverage() < modules[i+1].getAverage()) {
                    // Swapping accordingly the student ids
                    String t_ID = ID[i];
                    ID[i] = ID[i+1];
                    ID[i+1] = t_ID;

                    // Swapping accordingly the student objects
                    Student t_Student = students[i];
                    students[i] = students[i+1];
                    students[i+1] = t_Student;

                    // Swapping accordingly the module objects
                    Module t_Module = modules[i];
                    modules[i] = modules[i+1];
                    modules[i+1] = t_Module;


                    //Setting the boolen flag to true to because swap occured
                    exchanged = true;
                }
            }
            //Decrementing the bottom index for the next iteration
            bottom--;
        }


        // Printing the  report in sorted order according to average from highest to lowest

        //Printing the column headings of the report
        System.out.printf("%-20s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%s\n",
                "Student ID", "Name", "Maths", "CSF" ,"SD1","Total", "Average", "Grade");

        //printing the module details and student details of each and every student using for loop
        for (int i = 0; i < students_capacity; i++) {
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



    //Main method to excecute the program
    public static void main(String[] args) {
        //Calling the initializer method to initilize things
        initializer();
        //Calling the mainmenu method to display main menu
        MainMenu();
    }
}