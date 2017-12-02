package prob731.my.calendar.ii;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {

    private TreeMap<Integer, Integer> overlaps;
    private List<int[]> books;


    public MyCalendarTwo() {
        overlaps = new TreeMap<Integer, Integer>();
        books = new ArrayList<int[]>();
    }


    private int[] overlap(int s1, int e1, int s2, int e2){
        if(e1 < s2 || s1 > e2) return null;

        int[] res = null;

        if(e1 <= e2 && s1 >= s2) res = new int[]{s1, e1};
        else if(e2 <= e1 && s2 >= s1) res = new int[]{s2, e2};
        else if(s1 <= s2 && e1 <= e2) res = new int[]{s2, e1};
        else if(s1 >= s2 && e1 >= e2) res = new int[]{s1, e2};

        if(res != null && res[0] == res[1]){
            return null;
        } else {
            return res;
        }
    }

    public boolean book(int start, int end) {


        Map.Entry<Integer, Integer> floorEntry = overlaps.floorEntry(start);
        Map.Entry<Integer, Integer> ceilingEntry = overlaps.ceilingEntry(start);

        if(floorEntry != null){
            // max/less than
            // entry.key < start
            if(floorEntry.getValue() > start) return false;

        }

        if(ceilingEntry != null){
            // least/greater than
            // entry.key > start
            if(end > ceilingEntry.getKey()) return false;
        }

        // scan through the books and find out overlaps

        for(int[] book: books){
            int[] overlap = overlap(start, end, book[0], book[1]);
            if(overlap != null){

                if(overlaps.containsKey(overlap[0])){
                    if(overlaps.get(overlap[0]) > overlap[1])
                        continue;   // keep a longer overlap
                }
                overlaps.put(overlap[0], overlap[1]);
            }
        }
        books.add(new int[]{start, end});
        return true;
    }
}