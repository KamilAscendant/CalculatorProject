package uk.ac.rhul.cs2800;

/**
 * Exception that is thrown whenever a getter differing from the type of the Entry is called.
 * Influenced by https://www.baeldung.com/java-new-custom-exception
 *
 * @author zkac152
 *
 */
public class BadTypeException extends RuntimeException {

  private static final long serialVersionUID = 1L; // Eclipse insisted on adding this.

  public BadTypeException() {}


}
