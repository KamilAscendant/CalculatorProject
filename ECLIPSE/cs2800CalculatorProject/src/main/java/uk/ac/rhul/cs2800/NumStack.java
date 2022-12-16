package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class NumStack{
  private Stack numStack = new Stack();
  
  /**
   * Called to add float onto the Stack.
   *
   * @param float numEntered is added to the top of the Stack.
   */
  public void push(float numEntered) {
    this.numStack.push(new Entry(numEntered));
  }
  
  /**
   * Removes and returns float at the top of Stack. Also throws EmptyStackException if Stack is empty.
   *
   * @return Float that has been removed. Value is stored in a temporary variable.
   * @throws EmptyStackException if size of ArrayList is 0.
   */
  public float pop() throws EmptyStackException {
    return this.numStack.pop().getNumber();
  }
  
  /**
   * Called to show number of items on the Stack.
   *
   * @return Returns size of the underlying Stack.
   */
  public int size() {
    return this.numStack.size();
  }

  /**
   * Called to show (without removing) the item on top of the Stack.
   * 
   * @return The float on top of the Stack.
   */
  public float top() {
    return this.numStack.top().getNumber();
  }
}
