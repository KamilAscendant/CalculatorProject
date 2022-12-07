package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class OpStack{
  private Stack opStack = new Stack();
  
  public void push(Symbol symEntered) {
    this.opStack.push(new Entry(symEntered));
  }
  
  public Symbol pop() throws EmptyStackException {
    return this.opStack.pop().getOther();
  }
  
  public int size() {
    return this.opStack.size();
  }
}

