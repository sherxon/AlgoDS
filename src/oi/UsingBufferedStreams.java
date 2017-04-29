package oi;

import java.io.*;

/**
 * Created by sherxon on 4/23/17.
 */
public class UsingBufferedStreams {
    public static void main(String[] args) throws IOException {

            //-------------- Test reading 1 MB file. --------------------
        StopWatch.start();

        BufferedInputStream inputStream= new BufferedInputStream(new FileInputStream(new File(DumpDataWriter.input1MB)));
        while (inputStream.read()!=-1){}

        long duration = StopWatch.stop();
        System.out.println(duration);

        //-------------- Test reading 10 MB file. --------------------
        StopWatch.start();

        BufferedInputStream inputStream2= new BufferedInputStream(new FileInputStream(new File(DumpDataWriter.input10MB)));
        while (inputStream2.read()!=-1){}

        long duration2 = StopWatch.stop();
        System.out.println(duration2);

        //-------------- Test reading 100 MB file. --------------------
        StopWatch.start();

        BufferedInputStream inputStream3= new BufferedInputStream(new FileInputStream(new File(DumpDataWriter.input100MB)));
        while (inputStream3.read()!=-1){}

        long duration3 = StopWatch.stop();
        System.out.println(duration3);

        //-------------- Test reading 1000 MB file. --------------------
        StopWatch.start();

        BufferedInputStream inputStream4= new BufferedInputStream(new FileInputStream(new File(DumpDataWriter.input1000MB)));
        while (inputStream4.read()!=-1){}
        long duration4 = StopWatch.stop();
        System.out.println(duration4);
    }
}
