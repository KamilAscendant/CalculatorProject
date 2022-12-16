package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class StandardCalc {

  private RevPolishCalc rp;
  private StrStack rpEvaluator;
  private OpStack operators;
  private StringBuilder evaluates;

  public StandardCalc() {
    rp = new RevPolishCalc();
    rpEvaluator = null;
    operators = null;
    evaluates = null;

  }

  public float evaluate(String expression) throws InvalidExpressionException {
    if (expression == null || expression == ("")) {
      throw new InvalidExpressionException("Invalid Expression");
    }
    Scanner equation = new Scanner(expression);
    this.rpEvaluator = new StrStack();
    this.operators = new OpStack();
    this.evaluates = new StringBuilder();
    while (equation.hasNext()) {
      rpEvaluator.push(equation.next());
    }
    equation.close();
    boolean lastCharNumber = false;
    while (rpEvaluator.size() != 0) {
      String currentCharacter = this.rpEvaluator.pop();
      char numberCheck = currentCharacter.charAt(0);
      if (Character.isDigit(numberCheck) && lastCharNumber == false) {
        evaluates.append(String.valueOf(currentCharacter) + " ");
      } else {
        Symbol[] operators;
        Symbol currentOperator = Symbol.INVALID;
        int x = (operators = Symbol.values()).length;
        for (int i = 0; i < x; i++) {
          Symbol checkingOperator = operators[i];
          String opExec = checkingOperator.toString();
          if (opExec.equals(currentCharacter)) {
            currentOperator = checkingOperator;
            break;
          }
        }
        this.operators.push(currentOperator);
      }
    }
    while (this.operators.size() != 0) {
      evaluates.append(this.operators.pop().toString() + " ");
    }
    String finalEquation = evaluates.toString();
    float result = rp.evaluate(finalEquation);
    return result;
  }
}
