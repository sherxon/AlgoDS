package google;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by sherxon on 6/16/17.
 */
public class KClosestPoints {

  Set<Point> FindClosestPoints(Set<Point> allPoints, Point reference, int k) {

    Comparator<Point> comparator = (a, b) -> {
      double disBetweenAandRef = distance(a, reference);
      double disBetweenBandRef = distance(b, reference);
      if (disBetweenAandRef > disBetweenBandRef) {
        return -1; // a is bigger
      } else if (disBetweenAandRef < disBetweenBandRef) {
        return 1; // b is bigger
      }
      return 0;
    };

    PriorityQueue<Point> q = new PriorityQueue<>(comparator);

    for (Point currentPoint : allPoints) {
      if (q.size() < k) {
        q.add(currentPoint);
      } else if (distance(currentPoint, reference) < distance(q.peek(), reference)) {
        q.poll();
        q.add(currentPoint);
      }
    }
    return new HashSet<>(q);
  }

  private double distance(Point currentPoint, Point reference) {
    return Math.sqrt(
        (currentPoint.x - reference.x) * (currentPoint.x - reference.x)
            +
            (currentPoint.y - reference.y) * (currentPoint.y - reference.y)
    );
  }


  class Point {

    public int x;
    public int y;
  }

}
