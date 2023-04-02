import java.util.ArrayList;

public class Student {
  private String name;
  private int ID;
  private String year;
  private int volunteeringHours;
  private ArrayList<Classroom> classList;


  // Student constructor
  public Student(String name, int  ID, String year, int volunteeringHours){
    this.name = name;
    this.ID = ID;
    this.year = year;
    this.volunteeringHours = volunteeringHours;
    classList=new ArrayList<Classroom>();
  }

  // returns name
  public String getName() {
    return name;
  }

  // returns ID
  public int getID(){
    return ID;
  }

  // returns year
  public String getYear(){
    return year;
  }

  // returns hours
  public int getHours(){
    return volunteeringHours;
  }

  // returns classList
  public ArrayList<Classroom> getGradeList(){
    return classList;
  }

  public void addClass(Classroom class1){
    classList.add(class1);
  }
  // calculates the average from all classes and returns the average
  public double calculateAverage() {
    double sum = 0;
    for (Classroom class1: classList) {
      sum += class1.getGrade();
    }
    return Math.round(sum / classList.size());
  }
}



