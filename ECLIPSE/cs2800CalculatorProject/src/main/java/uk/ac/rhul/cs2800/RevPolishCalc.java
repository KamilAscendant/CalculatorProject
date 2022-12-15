package uk.ac.rhul.cs2800;

import java.util.Scanner;
import uk.ac.rhul.cs2800.InvalidExpressionException;

public class RevPolishCalc {
  private NumStack values;
  private float answer;
  
  public float evaluate(String expression) throws InvalidExpressionException{
    if (expression == null || expression.equalsIgnoreCase("")) {
      throw new InvalidExpressionException("There is no expression to evaluate.");
    }
    else {
      Scanner equation = new Scanner(expression);
      this.values = new NumStack();
      while(equation.hasNext()) {
        if(equation.hasNextFloat()) {
          this.values.push(equation.nextFloat());
        }
      }
      this.answer = this.values.pop();
      return(this.answer);
    }
  }
}
