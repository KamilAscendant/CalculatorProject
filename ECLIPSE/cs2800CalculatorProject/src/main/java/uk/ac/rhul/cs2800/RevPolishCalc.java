package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * Creates a Reverse Polish Calculator object implementing the Calculator interface. This code was influenced by the demo code
 * from Moodle as well as Professor Cohen's videos.
 * 
 * @author zkac152
 */
public class RevPolishCalc implements Calculator {
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
          this.values.push(subtractee - subtractor);
        } else if (currentOperator.equals(Symbol.TIMES)) {
          this.values.push(this.values.pop() * this.values.pop());
        } else if (currentOperator.equals(Symbol.DIVIDE)) {
          float divisor = this.values.pop();
          float dividend = this.values.pop();
          this.values.push(dividend / divisor);
        } else if (currentOperator.equals(Symbol.INVERSEDIVIDE)) {
          float divisor = this.values.pop();
          float dividend = this.values.pop();
          this.values.push(divisor / dividend);
        } else if (currentOperator.equals(Symbol.INVERSEMINUS)) {
          float subtractor = this.values.pop();
          float subtractee = this.values.pop();
          this.values.push(subtractor - subtractee);
        } else if (currentOperator.equals(Symbol.POWER)) {
          float power = this.values.pop();
          float number = this.values.pop();
          float output = number;
          for (int i = 1; i<power; i++) {
            output = output * number;
          }
          this.values.push(output);
        } else if (currentOperator.equals(Symbol.INVERSEPOWER)) {
          float number = this.values.pop();
          float power = this.values.pop();
          float output = number;
          for (int i = 1; i<power; i++) {
            output = output * number;
          }
          this.values.push(output);
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
  
  private float evaluateOperation(Symbol operand, float num1, float num2) throws InvalidExpressionException {
    float result = 0;
    switch (operand) {
      case PLUS: {
        result = num1 + num2;
      }
      case MINUS: {
        result = num2 - num1;
      }
      case INVERSEMINUS: {
        result = num1 - num2;
      }
      case DIVIDE: {
        result = num2 / num1;
      }
      case INVERSEDIVIDE: {
        result = num1 / num2;
      }
      case TIMES: {
        result = num1 * num2;
      }
      case POWER: {
        for (int i = 1; i < num2; i++) {
          result = result * num1;
        }
      }
      case INVERSEPOWER: {
        for (int i = 1; i < num1; i++) {
          result = result * num2;
        }
      }
    }
    return result;
  }
}
