package contests.contest36;

/**
 * Created by sherxon on 6/10/17.
 */
public class ValidTriangleNumber {

  public static void main(String[] args) {
    System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
  }

  static public int triangleNumber(int[] a) {
    if (a.length < 3) {
      return 0;
    }
    int[] b = new int[1000];
    int count = 0;
    for (int i = 0; i < a.length; i++) {
      b[a[i]]++;
    }
    for (int i = 0; i < a.length; i++) {
      if (b[a[i]] == 0) {
        continue;
      }
      for (int j = i + 1; j < a.length; j++) {
        if (b[a[j]] == 0) {
          continue;
        }
        for (int k = j + 1; k < a.length; k++) {
          if (b[a[k]] == 0) {
            continue;
          }
          if (b[a[i]] + b[a[j]] > b[a[k]] && Math.abs(b[a[i]] - b[a[j]]) < b[a[k]]) {
            count += b[a[i]] * b[a[j]] * b[a[k]];
          } else if (b[a[i]] + b[a[k]] > b[a[j]] && Math.abs(b[a[i]] - b[a[k]]) < b[a[j]]) {
            count += b[a[i]] * b[a[j]] * b[a[k]];
          } else if (b[a[j]] + b[a[k]] > b[a[i]] && Math.abs(b[a[j]] - b[a[k]]) < b[a[i]]) {
            count += b[a[i]] * b[a[j]] * b[a[k]];
          }
        }

      }
    }

    return count;

  }

}
