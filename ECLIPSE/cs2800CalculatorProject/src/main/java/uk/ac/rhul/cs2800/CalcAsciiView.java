package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * An Ascii menu that interacts with the Calculator so the client can use it.
 * 
 * @author zkac152
 *
 */
public class CalcAsciiView {

  /**
   * Main body of the Ascii view, takes user inputs and uses the Model to evaluate them.
   * @param args
   */
  public static void main(String[] args) {
    CalcModel Calculator = new CalcModel();
    String expression = "Startup";
    boolean infix = true;
    calcMenu();
    Scanner request = new Scanner(System.in);
    while(!expression.equalsIgnoreCase("e")) {
      expression = request.nextLine();
      System.out.println("The expression you entered was " + expression);
      if (expression.equalsIgnoreCase("p")) {
        infix = false;
        System.out.println("You are now in Postfix mode. Enter 'i' to swith to Infix mode.");
      }else if (expression.equals("i")) {
        infix = true;
        System.out.println("You are in infix mode. Enter 'p' to switch to Reverse Polish Notation");
      }else {
        try {
          System.out.println(Calculator.evaluate(expression, infix));
        }
        catch (Exception e) {
          System.out.println("Invalid expression - please try again.");
        }
      }
    }
    request.close();
   System.out.println("Goodbye");
  }
  
  /**
   * Method to print out the Ascii menu
   * 
   */
  public static void calcMenu() {
    System.out.println("Welcome to the calculator!");
    System.out.println("Type in your expression. Make sure you leave spaces between the characters.");
    System.out.println("Enter 'e' to exit the program.");
    System.out.println("Enter 'p' to switch to Reverse Polish Notation");
  }
}

