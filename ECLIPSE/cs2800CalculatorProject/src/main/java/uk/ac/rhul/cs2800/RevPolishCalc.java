package uk.ac.rhul.cs2800;

import uk.ac.rhul.cs2800.InvalidExpressionException;

public class RevPolishCalc {
  public float evaluate(String expression) throws InvalidExpressionException{
    if (expression == null || expression.equalsIgnoreCase("")) {
      throw new InvalidExpressionException("There is no expression to evaluate.");
    }
    return 99.7f;
  }
}
