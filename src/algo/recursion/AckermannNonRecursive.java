package algo.recursion;

/*
 * Ackermann Function is given by :
 * A (m , n) = n + 1,					if m = 0
 			 = A (m - 1, 1) 			if m > 0 and n = 0
 			 = A (m - 1, A(m, n - 1))	if m > 0 and n > 0
 */

import java.math.BigInteger;
import java.util.Stack;

// This method overcomes the problem of Stack Overflow Exception
public class AckermannNonRecursive {

    private static BigInteger ackermann(BigInteger m, BigInteger n) {

        Stack<BigInteger> ack = new Stack<BigInteger>();        // Creating a stack to store the values
        ack.push(m);

        while (!ack.isEmpty()) {                                // Looping while the stack is not empty
            m = ack.pop();                                        // Assigning m the value of top element of the stack
            if (m.equals(BigInteger.ZERO))                        // If m = 0, n = n + 1
                n = n.add(BigInteger.ONE);
            else if (n.equals(BigInteger.ZERO)) {                // If n = 0, push m - 1 in the stack and update the value of n to 1
                BigInteger temp = m.subtract(BigInteger.ONE);
                ack.push(temp);
                n = BigInteger.ONE;
            } else {                                                // If n > 0 and m > 0, push m - 1 and m in the stack respectively and subtract 1 from n
                BigInteger temp = m.subtract(BigInteger.ONE);
                ack.push(temp);
                ack.push(m);
                n = n.subtract(BigInteger.ONE);
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(ackermann(new BigInteger("3"), new BigInteger("4")));
    }
}
