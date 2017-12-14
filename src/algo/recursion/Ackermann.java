package algo.recursion;
/**
 * the Ackermann function is one of the simplest and earliest-discovered examples of a total computable function that is not primitive recursive.
 * All primitive recursive functions are total and computable, but the Ackermann function illustrates that not all total computable functions are primitive recursive.
 * Ackermann Function is given by :
 * A (m , n) = n + 1,					if m = 0
 			 = A (m - 1, 1) 			if m > 0 and n = 0
 			 = A (m - 1, A(m, n - 1))	if m > 0 and n > 0
 * As this function may return large values, BigInteger class is used.
 */

import java.math.BigInteger;

// This method may give Stack Overflow Exception
public class Ackermann {

    private static BigInteger ackermann(BigInteger m, BigInteger n) {
        return m.equals(BigInteger.ZERO) ? n.add(BigInteger.ONE) :
                ackermann(m.subtract(BigInteger.ONE), n.equals(BigInteger.ZERO) ? BigInteger.ONE : ackermann(m, n.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {
        System.out.println(ackermann(new BigInteger("2"), new BigInteger("2")));
    }
}
