package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class StrStack{
  private Stack strStack = new Stack();
  
  public void push(String strEntered) {
    this.strStack.push(new Entry(strEntered));
  }
  
  public String pop() throws EmptyStackException {
    return this.strStack.pop().getStr();
  }
  
  public int size() {
    return this.strStack.size();
  }
}
