package uk.ac.rhul.cs2800;

public class StandardCalc {
  
  private RevPolishCalc rp;
  private StrStack rpEvaluates;
  
  public StandardCalc() {
    rp = new RevPolishCalc();
    rpEvaluates = null;
  }
  
  public float evaluate(String expression) throws InvalidExpressionException {
    if (expression == null || expression == ("")) {
      throw new InvalidExpressionException("Invalid Expression");
    }
    return 0f;
  }
}
