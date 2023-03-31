import java.util.ArrayList;

public class Student {
  private String name;
  private int ID;
  private String year;
  private int volunteeringHours;
  private ArrayList<Classroom> classList;

  public Student(){

  }
  public Student(String name, int  ID, String year, int volunteeringHours){
    this.name = name;
    this.ID = ID;
    this.year = year;
    this.volunteeringHours = volunteeringHours;
    classList=new ArrayList<Classroom>();
  }

  public String getName() {
    return name;
  }

  public int getID(){
    return ID;
  }

  public String getYear(){
    return year;
  }

  public int getHours(){
    return volunteeringHours;
  }

  public ArrayList<Classroom> getGradeList(){
    return classList;
  }

  public double calculateAverage() {
    double sum = 0;
    for (Classroom class1: classList) {
      sum += class1.getGrade();
    }
    return sum / classList.size();
  }

  public void addHours(int hour){
    volunteeringHours+=hour;
  }

  public void addClass(Classroom class1){
    classList.add(class1);
  }
}











