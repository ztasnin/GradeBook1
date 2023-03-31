import java.util.Scanner;
public class GradeBook{
  private ArrayList<Student> students;
  private String username;
  private int passcode;
  private Scanner scan;
  public GradeBook(){
    students = new ArrayList<Student>();
    scan = new Scanner(System.in);
  }

  public void start() {
    System.out.println("Welcome to PupilPath Jr!");
    System.out.println("Please enter your username: ");
    String username = scan.nextLine();
    System.out.println("Please enter your password: ");
    int passcode = scan.nextInt();
    scan.nextLine();
    System.out.println("--- Main Menu ---");
    System.out.println("1. Grade Overview");
    System.out.println("2. Individual Student Grade Overview");
    System.out.println("3. Add Student");
    System.out.println("4. Add Grade");
    System.out.println("Enter your choice: ");
  }

  public void addStudent() {
    System.out.print("Student Name: ");
    String name = scan.nextLine();
    System.out.print("Student ID: ");
    int ID = scan.nextInt();
    System.out.print("Student Year: ");
    String year = scan.nextLine();
    System.out.print("Student's Volunteering Hours: ");
    int hour = scan.nextInt();
    Student student1 = new Student(name, ID, year, hour);
    studentList.add(student1);
  }

  public void gradeOverview() {
    System.out.println("Number of students: " + studentList.size());
    int sum = 0;
    for (Student student: students) {
      sum += students.calculateAverage(); 
    }
    double average = sum/students.size();
    average = ((int)(average*100))/100;
    System.out.println("Class Average: " + average);
    
    
  }

  
  

}