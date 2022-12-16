package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * Creates a Standard Calculator object implementing the Calculator interface. This code was influenced by the demo code
 * from Moodle as well as Professor Cohen's videos.
 * 
 * @author zkac152
 */
public class StandardCalc implements Calculator {

  private RevPolishCalc rp;
  private StrStack rpEvaluator;
  private OpStack operators;
  private StringBuilder evaluates;

  /**
   * Constructor for the StandardCalc. Creates a ReversePolishCalc that handles the calculations.
   */
  public StandardCalc() {
    rp = new RevPolishCalc();
    rpEvaluator = null;
    operators = null;
    evaluates = null;

  }

  /**
   * The expression to be evaluated. Iterates over the expression, putting numbers into a Stack and operating on them to give a result.
   * 
   * @param String expression to be evaluated.
   * @return The output of the expression after all operations have been resolved.
   * @throws InvalidExpressionException - thrown when an empty expression is input.
   */
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
        lastCharNumber = true;
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
        if (currentOperator.equals(Symbol.MINUS)) {
          currentOperator = Symbol.INVERSEMINUS;
        } else if (currentOperator.equals(Symbol.DIVIDE)) {
          currentOperator = Symbol.INVERSEDIVIDE;
        } else if (currentOperator.equals(Symbol.POWER)) {
          currentOperator = Symbol.INVERSEPOWER;
        }
        this.operators.push(currentOperator);
        lastCharNumber = false;
      }
    }
    while (this.operators.size() != 0) {
      evaluates.append(this.operators.pop().toString() + " ");
    }
    String finalEquation = evaluates.toString();
    System.out.println(finalEquation);
    float result = rp.evaluate(finalEquation);
    return result;
  }
}
