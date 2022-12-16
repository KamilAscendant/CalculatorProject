package uk.ac.rhul.cs2800;

public class CalcModel {
  private Calculator infCalc;
  private Calculator postCalc;
  
  public CalcModel() {
    infCalc = new StandardCalc();
    postCalc = new RevPolishCalc();
  }
  
  public final float evaluate(final String question, boolean infix) throws InvalidExpressionException {
    if (infix == true) {
      return this.infCalc.evaluate(question);
    }else {
      return this.postCalc.evaluate(question);
    }
  }

}
