package contests.contest30;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubarraySumEqualsK_JunitTest {

	@Test
	void test0() {
		SubarraySumEqualsK SSEK = new SubarraySumEqualsK();
		int [] arr = {1};
		int result = SSEK.subarraySum(arr, 1);
		assertEquals(1, result);
	}
	
	@Test
	void test1() {
		SubarraySumEqualsK SSEK = new SubarraySumEqualsK();
		int [] arr = {};
		int result = SSEK.subarraySum(arr, 8);
		assertEquals(0, result);
	}
	
	@Test
	void test2() {
		SubarraySumEqualsK SSEK = new SubarraySumEqualsK();
		int [] arr = {1,2,1};
		int result = SSEK.subarraySum(arr, 1);
		assertEquals(2, result);
	}
	
	@Test
	void test3() {
		SubarraySumEqualsK SSEK = new SubarraySumEqualsK();
		int [] arr = {1,2,3,4,5};
		int result = SSEK.subarraySum(arr, 0);
		assertEquals(0, result);
	}

	@Test
	void test4() {
		SubarraySumEqualsK SSEK = new SubarraySumEqualsK();
		int [] arr = {1,2,1};
		int result = SSEK.subarraySum(arr, 3);
		assertEquals(2, result);
	}
	
	@Test
	void test5() {
		SubarraySumEqualsK SSEK = new SubarraySumEqualsK();
		int [] arr = {1,-1,2,-2,-3,3};
		int result = SSEK.subarraySum(arr, 0);
		assertEquals(6, result);
	}

	@Test
	void test6() {
		SubarraySumEqualsK SSEK = new SubarraySumEqualsK();
		int [] arr = {-15,6,-3,-8,0,1,4,1,-2,4,3,-5,4};
		int result = SSEK.subarraySum(arr, 0);
		assertEquals(5, result);
	}

	@Test
	void test7() {
		SubarraySumEqualsK SSEK = new SubarraySumEqualsK();
		int [] arr = {-3,4,12,6,2,-5,-3,0,5,-8,5,6,9};
		int result = SSEK.subarraySum(arr, 8);
		assertEquals(4, result);
	}

}
