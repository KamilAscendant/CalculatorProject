package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolish {
  private RevPolishCalc rp;
  
  @BeforeEach
  public void setup() {
    rp = new RevPolishCalc();
  }
  
  //Test1
  //Checks to see if RevPolishCalc throws an exception upon being asked to evaluate an empty String
  @Test
  void testEmpty() {
    assertThrows(InvalidExpressionException.class, () -> rp.evaluate(""));
  }
  
  //Test2
  //Checks what happens when asked to evaluate a String with only a float
  @Test
  void testFloat() {
    try {
      assertEquals(10.0f, rp.evaluate("10.0"), "Checking to see if it can read float value of a string");
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }
  
  //Test3
  //Checks what happens when asked to evaluate a String with only an Integer
  @Test
  void testInteger() {
    try {
      assertEquals(5.0f, rp.evaluate("5"), "Checking to see if it can convert Integer in a string to a float");
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    } 
  }
  
  //Test4
  //Tries to evaluate a simple expression (only two numbers and one operator)
  @Test
  void testSimpleAdd() {
    try {
      assertEquals(6.5f, rp.evaluate("3.5 3 +"), "Trying a simple calculation");
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }
  
  //Test5
  //Tries to add more than two numbers together
  @Test
  void testLargeAdd() {
    try {
      assertEquals(9.0f, rp.evaluate("3 3 + 3 +"), "Trying to add multiple numbers");
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }
  
  //Test6
  //Tries to subtract two numbers
  @Test
  void testSubtract() {
    try {
      assertEquals(6.5f, rp.evaluate("9.5 3  -"), "Trying subtraction");
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }
  
  //Test7
  //Tries to multiply two numbers
  @Test
  void testMultiply() {
    try {
      assertEquals(12.0f, rp.evaluate("4 3 *"), "Trying multiplication");
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }
  
  //Test8
  //Tries to divide two numbers
  @Test
  void testDivide() {
    try {
      assertEquals(4.0f, rp.evaluate("12 3 /"), "Trying division");
    } catch (InvalidExpressionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
