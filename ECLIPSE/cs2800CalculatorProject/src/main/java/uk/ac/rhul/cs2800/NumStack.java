package uk.ac.rhul.cs2800;

public class NumStack{
  private Stack stackNum;
  
  public void push(float numEntered) {
    Entry numPush = new Entry(numEntered);
    stackNum.push(numPush);
  }
  
  public void pop() {
    stackNum.pop();
  }
  
}
