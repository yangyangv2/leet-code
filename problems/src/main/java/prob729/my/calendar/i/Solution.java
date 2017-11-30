package prob729.my.calendar.i;

import java.util.Map;
import java.util.TreeMap;

public class Solution {


    private TreeMap<Integer, Integer> map;


    public Solution() {
        this.map = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {

        Map.Entry<Integer, Integer> floorEntry = map.floorEntry(start);
        Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(start);

        // max/less than
        if(floorEntry != null){
            if(end > floorEntry.getValue()) return false;
        }

        // least/greater than
        if(ceilingEntry != null){
            if(end > ceilingEntry.getValue()) return false;
        }

        map.put(start, end);
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.book(10, 20));
        System.out.println(solution.book(15, 25));
    }

}