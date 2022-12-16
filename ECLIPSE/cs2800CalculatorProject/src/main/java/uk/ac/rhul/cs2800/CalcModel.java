package uk.ac.rhul.cs2800;

/**
 * The CalcModel that can choose between infix and postfix Calculators to evaluate a String.
 * 
 * @author zkac152
 */
public class CalcModel {
  private Calculator infCalc;
  private Calculator postCalc;
  
  /**
   * Constructor that creates a new Standard and Reverse Polish Calculator that is used by the CalcModel to 
   * evaluate expressions.
   */
  public CalcModel() {
    infCalc = new StandardCalc();
    postCalc = new RevPolishCalc();
  }
  
  /**
   * @param String question is the expression to be evaluated.
   * @param Boolean infix tracks whether the infix or Postfix Calculator is called by the Model.
   * 
   * @return float evaluate the answer of the expression.
   * @throws InvalidExpressionException
   */
  public final float evaluate(final String question, boolean infix) throws InvalidExpressionException {
    if (infix == true) {
      return this.infCalc.evaluate(question);
    }else {
      return this.postCalc.evaluate(question);
    }
  }

}
