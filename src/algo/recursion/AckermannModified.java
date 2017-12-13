import java.math.BigInteger;
import java.util.Stack;

// This method overcomes the problem of Stack Overflow Exception
public class AckermannModified {

	private static BigInteger ackermann(BigInteger m, BigInteger n) {
		
		Stack<BigInteger> ack = new Stack<BigInteger>();
		ack.push(m);
		
		while (!ack.isEmpty()) {
			m = ack.pop();
			if (m.equals(BigInteger.ZERO))
				n = n.add(BigInteger.ONE);
			else if (n.equals(BigInteger.ZERO)) {
				BigInteger temp = m.subtract(BigInteger.ONE);
				ack.push(temp);
				n = BigInteger.ONE;
			}
			else {
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
