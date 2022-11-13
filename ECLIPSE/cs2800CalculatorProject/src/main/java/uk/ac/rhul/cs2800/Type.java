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

  private Type(String inputType) {
    this.type = inputType;
  }

  @Override
  public String toString() {
    return type;
  }
}
