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
  
  @Test
  void test() {
    //assertThrows(rp.evaluate("179.4 2 10 *+");
    assertThrows(InvalidExpressionException.class, () -> rp.evaluate("179.4 2 10 *+"));
  }
}
