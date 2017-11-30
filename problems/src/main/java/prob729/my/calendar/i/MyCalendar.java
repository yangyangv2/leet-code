package prob729.my.calendar.i;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    private TreeMap<Integer, Integer> map;


    public MyCalendar() {
        this.map = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {

        Map.Entry<Integer, Integer> floorEntry = map.floorEntry(start);
        Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(start);

        // max/less than
        if(floorEntry != null){
            if(start < floorEntry.getValue()) return false;
        }

        // least/greater than
        if(ceilingEntry != null){
            if(end > ceilingEntry.getKey()) return false;
        }

        map.put(start, end);
        return true;
    }
}
