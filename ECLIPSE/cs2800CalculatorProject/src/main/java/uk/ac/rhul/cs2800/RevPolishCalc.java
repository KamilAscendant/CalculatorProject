package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class RevPolishCalc {
  private NumStack values;
  private float answer;

  /**
   * @param The expression to be evaluated. Iterates over the expression, putting numbers into a Stack and operating on them to give a result.
   * @return The output of the expression after all operations have been resolved.
   * @throws InvalidExpressionException - thrown when an empty expression is input.
   */
  public float evaluate(String expression) throws InvalidExpressionException {
    if (expression == null || expression == ("")) {
      throw new InvalidExpressionException("There is no expression to evaluate.");
    }
    Scanner equation = new Scanner(expression);
    this.values = new NumStack();
    while (equation.hasNext()) {
      if (equation.hasNextFloat()) {
        this.values.push(equation.nextFloat());
      } else {
        String symbols = equation.next();
        Symbol[] operators;
        Symbol currentOperator = Symbol.INVALID;
        int x = (operators = Symbol.values()).length;
        for (int i = 0; i < x; i++) {
          Symbol checkingOperator = operators[i];
          String opExec = checkingOperator.toString();
          if (opExec.equals(symbols)) {
            currentOperator = checkingOperator;
            break;
          }
        }
        if (currentOperator.equals(Symbol.PLUS)) {
          float add = this.values.pop() + this.values.pop();
          this.values.push(add);
        } else if (currentOperator.equals(Symbol.MINUS)) {
          float subtractor = this.values.pop();
          float subtractee = this.values.pop();
          float subtract = subtractee - subtractor;
          this.values.push(subtract);
        } else if (currentOperator.equals(Symbol.TIMES)) {
          float multiplied = this.values.pop() * this.values.pop();
          this.values.push(multiplied);
        } else if (currentOperator.equals(Symbol.DIVIDE)) {
          float divisor = this.values.pop();
          float dividend = this.values.pop();
          float result = dividend / divisor;
          this.values.push(result);
        }
      }
    }
    equation.close();
    this.answer = this.values.pop();
    if (this.values.size() != 0) {
      throw new InvalidExpressionException("Imbalanced operation");
    }
    return (this.answer);
  }
}
