package prob683.k.empty.slots;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int n = flowers.length, loc = 0;
        tm.put(0, n - 1);

        for(int i = 0; i < n; i ++){
            loc = flowers[i] - 1;
            Map.Entry<Integer, Integer> entry = tm.floorEntry(loc);
            tm.remove(loc);
            int start1 = entry.getKey(), end1 = loc - 1;
            int start2 = loc + 1, end2 = entry.getValue();

            if(start1 != 0 && end1 != n - 1 && end1 - start1 + 1 == k)
                return i + 1;
            else{
                if(start1 <= end1) tm.put(start1, end1);
            }

            if(start2 != 0 && end2 != n - 1 && end2 - start2 + 1 == k){
                return i + 1;
            } else {
                if(start2 <= end2) tm.put(start2, end2);
            }
        }
        return -1;

    }
}
