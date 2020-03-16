package problems.medium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GasStation_Test {
	int [] a = {1,2,3,4,5};
	int [] b = {2,3,4,5,6};
	int [] c = {2,3,2,1,2};
	int [] d = {2,1,5,1,2};
	int [] e = {2,1,3,5,4};
	
	@Test
	void test0() {
		GasStation gs = new GasStation();
		int result = gs.canCompleteCircuit(a,b);
		assertEquals(-1, result);
	}
	
	@Test
	void test1() {
		GasStation gs = new GasStation();
		int result = gs.canCompleteCircuit(a,c);
		assertEquals(2, result);
	}
	
	@Test
	void test2() {
		GasStation gs = new GasStation();
		int result = gs.canCompleteCircuit(a,d);
		assertEquals(3, result);
	}
	
	@Test
	void test3() {
		GasStation gs = new GasStation();
		int result = gs.canCompleteCircuit(a,e);
		assertEquals(1, result);
	}

}
