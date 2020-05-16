import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddStringsTest {
        
        /*----  Unit test case ---*/
        @Test
        void unitTestcase1() {
            String c = "00033";
            String d = "010100";
            String u1 =  problems.easy.AddStrings.addStrings(c, d);
            assertEquals("010133", u1);

        }

        @Test
        void unitTestcase2() {
            String c = "00033";
            String e = "12345";
            String u2 =  problems.easy.AddStrings.addStrings(c, e);
            assertEquals("12378", u2);

        }

        @Test
        void unitTestcase3() {
            String e = "12345";
            String d = "010100";
            String u3 =  problems.easy.AddStrings.addStrings(d, e);
            assertEquals("022445", u3);

        }


        /*----  MCDC test  ---*/

        @Test
        // A=T, B=T, C=T
        void MCDCTest1() {
            String a = "112";
            String b = "001";
            String c =  problems.easy.AddStrings.addStrings(a, b);
            assertEquals("113", c);

        }

        @Test
        // A=F, B=T, C=T
        void MCDCTest1() {
            String a = "";
            String b = "001";
            String c =  problems.easy.AddStrings.addStrings(a, b);
            assertEquals("001", c);

        }

        @Test
        // A=T, B=F, C=T
        void MCDCTest1() {
            String a = "112";
            String b = "";
            String c =  problems.easy.AddStrings.addStrings(a, b);
            assertEquals("112", c);

        }
    
}