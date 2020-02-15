
import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplaceStringTest {
    /*-------------------Simple Unit Test------------------------*/
    @Test
    void unitTest1(){
        String s = "aaa";
        assertEquals("111", algo.string.ReplaceString.replaceAll(s,"a","1"));
    }
    @Test
    void unitTest2(){
        String s = "aaa";
        assertEquals("   ", algo.string.ReplaceString.replaceAll(s,"a"," "));
    }
    @Test
    void unitTest3(){
        String s = "aaa";
        assertEquals("aaa", algo.string.ReplaceString.replaceAll(s,"a","a"));
    }
    /*-------------------Some MCDC Test------------------------*/
    @Test
    void MCDCTest1(){
        String s = "abcabc";
        assertEquals("a1ca1c", algo.string.ReplaceString.replaceAll(s,"b","1"));
        // TH: If(A)=T; If(B)=F; If(C) = T
    }
    @Test
    void MCDCTest2(){
        String s = "abcabc";
        assertEquals("", algo.string.ReplaceString.replaceAll(s,"abc",""));
        // TH: If(A)=f; If(B)=F; If(C) = T
    }
    @Test
    void MCDCTest3(){
        String s = "abcabc";
        assertEquals("123123", algo.string.ReplaceString.replaceAll(s,"abc","123"));
        // TH: If(A)=T; If(B)=T; If(C) = T
    }
    @Test
        /*-------------------Some All DU path Test------------------------*/
    void allDUpathTest1(){
        String s = "abcabc";
        assertEquals("1bc1bc", algo.string.ReplaceString.replaceAll(s,"a","1"));
        // DU path cho s
    }
    @Test
    void allDUpathTest2(){
        String s = "abcabc";
        assertEquals("123123", algo.string.ReplaceString.replaceAll(s,"abc","123"));
        // DU path cho 1
    }
    @Test
    void allDUpathTest3(){
        String s = "abcabc";
        assertEquals("", algo.string.ReplaceString.replaceAll(s,"abc",""));
        // DU path cho 2
    }


}
