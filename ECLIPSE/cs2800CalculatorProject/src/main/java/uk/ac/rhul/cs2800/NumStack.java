package uk.ac.rhul.cs2800;

public class NumStack {
  private Stack stackNum = new Stack();
  private float numEntered;
  
  public void push(Entry numEntered) {
    stackNum.push(numEntered);
  }
  
}
