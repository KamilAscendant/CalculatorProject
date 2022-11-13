package uk.ac.rhul.cs2800;

/**
 * Stores the enum values of all possible Symbols as well as associated String values. Also contains
 * toString method of Symbol.
 *
 * @author zkac152
 *
 */
public enum Symbol {
  LEFT_BRACKET("Left Bracket"), RIGHT_BRACKET("Right Bracket"), TIMES("Times"), DIVIDE(
      "Divide"), PLUS("Plus"), MINUS("Minus"), INVALID("Invalid");

  private String symbol;

  /**
   * Takes the enum value of a Symbol object and loads the associated String value.
   *
   * @param inputSymbol The enum symbol for which the String value is being requested.
   */
  private Symbol(String inputSymbol) {
    this.symbol = inputSymbol;
  }

  @Override
  public String toString() {
    return symbol;
  }

}
