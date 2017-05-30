package algo;

/**
 * Created by sherxon on 5/20/17.
 */

class Solution {

  static int findBusiestPeriod(int[][] data) {
    // your code goes here
    int max = 0;
    int maxTime = 0;

    int counter = 0;

    for (int i = 0; i < data.length; i++) {

      if (data[i][2] == 0) {
        counter -= data[i][1];
      } else {
        counter += data[i][1];
      }

      if (i < data.length - 1 && data[i][0] == data[i + 1][0]) {
        continue;
      }

      if (max < counter) {

        max = counter;
        maxTime = data[i][0];

      }
      if (i < data.length - 1 && data[i][0] != data[i + 1][0]) {
        counter = 0;
      }
    }

    return maxTime;

  }

  public static void main(String[] args) {
    System.out.println(findBusiestPeriod(new int[][]{
        {1487799425, 14, 1},
        {1487799425, 4, 0},
        {1487799425, 2, 0},
        {1487800378, 10, 1},
        {1487801478, 18, 0},
        {1487801478, 18, 1},
        {1487901013, 1, 0},
        {1487901211, 7, 1},
        {1487901211, 7, 0}
    }));
  }
}

