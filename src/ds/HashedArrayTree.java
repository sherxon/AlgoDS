package ds;

/**
 * Created by sherxon on 5/23/17.
 */

/**
 * This is the implementation of Hashed Array Tree (HAT) data structure that is the same as Dynamic
 * Array (ArrayList in Java) in terms of time complexity, however, it wastes SQRT(N) extra space
 * when increasing capacity.
 */
public class HashedArrayTree {

  private Object[][] data;

  private int size;
  private int iPointer = -1;
  private int jPointer = 17; // negative value means leaf array has not been created;

  public HashedArrayTree() {
    this.data = new Object[4][]; // should be power of 2, all leaf arrays are not initialized
  }

  public void add(Integer elem) {

    ensureCapacity();

    Object[] leaf = getLeaf();

    leaf[jPointer++] = elem;

    size++;

  }

  /**
   * this method checks capacity and extend it if needed.
   * all data copied to new storage and only one empty leaf will be available to insert
   * Extra wasted space is equal to 2*SQRT(n);
   */

  private void ensureCapacity() {
    if (iPointer + 1 < data.length || jPointer < data[iPointer].length) {
      return;
    }
    int prevLength = data.length;

    Object[][] newData = new Object[prevLength * 2][];

    iPointer = prevLength / 2;

    for (int i = 0; i < iPointer; i++) {
      newData[i] = new Object[prevLength * 2];

      for (int j = 0; j < newData[i].length; j++) {
        newData[i][j] = data[i % prevLength + j / prevLength][j % prevLength];
      }
    }
    jPointer = 0;
    newData[iPointer] = new Object[prevLength * 2];
    this.data = newData;

  }

  public void printStats() {
    int busy = 0;
    int cap = 0;
    for (int i = 0; i < data.length; i++) {
      if (data[i] != null) {
        for (int j = 0; j < data[i].length; j++) {
          if (data[i][j] != null) {
            busy++;
          }
          cap++;
        }
      }
    }
    System.out.println("Size: " + size + "; Capacity: " + cap + "; Busy: " + busy);
  }

  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    int iiPointer = index / data.length;
    int jjPointer = index % data.length;

    return data[iiPointer][jjPointer];

  }

  public int size() {
    return size;
  }

  private Object[] getLeaf() {

    if (jPointer >= data.length) {
      data[++iPointer] = new Object[data.length];
      jPointer = 0;
    }
    return data[iPointer];
  }
}
