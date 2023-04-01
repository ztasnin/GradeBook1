public class APClass extends Classroom {
  private int APScore;

  // APClass constructor
  public APClass(String className, double grade, int APScore) {
    super(className, grade);
    this.APScore = APScore;
  }


  // Overrides getGrade() from Classroom class
  @Override
  public double getGrade(){
    return (int)(super.getGrade() * 1.1 * 100)/100.00;
  }

  // new method
  // returns APScore
  public int getAPScore() {
    return APScore;
  }

  // Overrides getGradeString() from Classroom class
  @Override
  public String getGradeString() {
    double dou = Double.parseDouble(super.getGradeString());
    dou = (int)(dou * 1.1*100)/100.00;
    return Double.toString(dou) + "\n" + "AP Score: " + getAPScore();

  }
}

