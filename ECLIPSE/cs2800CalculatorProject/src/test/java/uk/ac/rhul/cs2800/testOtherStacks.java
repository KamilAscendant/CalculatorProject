package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testOtherStacks {
  private NumStack ns;
  
  @BeforeEach
  public void setup() {
    ns = new NumStack();
  }
  
  //Test1
  //Check to see if floats are properly pushed and popped from the Stack, i.e. if the facade is working.
  @Test
  void testFloatPushPop() {
    ns = new NumStack();
    ns.push(22);
    ns.push(33);
    assertEquals(ns.pop(), 10f, "Tests to see if pop returns last thing pushed");
  }

}
