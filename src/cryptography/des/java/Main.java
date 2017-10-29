/**
 * In input file write message and password on new line.
 */

package cryptography.des.java;

public class Main {

    public static void main(String[] args) {
        IO IO = new IO("input.txt", "output.txt");
        String message = IO.readMessageFromFile();
        String key = IO.readKeyFromFile();

        DES DES = new DES();
        DES.setMessage(message);
        DES.setKey(key);

        String cypherText = DES.encrypt();

        IO.writeStringInFile(cypherText);
    }

}
