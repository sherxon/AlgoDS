package oi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by sherxon on 4/27/17.
 */
/**
* This approach uses direct buffering therefore eliminates read calls.
* We should be careful because of EOF exception.
* */
public class UsingDirectBuffering {
    public static void main(String[] args) throws IOException {

        //-------------- Test reading 1 MB file. --------------------
        StopWatch.start();
        BufferedInputStream inputStream= new BufferedInputStream(new FileInputStream(new File(DumpDataWriter.input1MB)));
        byte[] buffer= new byte[2048]; // 2KB
        while (inputStream.read(buffer)!=-1){} // 75 ms
        long duration = StopWatch.stop();
        System.out.println(duration);

        //-------------- Test reading 10 MB file. --------------------

        StopWatch.start();

        BufferedInputStream inputStream2 = new BufferedInputStream(new FileInputStream(new File(DumpDataWriter.input10MB)));
        byte[] buffer2= new byte[1024*1024 * 2]; // 2MB
        while (inputStream2.read(buffer2)!=-1){} // 90 ms

        long duration2 = StopWatch.stop();
        System.out.println(duration2);

        //-------------- Test reading 100 MB file. --------------------

        StopWatch.start();

        BufferedInputStream inputStream3 = new BufferedInputStream(new FileInputStream(new File(DumpDataWriter.input100MB)));
        byte[] buffer3= new byte[2048 * 1024]; // 2MB
        while (inputStream3.read(buffer3)!=-1){} // 280 ms

        long duration3 = StopWatch.stop();
        System.out.println(duration3);

        //-------------- Test reading 1000 MB file. --------------------

        StopWatch.start();

        BufferedInputStream inputStream4 = new BufferedInputStream(new FileInputStream(new File(DumpDataWriter.input1000MB)));
        byte[] buffer4= new byte[2048*1024*5]; // 10MB
        while (inputStream4.read(buffer4)!=-1){} // 3300 ms

        long duration4 = StopWatch.stop();
        System.out.println(duration4);

    }
}
