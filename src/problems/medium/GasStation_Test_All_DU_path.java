package problems.medium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GasStation_Test_All_DU_path {
	int [] a = {4,1,2,2,5};
	int [] b = {2,5,3,4,3};
	int [] c = {6,2,4,3,5};
	int [] d = {5,2,1,2,3};
	int [] e = {3,1,4,2,1};
	int [] f = {4,1,3,1,4};
	
	@Test
	// Kiểm thử All-DU path cho biến totgas
	void test0() {
		GasStation gs = new GasStation();
		int result = gs.canCompleteCircuit(a,b);
		assertEquals(-1, result);
	}
	
	@Test
	// Kiểm thử All-DU path cho biến totcost
	void test1() {
		GasStation gs = new GasStation();
		int result = gs.canCompleteCircuit(a,c);
		assertEquals(-1, result);
	}
	
	@Test
	// Kiểm thử All-DU path cho biến current
	void test2() {
		GasStation gs = new GasStation();
		int result = gs.canCompleteCircuit(a,d);
		assertEquals(2, result);
	}
	
	@Test
	// Kiểm thử All-DU path cho biến current
	void test3() {
		GasStation gs = new GasStation();
		int result = gs.canCompleteCircuit(a,e);
		assertEquals(3, result);
	}

	@Test
	// Kiểm thử All-DU path cho biến k
	void test4() {
		GasStation gs = new GasStation();
		int result = gs.canCompleteCircuit(a,f);
		assertEquals(3, result);
	}

}
