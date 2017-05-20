package problems.easy;

/**
 * Created by sherxon on 2016-12-23.
 */
public class SumofTwoIntegers {
    public static void main(String[] args) {
        int a=1;
        int b=3;
        while (b != 0){
            int carry = (a & b) ; //CARRY is AND of two bits

            a = a ^b; //SUM of two bits is A XOR B

            b = carry << 1; //shifts carry to 1 bit to calculate sum
        }

        System.out.println(a);
    }
}
