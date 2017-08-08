package prob599.minimum.index.sum.of.two.lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanya04 on 8/8/2017.
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> indexMap1 = new HashMap<>();

        for(int i = 0; i < list1.length; i ++){
            indexMap1.put(list1[i], i);
        }

        Map<String, Integer> indexMap2 = new HashMap<>();

        int minIndex = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i ++){
            Integer index = indexMap1.get(list2[i]);
            if(index != null){
                int sum = index + i;
                minIndex = Math.min(sum, minIndex);
                indexMap2.put(list2[i], sum);
            }
        }


        List<String> arrayList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: indexMap2.entrySet()){
            if(entry.getValue() == minIndex){
                arrayList.add(entry.getKey());
            }
        }

        return arrayList.toArray(new String[0]);
    }
}
