package prob658.find.k.closest.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yanya04 on 8/26/2017.
 */
public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        arr = new ArrayList<>(arr);
        int lo = 0, hi = arr.size();
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(arr.get(mid) == x){
                lo = mid;
                break;
            } else if(arr.get(mid) > x){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        int count = 0;
        int l = lo - 1, r = lo;
        List<Integer> result = new ArrayList<>(k);
        while(count < k){


            int distL = Integer.MAX_VALUE;
            if(l > -1){
                distL = Math.abs(arr.get(l) - x);
            }

            int distR = Integer.MAX_VALUE;
            if(r < arr.size()){
                distR = Math.abs(arr.get(r) - x);
            }

            if(distL <= distR){
                result.add(arr.get(l));
                l --;
            } else {
                result.add(arr.get(r));
                r ++;
            }
            count++;
        }
        Collections.sort(result);

        return result;
    }
}
