
import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplaceStringTest {
    @Test
    void testReplaceAll() {
        String s1 = "abcabc";
        String s2 = "b";
        String s3 = "1";
        String s4 = "abc";
        String s5 = "123";
        String s8 = "";
        assertEquals("a1ca1c", algo.string.ReplaceString.replaceAll(s1,s2,s3)); // Kiem thu luong du lieu
        assertEquals("123123", algo.string.ReplaceString.replaceAll(s1,s4,s5));
        assertEquals("", algo.string.ReplaceString.replaceAll(s1,s4,s8));
        assertEquals("11", algo.string.ReplaceString.replaceAll(s1,s4,s3));
        assertEquals("acac", algo.string.ReplaceString.replaceAll(s1,s2,s8));
        assertEquals("acac", algo.string.ReplaceString.replaceAll(s1,s2,s8));
//        assertEquals(" bc bc123123@@@", algo.string.ReplaceString.replaceAll(s1,s2,s8));
//        assertEquals("abcabc123123@@@", algo.string.ReplaceString.replaceAll(s1," "," "));

    }
}
