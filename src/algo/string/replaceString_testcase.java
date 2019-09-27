import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class replaceStringTest {
        
        /*----  some All DU Path tests  ---*/
        @Test
        // với s
        void DUTest1() {
            String s = "abcbca";
            String s1 = "ab";
            String s2 = "c";
            String s3 = algo.string.ReplaceString.replaceAll(s,s1,s2);
            assertEquals("ccbca", s3);

        }

        @Test
        // với s1
        void DUTest2() {
            String s = "abcbca";
            String s1 = "abcbc";
            String s2 = "aaaaa";
            String s3 = algo.string.ReplaceString.replaceAll(s,s1,s2);
            assertEquals("aaaaaa", s3);

        }

        @Test
        // với s2
        void DUTest3() {
            String s = "abcbca";
            String s1 = "ca";
            String s2 = "";
            String s3 = algo.string.ReplaceString.replaceAll(s,s1,s2);
            assertEquals("abcb", s3);

        }
}