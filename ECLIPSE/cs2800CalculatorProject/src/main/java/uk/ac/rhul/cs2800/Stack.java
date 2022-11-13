package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Creates a Stack to be used to store Calculator inputs. This code was influenced by Professor Dave
 * Cohen's TDDDemo and associated videos.
 *
 * @author zkac152
 */
public class Stack {

  ArrayList<Entry> values = new ArrayList<Entry>();

  /**
   * Called to show size of the ArrayList.
   *
   * @return Returns size of the ArrayList
   */
  public int size() {
    return values.size(); // Was a fake, now returns actual size. Used to use magic number.
  }

  /**
   * Called to add value onto the Stack.
   *
   * @param currentValue is added to the top of the Stack.
   */
  public void push(Entry currentValue) {
    values.add(currentValue);
  }

  /**
   * Called to output the value at the top of the Stack so it can be operated on.
   *
   * @return Value at the top of Stack. Since ArrayList starts at 0, calls value stored at size - 1.
   */
  public Entry top() {
    if (values.size() == 0) {
      throw new EmptyStackException(); // Added statement to throw exception when Stack empty.
    }
    return values.get(values.size() - 1);
  }

  /**
   * Called to remove value at top of Stack. Also returns that value.
   *
   * @return Value that has been removed. Value is stored in a temporary variable.
   * @throws EmptyStackException if size of ArrayList is 0.
   */
  public Entry pop() {
    if (values.size() == 0) {
      throw new EmptyStackException(); // Added statement to throw exception when Stack empty.
    }
    Entry temp = values.get(values.size() - 1);
    values.remove(values.size() - 1);
    return temp;
  }


}
