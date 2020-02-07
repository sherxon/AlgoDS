package problems.easy;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import testjava.*;
public class ThirdLargestTest {
	@Test
	public void testthirdMax() {
		ThirdLargest thr = new ThirdLargest();
		int a[]= {};
		assertTrue(thr.thirdMax(a)==0);
	}
	@Test	
	public void testthirdMax1() {
		ThirdLargest thr = new ThirdLargest();
		int a[]= {11};
		assertTrue(thr.thirdMax(a)==11);
	}
	@Test	
	public void testthirdMax2() {
		ThirdLargest thr = new ThirdLargest();
		int a[]= {11,2};
		assertTrue(thr.thirdMax(a)==11);
	}
	@Test	
	public void testthirdMax3() {
		ThirdLargest thr = new ThirdLargest();
		int a[]= {2,11};
		assertTrue(thr.thirdMax(a)==11);
	}
	@Test	
	public void testthirdMax4() {
		ThirdLargest thr = new ThirdLargest();
		int a[]= {2,11,1};
		assertTrue(thr.thirdMax(a)==1);
	}
	@Test	
	public void testthirdMax5() {
		ThirdLargest thr = new ThirdLargest();
		int a[]= {3,5,11,5,6};
		assertTrue(thr.thirdMax(a)==5);
	}
	@Test	
	public void testthirdMax6() {
		ThirdLargest thr = new ThirdLargest();
		int a[]= {5,5,5,5,5,5,5};
		assertTrue(thr.thirdMax(a)==5);
	}
}
