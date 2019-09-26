import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddStringsTest {
    @Test
    void testAddStrings() {
        String a = "";
        String b = "";
        String c = "00033";
        String d = "010100";
        
        assertEquals("", problems.easy.AddStrings.addStrings(a, b));
        assertEquals("00033", problems.easy.AddStrings.addStrings(a, c));
        assertEquals("010100", problems.easy.AddStrings.addStrings(b, d));
        assertEquals("010133", problems.easy.AddStrings.addStrings(c, d));

    }
}