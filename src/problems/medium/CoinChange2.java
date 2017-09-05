package problems.medium;

import java.util.Arrays;

/**
 * @author Sherali Obidov.
 */
public class CoinChange2 {

    int counter=0;
    public int change(int amount, int[] coins) {
        if(amount <0 || coins==null)return 0;
        if(amount==0 && coins.length==0)return 1;
        go(amount, coins, 0);
        return counter;
    }
    void go(int amount, int[] coins, int j){
        if(j>coins.length || amount<0)return;
        if(amount==0){
            counter++;
            return;
        }

        for(int i=j; i<coins.length; i++){
            go(amount-coins[i], coins, i);
        }

    }
}
