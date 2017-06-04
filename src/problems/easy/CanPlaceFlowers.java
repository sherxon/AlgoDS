package problems.easy;

/**
 * Created by sherxon on 6/3/17.
 */
public class CanPlaceFlowers {

  public boolean canPlaceFlowers(int[] a, int n) {
    if (n == 0) {
      return true;
    }
    //if(a.length/2 < n)return false;
    if (a.length == 0) {
      return false;
    } else if (a.length == 1) {
      if (a[0] == 0 && n == 1) {
        return true;
      }
      return false;
    } else if (a.length == 2) {
      if (a[0] == 1 || a[1] == 1 || n > 1) {
        return false;
      }
      return true;
    } else {
      for (int i = 0; i < a.length; i++) {
        if (i == 0) {
          if (a[i] == 0 && a[i + 1] == 0) {
            n--;
            a[i] = 1;
          }
        } else if (i == a.length - 1) {
          if (a[i - 1] == 0 && a[i] == 0) {
            n--;
            a[i] = 1;
          }
        } else if (a[i - 1] == 0 && a[i] == 0 && a[i + 1] == 0) {
          n--;
          a[i] = 1;
        }
      }
    }
    return n <= 0;
  }

}
