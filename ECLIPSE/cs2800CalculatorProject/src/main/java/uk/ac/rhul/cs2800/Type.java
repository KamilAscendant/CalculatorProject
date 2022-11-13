package uk.ac.rhul.cs2800;

/**
 * Enum that stores the different types of Entries as well as associated String value.
 *
 * @author zkac152
 *
 */
public enum Type {
  NUMBER("Number"), SYMBOL("Symbol"), STRING("String"), INVALID("Invalid");

  private String type;

  /**
   * Takes the datatype as input and sets the type of the Entry accordingly.
   * 
   * @param inputType is the string representation of the Entry's datatype.
   */
  private Type(String inputType) {
    this.type = inputType;
  }

  @Override
  public String toString() {
    return type;
  }
}
