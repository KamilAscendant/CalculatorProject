package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class StrStack{
  private Stack strStack = new Stack();
  
  /**
   * Called to add a String or other value onto the Stack.
   *
   * @param String strEntered is added to the top of the Stack.
   */
  public void push(String strEntered) {
    this.strStack.push(new Entry(strEntered));
  }
  
  /**
   * Called to remove string at top of Stack. Also returns that string.
   *
   * @return String that has been removed. Value is stored in a temporary variable.
   * @throws EmptyStackException if size of ArrayList is 0.
   */
  public String pop() throws EmptyStackException {
    return this.strStack.pop().getStr();
  }
  
  /**
   * Called to show number of items on the Stack.
   *
   * @return Returns size of the underlying Stack.
   */
  public int size() {
    return this.strStack.size();
  }
}
