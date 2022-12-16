package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;
import java.util.Scanner;

public class CalcAsciiView {

  public static void main(String[] args) {
    CalcModel Calculator = new CalcModel();
    String expression = "Startup";
    boolean infix = true;
    
    System.out.println("Welcome to the calculator!");
    System.out.println("Type in your expression. Make sure you leave spaces between the characters.");
    System.out.println("Enter 'e' to exit the program.");
    System.out.println("Enter 'p' to switch to Reverse Polish Notation");
    
    while(!expression.equalsIgnoreCase("e")) {
      Scanner request = new Scanner(System.in);
      expression = request.nextLine();
      System.out.println("The expression you entered was " + expression);
      if (expression.equalsIgnoreCase("e")) {
        break;
      }else if (expression.equalsIgnoreCase("p")) {
        infix = false;
        System.out.println("You are now in Postfix mode. Enter 'i' to swith to Infix mode.");
      }else if (expression.equals("i")) {
        infix = true;
        System.out.println("You are in infix mode. Enter 'p' to switch to Reverse Polish Notation");
      }else {
        try {
          System.out.println(Calculator.evaluate(expression, infix));
          
        }
        catch (InvalidExpressionException e) {
          System.out.println("Invalid expression - please try again.");
        }
        catch (EmptyStackException e) {
          System.out.println("Error - try again");
        }
      }
    }
   System.out.println("Goodbye");
  }
}

