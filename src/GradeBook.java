
import java.util.Scanner;
import java.util.ArrayList;

public class GradeBook {
  private ArrayList<Student> students;
  private Scanner scan;
  public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
  public static final String RESET = "\u001B[0m";        // RESET
  public static final String PURPLE = "\033[0;35m";  // PURPLE
  public static final String GREEN = "\033[0;32m";   // GREEN

  //GradeBook Constructor
  public GradeBook() {
    students = new ArrayList<Student>();
    scan = new Scanner(System.in);
  }

  //Starts program
  public void start() {
   System.out.println("Welcome to PupilPath Jr!");
    printMenu();
    System.out.println("Enter your choice: ");
    int choice = scan.nextInt();
    scan.nextLine();
    while (choice != 5) {
      if (choice == 3) {
        addStudent();
        printMenu();
        System.out.println("Enter your choice: ");
        choice = scan.nextInt();
        scan.nextLine();
      } else if (choice == 1) {
        gradeOverview();
        printMenu();
        System.out.println("Enter your choice: ");
        choice = scan.nextInt();
        scan.nextLine();
      } else if (choice == 4) {
        addGrade();
        System.out.println("Enter your choice: ");
        choice = scan.nextInt();
        scan.nextLine();
      } else if (choice == 2){
        individualStudentOverview();
        printMenu();
        System.out.println("Enter your choice: ");
        choice = scan.nextInt();
        scan.nextLine();
      }
    }
  }

  //Prints menu
  private void printMenu() {
    System.out.println();
    System.out.println(BLUE_BOLD + "--- Main Menu ---");
    System.out.println("1. Grade Overview");
    System.out.println("2. Individual Student Overview");
    System.out.println("3. Add Student");
    System.out.println("4. Add Grade");
    System.out.println("5. Exit" + RESET);
  }

  // prints a general grade overview of the class
  // prints the number of students and class average
  private void gradeOverview() {
    System.out.println("Number of students: " + students.size());
    int sum = 0;
    for (Student student : students) {
      sum += student.calculateAverage();
    }
    double average = sum / students.size();
    average = ((int) (average * 100)) / 100;
    System.out.println("Class Average: " + average);
  }

  // prints a general grade overview of a student
  // prints the name and grade of each class a student takes
  // prints student's cumulative average and volunteering hours completed
  private void individualStudentOverview() {
    System.out.println("Please enter student ID");
    int ID = scan.nextInt();
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getID() == ID) {
        String[][] TDarr = new String[students.get(i).getGradeList().size()][2];
        for (int y = 0; y < students.get(i).getGradeList().size(); y++) {
          TDarr[y][0] = students.get(i).getGradeList().get(y).getClassName();
          TDarr[y][1] = students.get(i).getGradeList().get(y).getGradeString();
        }
        System.out.println(PURPLE + "Student Name: " + RESET + students.get(i).getName().toUpperCase());
        System.out.println(PURPLE + "Student ID: " + RESET + students.get(i).getID());
        System.out.println(PURPLE + "Student Year: " + RESET + students.get(i).getYear());
        System.out.println(PURPLE + "Student Volunteering Hours: " + RESET + students.get(i).getHours());
        System.out.println(PURPLE + "Student's Number of Classes: " + RESET + students.get(i).getGradeList().size());
        for (int row = 0; row < TDarr.length; row++) {
          for (int col = 0; col < TDarr[0].length; col++) {
            System.out.println(TDarr[row][col]);
          }
        }
      }
    }
  }

  // prompts the users questions to add a student to class
  private void addStudent() {
    System.out.print("Student Name: ");
    String name = scan.nextLine();
    System.out.print("Student ID: ");
    int ID = scan.nextInt();
    scan.nextLine();
    System.out.print("Student Year: ");
    String year = scan.nextLine();
    System.out.print("Student's Volunteering Hours: ");
    int hour = scan.nextInt();
    scan.nextLine();
    Student student1 = new Student(name, ID, year, hour);
    students.add(student1);
    System.out.println(GREEN + "Student added successfully!" + RESET);
  }

  //add class and grade to a student's record from ID given
  private void addGrade () {
    System.out.println("Student ID: ");
    int ID = scan.nextInt();
    scan.nextLine();
    System.out.println("Class Name: ");
    String className = scan.nextLine();
    System.out.println("Class Average: ");
    double classGrade = scan.nextDouble();
    scan.nextLine();
    System.out.println("Is an AP class?(yes/no): ");
    String choice1 = scan.nextLine().toLowerCase();
    if (choice1.trim().equals(("yes"))) {
      System.out.println("AP Score: ");
      int score = scan.nextInt();
      scan.nextLine();
      APClass class1 = new APClass("AP " + className, classGrade, score);
      for (int i = 0; i < students.size(); i++) {
        if (students.get(i).getID() == ID) {
          String studentName = students.get(i).getName();
          students.get(i).addClass(class1);
          System.out.println(GREEN + "AP " + className + " was added to " + studentName + "'s class list" + RESET);
        }
      }
    } else {
      Classroom class1 = new Classroom(className, classGrade);
      for (int i = 0; i < students.size(); i++) {
        String studentName = students.get(i).getName();
        if (students.get(i).getID() == ID) {
          students.get(i).addClass(class1);
          System.out.println(GREEN + className + " was added to " + studentName + "'s class list" + RESET);
        }
      }
    }
  }
  private double round(double num){
    return (int)(num*100)/100;
  }
}















