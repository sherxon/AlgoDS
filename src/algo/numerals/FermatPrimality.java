package algo.numerals;

/**
 * Created by sherxon on 1/13/17.
 */

/**
 * This is method to check if  number is prime or not.
 * Fermat’s “little theorem” states that if p is prime and 1 ≤ n ≤ p, np–1 Mod
 * p = 1. In other words, if you raise n to the p–1 power and then take the result
 * modulo p, the result is 1.
 * For example, suppose p = 11 and n = 2. Then np–1 Mod p = 210 Mod 11 = 1,024
 * Mod 11. The value 1,024 = 11 × 93 + 1, so 1,024 Mod 11 = 1 as desired.
 * Note that it is possible for np–1 Mod p = 1 even if p is not prime. In that case
 * the value n is called a Fermat liar because it incorrectly implies that p is prime.
 * If np–1 Mod p ≠ 1, n is called a Fermat witness because it proves that p is
 * not prime
 * We can use many test to remove Fermat liar. For example, if p passes the test 10 times, there is a 1/210 ≈ 0.00098 probability
 * that p is not prime
 */
public class FermatPrimality {
    public static void main(String[] args) {
        System.out.println(isPrime(97, 10));
    }

    static boolean isPrime(int p, int testNum) {
        for (int i = 0; i < testNum; i++) {
            int n = (int) (Math.random() * p) + 1; // min should be 1
            if (mod(n, p - 1, p) != 1) {
                System.out.println(n);
                return false;
            }
        }
        //There is a 1/testNum chance that it is not prime.
        return true;
    }

    // (n ^ (p-1)) % p
    private static int mod(int n, int i, int p) {
        int res = 1;
        for (int j = 0; j < i; j++) {
            res *= n;
            res %= p;
        }
        return res % p;
    }
}
