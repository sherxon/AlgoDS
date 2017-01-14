package algo.numerals;

/**
 * Created by sherxon on 1/13/17.
 */

/**
 * This is finding prime numbers up to given number N. Space complexity is N.
 * The ides is to mark all numbers are divisible by i starting from 2 in every step.
 */
public class SieveofEratosthenes {
    public static void main(String[] args) {
        findPrimes(100);
    }

    // print all prime numbers up to given number n
    static void findPrimes(int n) {
        boolean[] primes = new boolean[n];

        for (int i = 2; i < n; i++)
            if (!primes[i])
                for (int j = i * i; j < primes.length; j += i)
                    primes[j] = true;

        for (int i = 2; i < primes.length; i++)
            if (!primes[i])
                System.out.println(i);

    }
}
