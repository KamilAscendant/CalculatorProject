package uk.ac.rhul.cs2800;

import java.util.Scanner;
import uk.ac.rhul.cs2800.InvalidExpressionException;

public class RevPolishCalc {
  private NumStack values;
  private float answer;
  
  public float evaluate(String expression) throws InvalidExpressionException{
    if (expression == null || expression == ("")) {
      throw new InvalidExpressionException("There is no expression to evaluate.");
    }
    else {
      Scanner equation = new Scanner(expression);
      this.values = new NumStack();
      while(equation.hasNext()) {
        if(equation.hasNextFloat()) {
          this.values.push(equation.nextFloat());
        }else {
          String symbols = equation.next();
          Symbol[] operators;
          Symbol currentOperator = Symbol.INVALID;
          int x = (operators = Symbol.values()).length; 
          for(int i = 0; i < x; i++) {
            Symbol checkingOperator = operators[i];
            String opExec = checkingOperator.toString();
            if (opExec.equals(symbols)){
              currentOperator = checkingOperator;
              break;
            }
          }
          if(currentOperator.equals(Symbol.PLUS)) {
            float add = this.values.pop() + this.values.pop();
            this.values.push(add);
          }else {
          }
        }
      }
    }
    this.answer = this.values.pop();
    return(this.answer);
  }
}
