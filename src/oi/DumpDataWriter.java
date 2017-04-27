package oi;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by sherxon on 4/23/17.
 */
public class DumpDataWriter {
    static long size1MB = 1024 * 1024;
    static long size10MB = 1024 * 1024 * 10;
    static long size100MB = 1024 * 1024 * 100;
    static long size1000MB = 1024 * 1024 * 1000;
    static byte oneByte = 1;
    static String input1MB="input1MB.txt";
    static String input10MB="input10MB.txt";
    static String input100MB="input100MB.txt";
    static String input1000MB="input1000MB.txt";

    public static void main(String[] args) throws IOException {
        //writeDumpData(input1MB, size1MB);
        //writeDumpData(input10MB, size10MB);
        //writeDumpData(input100MB, size100MB);
        //writeDumpData(input1000MB, size1000MB);
    }

    static void writeDumpData(String filename, long size) throws IOException {
        BufferedOutputStream bufferedOutputStream= new BufferedOutputStream(new FileOutputStream(filename));
        for (int i = 0; i < size; i++) {
            bufferedOutputStream.write(oneByte);
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

}
