package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testOtherStacks {
  private NumStack ns;
  private StrStack ss;
  
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
    assertEquals(ns.pop(), 33f, "Tests to see if pop returns last thing pushed");
  }

  //Test2
  //Checking to see if StrStack works.
  @Test
  void testStrPushPop() {
    ss = new StrStack();
    ss.push("Among");
    ss.push("Us");
    assertEquals(ss.pop(), "Us", "Tests push and pop");                     
  }
}
