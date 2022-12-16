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
    while(equation.hasNext()) {
      rpEvaluator.push(equation.next());
    }
    equation.close();
    while(rpEvaluator.size() != 0) {
      evaluates.append(String.valueOf(rpEvaluator.pop()));
    }
    String finalEquation = evaluates.toString();
    float result = rp.evaluate(finalEquation);
    return result;
  }
}
