package uk.ac.rhul.cs2800;

public class NumStack{
  private Stack numStack;
  
  public void push(float numEntered) {
    Entry numPush = new Entry(numEntered);
    numStack.push(numPush);
  }
  
  public float pop() {
    return numStack.pop().getNumber();
  }
  
}
