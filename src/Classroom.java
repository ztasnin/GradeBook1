public class Classroom{
  private String className;
  private double grade;


  // Classroom constructor
  public Classroom(String className, double grade) {
    this.className = className;
    this.grade = grade;
  }

  // returns className
  public String getClassName(){
    return className;
  }

  // returns grade
  public double getGrade() {
    return grade;
  }



  // returns grade as string
  public String getGradeString() {
    return Double.toString(this.grade);
  }
}




