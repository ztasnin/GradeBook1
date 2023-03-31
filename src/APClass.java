public class APClass extends Classroom {
  private int APScore; 
  public APClass(String className, double grade, int APScore) {
    super(className, grade);
    this.APScore = APScore; 
  }

  @Override
  public double getGrade() { 
      return super.getGrade() * 1.1;
    }

  public int getAPScore() {
    return APScore;
  }
}