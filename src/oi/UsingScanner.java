package oi;

/**
 * Created by sherxon on 4/23/17.
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
* This is usage of simple Scanner class with timer.
* */
public class UsingScanner {
    static long size1MB = 1024 * 1024;
    static long size10MB = 1024 * 1024 * 10;
    static long size100MB = 1024 * 1024 * 100;
    static byte oneByte = 1;

    public static void main(String[] args) throws IOException {

        //-------------- Test reading 1 MB file. --------------------
        StopWatch.start();

        Scanner scanner = new Scanner(new File(DumpDataWriter.input1MB));
        while (scanner.hasNext()) scanner.next();

        long duration = StopWatch.stop();
        System.out.println(duration);

        //-------------- Test reading 10 MB file. --------------------
        StopWatch.start();

        Scanner scanner2 = new Scanner(new File(DumpDataWriter.input10MB));
        while (scanner2.hasNext()) scanner2.next();

        long duration2 = StopWatch.stop();
        System.out.println(duration2);


        //-------------- Test reading 100 MB file. --------------------
        StopWatch.start();

        Scanner scanner3 = new Scanner(new File(DumpDataWriter.input100MB));
        while (scanner3.hasNext()) scanner3.next();

        long duration3 = StopWatch.stop();
        System.out.println(duration3);

        //-------------- Test reading 1000 MB file. --------------------
        StopWatch.start();

        Scanner scanner4 = new Scanner(new File(DumpDataWriter.input1000MB));
        while (scanner4.hasNext()) scanner4.next();

        long duration4 = StopWatch.stop();
        System.out.println(duration4);
    }
}
