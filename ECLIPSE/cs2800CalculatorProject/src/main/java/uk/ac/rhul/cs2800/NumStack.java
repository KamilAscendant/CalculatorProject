package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class NumStack{
  private Stack numStack = new Stack();
  
  public void push(float numEntered) {
    this.numStack.push(new Entry(numEntered));
  }
  
  public float pop() throws EmptyStackException {
    return this.numStack.pop().getNumber();
  }
  
  public int size() {
    return this.numStack.size();
  }

  public float top() {
    return this.numStack.top().getNumber();
  }
}
