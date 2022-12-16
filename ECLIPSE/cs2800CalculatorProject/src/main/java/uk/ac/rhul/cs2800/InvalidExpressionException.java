package uk.ac.rhul.cs2800;

/**
 * Exception that is thrown whenever a string that cannot be evaluated is submitted to the calculator.
 * Influenced by https://www.baeldung.com/java-new-custom-exception
 *
 * @author zkac152
 *
 */
public class InvalidExpressionException extends Exception {
  
  private static final long serialVersionUID = 2L;
  
  public InvalidExpressionException(String string) {}
}
