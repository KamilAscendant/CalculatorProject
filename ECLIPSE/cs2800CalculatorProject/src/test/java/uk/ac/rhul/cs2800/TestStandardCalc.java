package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStandardCalc {
  private StandardCalc sc;

  @BeforeEach
  void setup() {
    sc = new StandardCalc();
  }

  // Test1
  // Checks evaluation of null string to see if it throws Exception.
  @Test
  void testEmpty() {
    assertThrows(InvalidExpressionException.class, () -> sc.evaluate(""));
  }

  // Test2
  // Checks evaluation of a String with only a float
  @Test
  void testNumber() {
    try {
      assertEquals(5.0f, sc.evaluate("5"),
          "Checking to see if it can convert Integer in a string to a float");
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  // Test3
  // Checks what happens when asked to evaluate a String with only an Integer
  @Test
  void testInteger() {
    try {
      assertEquals(5.0f, sc.evaluate("5"),
          "Checking to see if it can convert Integer in a string to a float");
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  //Test4
  //Tries to evaluate a simple expression (only two numbers and one operator)
  @Test
  void testSimpleAdd() {
    try {
      assertEquals(6.5f, sc.evaluate("3.5 + 3"), "Trying a simple calculation");
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }

  //Test5
  //Tries to evaluate an expression with subtraction(StandardCalc handles these in the opposite order as RevPolish)
  @Test
  void testSubtract() {
    try {
      assertEquals(4f, sc.evaluate("6 - 2"), "Trying subtraction");
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }
  
  //Test6
  //Tries to evaluate a complex expression
  @Test
  void tryComplex() {
    try {
      assertEquals(10f, sc.evaluate("1 * 6 + 4"), "Trying something more complex");
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }
}
