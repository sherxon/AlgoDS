package problems.hard;

/**
 * Created by sherxon on 6/10/17.
 */
public class TrappingRainWater {

  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    int sum = 0;
    for (int i = 0; i < height.length; i++) {
      int x = i;
      int y = i;
      int maxL = 0;
      int maxR = 0;
      while (x >= 0 || y < height.length) {
        if (x >= 0) {
          maxL = Math.max(height[x], maxL);
          x--;
        }
        if (y < height.length) {
          maxR = Math.max(height[y], maxR);
          y++;
        }
      }
      int min = Math.min(maxL, maxR);
      int diff = height[i] < min ? min - height[i] : 0;
      sum += diff;
    }
    return sum;
  }
}
