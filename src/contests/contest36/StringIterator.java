package contests.contest36;

/**
 * Created by sherxon on 6/10/17.
 */
public class StringIterator {

  StringBuilder sb = new StringBuilder();
  private int n = 0;
  private char current = ' ';
  private int index = 0;

  public StringIterator(String s) {
    sb.append(s);
  }

  public static void main(String[] args) {
    StringIterator s = new StringIterator("x6");
    for (int i = 0; i < 15; i++) {
      System.out.println(s.hasNext() + " " + s.next());
    }
  }

  public char next() {
    if (n > 0) {
      n--;
      return current;
    }
    if (!hasNext()) {
      return ' ';
    }
    current = sb.charAt(index);
    int end = index + 1;
    while (end < sb.length()) {
      if (!Character.isDigit(sb.charAt(end))) {
        break;
      }
      end++;
    }
    n = Integer.parseInt(sb.substring(index + 1, end)) - 1;
    index = end;
    return current;
  }

  public boolean hasNext() {
    return n > 0 || index < sb.length();
  }

}
