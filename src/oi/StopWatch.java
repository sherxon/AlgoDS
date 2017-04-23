package oi;

import java.time.Clock;

/**
 * Created by sherxon on 4/23/17.
 */
public class StopWatch {
   private static long begin =0l;
   private static long end =0l;

    static void start(){
        begin = Clock.systemDefaultZone().millis();
    }

    static long stop(){
        end = Clock.systemDefaultZone().millis();
        return end-begin;
    }
}
