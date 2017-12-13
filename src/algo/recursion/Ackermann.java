import java.math.BigInteger;

// This method may give Stack Overflow Exception
public class Ackermann {
	
	private static BigInteger ackermann(BigInteger m, BigInteger n) {
		return m.equals(BigInteger.ZERO) ? n.add(BigInteger.ONE) : ackermann(m.subtract(BigInteger.ONE), n.equals(BigInteger.ZERO) ? BigInteger.ONE : ackermann(m, n.subtract(BigInteger.ONE)));
	}

	public static void main(String[] args) {
		System.out.println(ackermann(new BigInteger("2"), new BigInteger("2")));
	}
}
