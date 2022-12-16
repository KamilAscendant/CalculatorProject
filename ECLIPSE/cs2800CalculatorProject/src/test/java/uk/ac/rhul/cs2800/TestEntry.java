package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestEntry {
  // Test1
  // Creates a float entry and then returns the same value.
  // Created Float constructor and getFloat method.
  @Test
  void testFloatEntry() {
    Entry test = new Entry(0.5f);
    assertEquals(test.getNumber(), 0.5f, "Test entering and returning a float");
  }

  // Test2
  // Creates a String entry and then returns the same value.
  // Created String constructor and getString method.
  @Test
  void testStringEntry() {
    Entry test = new Entry("Among Us");
    assertEquals(test.getStr(), "Among Us", "Testing entry and return with String.");
  }

  // Test3
  // Creates a Symbol entry and then returns the same value.
  // Created ENUM Symbol.
  // Created Symbol constructor and getSymbol method.
  @Test
  void testSymbolEntry() {
    Entry test = new Entry(Symbol.PLUS);
    assertEquals(test.getOther(), Symbol.PLUS, "Testing entry & return with PLUS Symbol."); // fake
  }

  // Test4
  // Creates a Type entry and then returns the same value.
  // Created ENUM Type.
  // Created getType method.
  @Test
  void testType() {
    Entry test = new Entry("Help");
    assertEquals(test.getType(), Type.STRING, "Testing entry and return with Type.");
  }

  // Test5a
  // Creates a float entry that inputs a float and calls the String getter.
  // Added throws BadType exceptions to getStr method.
  // Added casting type to all Entry constructors.
  // Added getType method to return type of Entry object.
  // Added conditional statements to all getter methods to compare type, throwing BadTypeException.
  @Test
  void testFloatException() {
    Entry test = new Entry(0.5f);
    assertThrows(BadTypeException.class, () -> test.getStr(), "Testing BadTypeException");
  }

  // Test5b
  // Creates a string entry that throws a BadType exception on String.
  // Making sure it works with other types.
  @Test
  void testStringException() {
    Entry test = new Entry("Crewmate");
    assertThrows(BadTypeException.class, () -> test.getNumber(), "Testing BadTypeException");
  }

  // Test6
  // Print String value for Symbol.
  // Create toString method for Symbol.
  // Assigned each ENUM object a corresponding String.
  @Test
  void testSymbolToString() {
    Entry test = new Entry(Symbol.MINUS);
    assertEquals(test.getOther().toString(), "-", "Testing Symbol toString method");
  }

  // Test7
  // Print String value for Type.
  // Create toString method for Type.
  // Assigned each ENUM object in Type a corresponding String.
  @Test
  void testTypeToString() {
    Entry test = new Entry(Symbol.MINUS);
    assertEquals(test.getType().toString(), "Symbol", "Testing Type toString method.");
  }

  // Test8a
  // Checking if two Entries are equal.
  // Create Entry.equals method.
  // Use appropriate getter for type and getType on each object to compare.
  // Use two entries that are equal to test success.
  // No use of hash code yet.
  @Test
  void testEqualsMethod() {
    Entry test1 = new Entry("Skeld");
    Entry test2 = new Entry("Skeld");
    assertEquals(test1.equals(test2), true, "Testing two equal values");
  }

  // Test 8b
  // Checking if two Entries are with different types are NOT equal.
  // Create Entries that are different type and execute Entry.equals on them.
  // Create statements that return false if types differ..
  @Test
  void testUnequalType() {
    Entry test1 = new Entry(0.5f);
    Entry test2 = new Entry(Symbol.DIVIDE);
    assertEquals(test1.equals(test2), false, "Testing two values of different type.");
  }

  // Test 8c
  // Checking if two Entries with the same type and different values are NOT equal.
  // Create Entries w/ the same type but different values and execute Entry.equals.
  // Create statements that check if two entries values are the same if their types match.
  @Test
  void testUnequalValue() {
    Entry test1 = new Entry("Apollo");
    Entry test2 = new Entry("Aphrodite");
    assertEquals(test1.equals(test2), false, "Testing two entries with the same type diff values");
  }

  // Test9
  // Adding a hashCode method to compute the hashcode of an Entry.
  // Create two identical Entries and compare the hashCodes.
  // Created hashCode method by using Eclipse.
  @Test
  void testHashCode() {
    Entry test1 = new Entry("Apollo");
    Entry test2 = new Entry("Apollo");
    assertEquals(test1.hashCode() == test2.hashCode(), true, "Testing two identical entries.");
  }
  
  // Test10
  // Checking getter for Symbol
  // Create symbol entry and get type.
  @Test
  void testSymbolGetter() {
    Entry test1 = new Entry(Symbol.DIVIDE);
    assertEquals(test1.getOther(), Symbol.DIVIDE, "Testing Symbol getter");
  }
}
