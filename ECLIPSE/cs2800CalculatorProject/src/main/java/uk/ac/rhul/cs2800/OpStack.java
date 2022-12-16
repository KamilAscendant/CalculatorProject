package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class OpStack{
  private Stack opStack = new Stack();
  
  /**
   * Called to add an operator onto the Stack.
   *
   * @param Symbol symEntered is added to the top of the Stack.
   */
  public void push(Symbol symEntered) {
    this.opStack.push(new Entry(symEntered));
  }
  
  /**
   * Called to remove Symbol at top of Stack. Also returns that value.
   *
   * @return Symbol that has been removed. Stored in a temporary variable.
   * @throws EmptyStackException if size of ArrayList is 0.
   */
  public Symbol pop() throws EmptyStackException {
    return this.opStack.pop().getOther();
  }
  
  /**
   * Called to show number of items on the Stack.
   *
   * @return Returns size of the underlying Stack.
   */
  public int size() {
    return this.opStack.size();
  }
}

