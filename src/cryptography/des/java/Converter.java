/**
 * Convert to binary code russian letters.
 */

package cryptography.des.java;

import java.io.UnsupportedEncodingException;

public class Converter {

    public static String convertToBinaryCode(String text) {
        StringBuilder binaryCode = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            byte[] bytes = getBytes(text.substring(i, i+ 1));
            int[] m = new int[bytes.length];

            for (int j = 0; j < bytes.length; j++) {
                m[j] = bytes[j];
            }

            for (int k = 0; k < m.length; k++) {
                StringBuilder str = new StringBuilder(Integer.toBinaryString(m[k]));

                for (int n = str.length(); n < 32; n++) {
                    str.insert(0, "0");
                }

                binaryCode.append(str.toString().substring(24));
            }
        }

        return binaryCode.toString();
    }

    private static byte[] getBytes (String text) {
        try {
            return text.getBytes("Cp1251");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

}
