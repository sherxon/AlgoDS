import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddStringsTest {
    @Test
    void testAddStrings() {
        String a = "11111";
        String b = "221";
        String c = "00033";
        String d = "010100";
        
        assertEquals("11332", problems.easy.AddStrings.addStrings(a, b));
        assertEquals("11144", problems.easy.AddStrings.addStrings(a, c));
        assertEquals("00254", problems.easy.AddStrings.addStrings(b, c));
        assertEquals("021211", problems.easy.AddStrings.addStrings(a, d));

    }
}