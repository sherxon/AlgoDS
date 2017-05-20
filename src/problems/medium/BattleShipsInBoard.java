package problems.medium;

/**
 * Created by sherxon on 1/11/17.
 */
public class BattleShipsInBoard {
    public int countBattleships(char[][] a) {
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 'X' && j == a[i].length - 1 && i == a.length - 1) counter++;
                if (a[i][j] == 'X' && j == a[i].length - 1 && i < a.length - 1 && a[i + 1][j] == '.') counter++;
                if (a[i][j] == 'X' && j < a[i].length - 1 && i < a.length - 1 && a[i + 1][j] == '.' && a[i][j + 1] == '.')
                    counter++;
                if (a[i][j] == 'X' && j < a[i].length - 1 && i == a.length - 1 && a[i][j + 1] == '.') counter++;
            }
        }
        return counter;
    }
}
