package problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by sherxon on 7/1/17.
 */
public class LogSystem {


    TreeMap<Long, Integer> logs = new TreeMap<>();

    public LogSystem() {

    }

    public static void main(String[] args) {
        LogSystem log = new LogSystem();
        System.out.println(log.getDate("2004:09:23:19:31:46", "Year", false));
        System.out.println(log.getDate("2003:12:12:20:30:51", "Year", false));

    }

    public void put(int id, String timestamp) {
        logs.put(getDate(timestamp, "Second", false), id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {

        long fromDay = getDate(s, gra, true);
        long toDay = getDate(e, gra, false);
        return new ArrayList<>(logs.subMap(fromDay, true, toDay, true).values());

    }


    private long getDate(String s, String gra, boolean b) {
        int year = 0;
        int month = b ? 1 : 11;
        int day = b ? 1 : 31;
        int hour = b ? 0 : 23;
        int min = b ? 0 : 59;
        int sec = b ? 0 : 59;
        String to[] = s.split(":");
        switch (gra) {
            case "Second":
                sec = Integer.parseInt(to[5]);
            case "Minute":
                min = Integer.parseInt(to[4]);
            case "Hour":
                hour = Integer.parseInt(to[3]);
            case "Day":
                day = Integer.parseInt(to[2]);
            case "Month":
                month = Integer.parseInt(to[1]) - 1;
            case "Year":
                year = Integer.parseInt(to[0]);
        }

        return year * 100000 + month * 10000 + day * 1000 + hour * 100 + min * 10 + sec;
    }
}

