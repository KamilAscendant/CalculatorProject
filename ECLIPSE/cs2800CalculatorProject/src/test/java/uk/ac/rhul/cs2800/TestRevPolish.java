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
  //Checks what happens when asked to evaluate a String with only an float
  @Test
  void testFloat() {
    try {
      assertEquals(0.0f, rp.evaluate("0"), "Checking to see if it can read float value of a string");
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
  }
}
