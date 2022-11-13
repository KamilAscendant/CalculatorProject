package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// The early tests were influenced by Professor Cohen's lecture on 11/20/2022.

class TestStack {
  private Stack rs;

  @BeforeEach
  public void setup() {
    rs = new Stack();
  }

  // Test1
  // Makes an (empty) Stack.
  @Test
  void test() {
    Stack rs = new Stack();
  }

  // Test2
  // Checks to see if empty Stack has a size of 0.
  // Added a size counter
  @Test
  void testSize() {
    assertEquals(rs.size(), 0, "Test a newly created stack to see that it has size zero.");
  }

  // Test3
  // Checks Stack size after pushing once.
  @Test
  void testPush() {
    rs.push(new Entry(2));
    assertEquals(rs.size(), 1, "Test a stack that has been pushed to to see that it has size one.");
  }

  // Test4
  // Pushes thrice and checks to see if size incremented.
  // Made size increment on push.
  @Test
  void testPushThrice() {
    rs.push(new Entry(7));
    rs.push(new Entry(11));
    rs.push(new Entry(4));
    assertEquals(rs.size(), 3, "Test to see if size succcessfully incremented.");
  }

  // Test5
  // Checks top value after pushing once.
  // Faked top.
  @Test
  void testTop() {
    rs.push(new Entry(17));
    assertEquals(rs.top().getNumber(), 17f, "Test to see if value stored in stack after pushing.");
  }

  // Test6
  // Checks to see pop value after pushing three.
  // Faked pop.
  @Test
  void testPushPop() {
    rs.push(new Entry(1));
    rs.push(new Entry(99));
    rs.push(new Entry(10));
    assertEquals(rs.pop().getNumber(), 10f, "Tests to see if pop returns last thing pushed");
  }

  // Test7
  // Checks top after pushing 3 times.
  // Changed Top to return most recently pushed value.
  @Test
  void testPushTop() {
    rs.push(new Entry(2));
    rs.push(new Entry(5));
    rs.push(new Entry(7));
    assertEquals(rs.top().getNumber(), 7f, "Tests to see if top value stored.");
  }

  // Test8
  // Calls Top on Empty Stack.
  // Added if statement to Top to throw Exception when called on Empty Stack.
  @Test
  void testEmptyTop() {
    assertThrows(EmptyStackException.class, () -> rs.top(), "Nothing in Stack");
  }

  // Test9
  // Calls Pop on Empty Stack.
  // Added if statement to Pop to throw Exception when called on Empty Stack.
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> rs.pop(), "Nothing in Stack");
  }

  // Test10
  // Pushes 100 to test size of Stack.
  // Replaced Array with ArrayList to allow large Stacks, changed size to remove magic number.
  @Test
  void testHugePush() {
    for (int largeTester = 0; largeTester < 100; largeTester++) {
      rs.push(new Entry(largeTester));
    }
  }
  
  // Test11
  // Array takes Entries as input instead of only Integers.
  // Rewrote ArrayList to use Entries.
  // Rewrote Stack methods to refer to Entries instead of Int.
  // Added a new constructor in Entry that converts Ints to floats automatically.
  @Test
  void testEntryPush() {
    rs.push(new Entry("Among Us"));
  }
}
