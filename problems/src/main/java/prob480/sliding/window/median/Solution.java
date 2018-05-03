package prob480.sliding.window.median;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yanya04 on 5/2/2018.
 */
public class Solution {
    /*
        2 TreeMaps   (add log(n), remove log(n), first log(n), last log(n);

    */
    private int smallCount = 0;
    private int largeCount = 0;
    private TreeMap<Integer, Integer> small = new TreeMap<>(Collections.reverseOrder()); // large -> small
    private TreeMap<Integer, Integer> large = new TreeMap<>(); // small -> large

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] median = new double[nums.length - k + 1];

        for(int i = 0; i < k; i ++){
            add(nums[i]);
        }
        median[0] = getMedian();

        for(int i = k; i < nums.length; i ++){
            add(nums[i]);
            remove(nums[i - k]);
            median[i - k + 1] = getMedian();
        }

        return median;
    }

    private void add(int num){
        if(small.isEmpty() || num < small.firstEntry().getKey()){
            small.put(num, small.getOrDefault(num, 0) + 1);
            smallCount ++;
        } else {
            large.put(num, large.getOrDefault(num, 0) + 1);
            largeCount++;
        }
        balance();
    }

    private void remove(int num){
        if(large.containsKey(num)){
            if(large.get(num) == 1){
                large.remove(num);
            } else {
                large.put(num, large.get(num) - 1);
            }
            largeCount --;
        } else if(small.containsKey(num)){
            if(small.get(num) == 1){
                small.remove(num);
            } else {
                small.put(num, small.get(num) - 1);
            }
            smallCount --;
        }
        balance();
    }


    private double getMedian(){
        if(smallCount > largeCount){
            return small.firstEntry().getKey().doubleValue();
        } else if(largeCount > smallCount){
            return large.firstEntry().getKey().doubleValue();
        } else {
            return (small.firstEntry().getKey().doubleValue() +
                    large.firstEntry().getKey().doubleValue()) / 2.0;
        }
    }

    private void balance(){
        if(smallCount - largeCount > 1){
            Map.Entry<Integer, Integer> entry = small.firstEntry();
            if(entry.getValue() == 1) small.remove(entry.getKey());
            else small.put(entry.getKey(), entry.getValue() - 1);
            smallCount --;

            large.put(entry.getKey(), large.getOrDefault(entry.getKey(), 0) + 1);
            largeCount ++;
        } else if(largeCount - smallCount > 1){
            Map.Entry<Integer, Integer> entry = large.firstEntry();
            if(entry.getValue() == 1) large.remove(entry.getKey());
            else large.put(entry.getKey(), entry.getValue() - 1);
            largeCount --;

            small.put(entry.getKey(), small.getOrDefault(entry.getKey(), 0) + 1);
            smallCount ++;
        }
    }
}
