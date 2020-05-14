package testing;

import org.junit.Assert;
import org.junit.Test;

public class CombinationTest {
	@Test
	public void test1() {
		long com1 = Combination.ncr(2, -1);
		Assert.assertEquals(-1, com1);
	}
	
	@Test
	public void test2() {
		long com2 = Combination.ncr(-2, 1);
		Assert.assertEquals(-1, com2);
	}
	
	@Test 
	public void test3() {
		long com3 = Combination.ncr(2, 3);
		Assert.assertEquals(-1, com3);
	}
	
	@Test
	public void test4() {
		long com4 = Combination.ncr(6, 4);
		Assert.assertEquals(15, com4);
	}
	
	@Test
	public void test5() {
		long com5 = Combination.ncr(6, 0);
		Assert.assertEquals(1, com5);
	}
}
