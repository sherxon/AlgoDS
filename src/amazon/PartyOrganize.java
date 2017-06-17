package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sherxon on 6/17/17.
 */
public class PartyOrganize {

}

class Main {

  static List<Pair> solve(List<Pair> lunchMenuPairs, List<Pair> teamCuisinePreferencePairs) {
    List<Pair> result = new ArrayList<>();
    Map<String, Set<String>> map = new HashMap<>();

    for (Pair lunchMenuPair : lunchMenuPairs) {
      if (!map.containsKey(lunchMenuPair.getPairValue())) {
        map.put(lunchMenuPair.getPairValue(), new HashSet<>());
      }
      map.get(lunchMenuPair.getPairValue()).add(lunchMenuPair.getPairKey());
    }
    for (Pair preference : teamCuisinePreferencePairs) {
      String type = preference.getPairValue();
      if (type.equals("*")) {
        for (Pair lunchMenuPair : lunchMenuPairs) {
          result.add(new Pair(preference.getPairKey(), lunchMenuPair.getPairKey()));
        }
      } else if (map.containsKey(type)) {
        for (String food : map.get(type)) {
          result.add(new Pair(preference.getPairKey(), food));
        }
      }
    }
    return result;
  }

  private static void readAndSetParameters(List<Pair> lunchMenuPairs,
      List<Pair> teamCuisinePreferencePairs) {
    int lunchMenuPairCount = -1;
    int teamCuisinePreferencePairCount = -1;

    String tempOption = null, tempOptionValue = null;
    ;
    try (Scanner in = new Scanner(System.in)) {
      lunchMenuPairCount = in.nextInt();
      while (lunchMenuPairCount > 0) {
        lunchMenuPairCount--;

        tempOption = in.next();
        tempOptionValue = in.next();
        Pair pair = new Pair(tempOption, tempOptionValue);
        lunchMenuPairs.add(pair);
      }

      teamCuisinePreferencePairCount = in.nextInt();
      while (teamCuisinePreferencePairCount > 0) {
        teamCuisinePreferencePairCount--;

        tempOption = in.next();
        tempOptionValue = in.next();
        Pair pair = new Pair(tempOption, tempOptionValue);
        teamCuisinePreferencePairs.add(pair);
      }
    }
  }

  private static void print(List<?> resultPairs) {
    for (Object pair : resultPairs) {
      System.out.println(pair);
    }
  }

  public static void main(String[] args) {
    List<Pair> lunchMenuPairs = new LinkedList<>();
    List<Pair> teamCuisinePreferencePairs = new LinkedList<>();
    readAndSetParameters(lunchMenuPairs, teamCuisinePreferencePairs);
    List<Pair> result = solve(lunchMenuPairs, teamCuisinePreferencePairs);
    Collections.sort(result);
    print(result);
  }

  static class Pair implements Comparable<Pair> {

    String pairKey;
    String pairValue;

    Pair(String pairKey, String pairValue) {
      this.pairKey = pairKey;
      this.pairValue = pairValue;
    }

    public String getPairKey() {
      return pairKey;
    }

    public String getPairValue() {
      return pairValue;
    }

    public String toString() {
      return getPairKey() + " " + getPairValue();
    }

    @Override
    public int compareTo(Pair pair) {
      int compare = pairKey.compareTo(pair.getPairKey());
      if (compare == 0) {
        compare = pairValue.compareTo(pair.getPairValue());
      }
      return compare;
    }
  }
}
