package uk.ac.rhul.cs2800;

import java.util.Objects;

/**
 * Creating a class to store entered values of different types in the Stack.
 *
 * @author zkac152
 *
 */
public class Entry {
  private String str;
  private float number;
  private Symbol other;
  private Type type;

  /**
   * Creates an Entry object of type float and stores its type.
   *
   * @param input Float number input into system.
   */
  public Entry(Float input) {
    this.number = input;
    this.type = Type.NUMBER;
  }

  /**
   * Creates an Entry object of type float and stores its type.
   *
   * @param input Takes an integer argument and converts it to a float before storing.
   */
  public Entry(int input) {
    this.number = (float) input;
    this.type = Type.NUMBER;
  }

  /**
   * Getter to retrieve the value of a float Entry. Throws an Exception if other getter called.
   *
   * @return Value of the Entry.
   * @throws BadTypeException if incorrect getter is called.
   */
  public Float getNumber() {
    if (this.getType() != Type.NUMBER) {
      throw new BadTypeException(); // Added statement to throw exception when calling wrong type.
    }
    return this.number;
  }

  /**
   * Creates an Entry with a String value.
   *
   * @param input Stores the String's value and saves the Entry type as String.
   */
  public Entry(String input) {
    this.str = input;
    this.type = Type.STRING;
  }

  /**
   * Getter for retrieving value of String Entries. Throws Exception when incorrect Getter called.
   *
   * @return The stored String value of the Entry.
   * @throws BadTypeException when getter of wrong Type is called.
   */
  public String getStr() {
    if (this.getType() != Type.STRING) {
      throw new BadTypeException(); // Added statement to throw exception when calling wrong type.
    }
    return this.str.toString();
  }

  /**
   * Creates an Entry object to store an enum Symbol.
   *
   * @param input takes an enum object of Symbol before storing it. Stores Type as well.
   */
  public Entry(Symbol input) {
    this.other = input;
    this.type = Type.SYMBOL;
  }

  /**
   * Getter for Symbol Objects. Throws Exceptions when incorrect type Getters are called.
   *
   * @return the Symbol value of the Entry.
   * @throws BadTypeException when incorrect type's getter is called.
   */
  public Symbol getOther() {
    if (this.getType() != Type.SYMBOL) {
      throw new BadTypeException(); // Added statement to throw exception when calling wrong type.
    }
    return this.other;
  }

  /**
   * Getter for Type of an Entry.
   *
   * @return the Type of the Entry. Helps with clutter.
   */
  public Type getType() {
    return this.type;
  }

  /**
   * Equals method to check whether two Entries are the same.
   *
   * @param second method to be checked.
   * @return boolean value of whether they are equal.
   */
  public boolean equals(Entry second) {
    if (this.type != second.getType()) {
      return false;
    }
    if (this.type == Type.NUMBER) {
      return (this.number == second.number);
    } else if (this.type == Type.STRING) {
      return (this.getStr().equals(second.getStr()));
    } else if (this.type == Type.SYMBOL) {
      return (this.type.toString().equals(second.type.toString()));
    } else {
      return (this.toString().equals(second.toString()));
    }
  }


  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }
}
