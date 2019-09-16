
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplaceStringTest {
    @Test
    void testReplaceAll() {
        String s1 = "abcabc123123@@@";
        String s2 = "a";
        String s3 = "1";
        String s4 = "@";
        String s8 = " ";
        assertEquals("1bc1bc123123@@@", algo.string.ReplaceString.replaceAll(s1,s2,s3));
        assertEquals("abcabca23a23@@@", algo.string.ReplaceString.replaceAll(s1,s3,s2));
        assertEquals("abcabc123123111", algo.string.ReplaceString.replaceAll(s1,s4,s3));
        assertEquals("abcabc@23@23@@@", algo.string.ReplaceString.replaceAll(s1,s3,s4));
        assertEquals("abcabc123123aaa", algo.string.ReplaceString.replaceAll(s1,s4,s2));
        assertEquals("@bc@bc123123@@@", algo.string.ReplaceString.replaceAll(s1,s2,s4));
        assertEquals(" bc bc123123@@@", algo.string.ReplaceString.replaceAll(s1,s2,s8));
        assertEquals("abcabc123123@@@", algo.string.ReplaceString.replaceAll(s1," "," "));

    }
}
