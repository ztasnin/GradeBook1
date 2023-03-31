
import java.util.Scanner;
import java.util.ArrayList;
public class GradeBook {
  private ArrayList<Student> students;
  private String username;
  private int passcode;
  private Scanner scan;

  public GradeBook() {
    students = new ArrayList<Student>();
    scan = new Scanner(System.in);
  }

  public void start() {
   /*
   System.out.println("Welcome to PupilPath Jr!");
   System.out.println("Please enter your username: ");
   String username = scan.nextLine();
   System.out.println("Please enter your password: ");
   int passcode = scan.nextInt();
   scan.nextLine();
   System.out.println("\033[H\033[2J");
   */
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
        System.out.println("Enter your choice: ");
        choice = scan.nextInt();
        scan.nextLine();
      } else if (choice == 4) {
        addGrade();
        System.out.println("Enter your choice: ");
        choice = scan.nextInt();
        scan.nextLine();
      } else if (choice == 2){
        individualStudentGradeOverview();
        System.out.println("Enter your choice: ");
        choice = scan.nextInt();
        scan.nextLine();
      }
    }
  }

  public void addStudent() {
    System.out.print("Student Name: ");
    String name = scan.nextLine();
    System.out.print("Student ID: ");
    int ID = scan.nextInt();
    System.out.print("Student Year: ");
    String year = scan.nextLine();
    scan.nextLine();
    System.out.print("Student's Volunteering Hours: ");
    int hour = scan.nextInt();
    scan.nextLine();
    Student student1 = new Student(name, ID, year, hour);
    students.add(student1);
    System.out.println("Student added successfully!");
  }

  public void gradeOverview() {
    System.out.println("Number of students: " + students.size());
    int sum = 0;
    for (Student student : students) {
      sum += student.calculateAverage();
    }
    double average = sum / students.size();
    average = ((int) (average * 100)) / 100;
    System.out.println("Class Average: " + average);
  }

  public void printMenu() {
    System.out.println();
    System.out.println("--- Main Menu ---");
    System.out.println("1. Grade Overview");
    System.out.println("2. Individual Student Grade Overview");
    System.out.println("3. Add Student");
    System.out.println("4. Add Grade");
    System.out.println("5. Exit");
  }


  public void individualStudentGradeOverview() {
    System.out.println("Please enter student ID");
    int ID = scan.nextInt();
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getID() == ID) {
        String[][] TDarr = new String[students.get(i).getGradeList().size()][2];
        for (int y = 0; y < students.get(i).getGradeList().size(); y++) {
          TDarr[y][0] = students.get(i).getGradeList().get(y).getClassName();
          TDarr[y][1] = students.get(i).getGradeList().get(y).getGradeString();
        }
        for (int row = 0; row < TDarr.length; row++) {
          for (int col = 0; col < TDarr[0].length; col++) {
            System.out.println(TDarr[row][col]);
          }
        }
      }
    }



  }

  public void addGrade () {
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
    if (choice1.equals(("yes"))) {
      System.out.println("AP Score: ");
      int score = scan.nextInt();
      scan.nextLine();
      APClass class1 = new APClass("AP " + className, classGrade, score);
      for (int i = 0; i < students.size(); i++) {
        if (students.get(i).getID() == ID) {
          String studentName = students.get(i).getName();
          students.get(i).addClass(class1);
          System.out.println("AP " + className + " was added to " + studentName + "'s class list");
        }
      }
    } else {
      Classroom class1 = new Classroom(className, classGrade);
      for (int i = 0; i < students.size(); i++) {
        String studentName = students.get(i).getName();
        if (students.get(i).getID() == ID) {
          students.get(i).addClass(class1);
          System.out.println(className + " was added to " + studentName + "'s class list");
        }
      }
    }


  }
  public double round(double num){
    return (int)(num*100)/100;
  }

}















