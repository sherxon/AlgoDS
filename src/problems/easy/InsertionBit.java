package problems.easy;
import junit.framework.TestCase;+

/**
 * Created by sherxon on 5/3/17.
 */
public class InsertionBit {
    public static void main(String[] args) {
        int m=256;
        int n=5;
        System.out.println(Integer.toBinaryString(insert(m, n, 2, 4)));
    }
   static int insert(int m, int n,int j, int i){
        for (int k = j; k <=i; k++) {
            boolean isBitM = (m & (1 << k)) != 0;
            boolean isBitN = (n & (1 << (k-j))) != 0;

            if(isBitN && !isBitM){ // if n has 1 and m has 0
                m =  m | (m << k); // set 1
            }else if(!isBitN && isBitM){ // n has 0 and m has 1
                int mask= ~( m << k); // set 0
                 m= m & mask;
            }
        }
        return m;
    }
}
public class Testinsert(){
	public void test1{
			assertEquals(4, insert(3,4,0,5));
		}
	public void test2{
			assertEquals(0, insert(0,0,0,1));
		}
	public void test2{
			assertEquals(1, insert(1,1,0,5));
		}
    }
