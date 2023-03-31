public class APClass extends Classroom {
  private int APScore;
  public APClass(String className, double grade, int APScore) {
    super(className, grade);
    this.APScore = APScore;
  }

  @Override
  public double getGrade(){
    return Math.round(super.getGrade() * 1.1);
  }

  public int reportAPScore() {
    return APScore;
  }

  @Override
  public String getGradeString() {
    double dou = Double.parseDouble(super.getGradeString());
    dou = Math.round(dou * 1.1);
    return Double.toString(dou) + "\n" + "AP Score: " + APScore;

  }
}
