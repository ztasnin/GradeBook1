public class Classroom{
  private String className;
  private double grade;

  public Classroom(String className, double average) {
    this.className = className;
    this.grade = average;
  }

  public double getGrade() {
    return grade;
  }


  public String getClassName(){
    return className;
  }

  public String getGradeString() {
    return Double.toString(this.grade);
  }
}

