package prob163.missing.ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 1/14/2018.
 */
public class Solution {

    /*
        range: [0~99]

        case: ... 96,98,99
    */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> result = new ArrayList<>();
        long alower = (long) lower, aupper = (long) upper;

        for(int num: nums){

            if(num < alower)
                continue;
            else if(alower == num){
                // do nothing
            }
            else if(alower == num - 1L){
                result.add(String.valueOf(alower));

            } else {
                result.add(String.valueOf(alower) + "->" + Math.min(num - 1L, aupper));
            }
            alower = num + 1L;
            if(alower > aupper)
                break;
        }

        if(alower < aupper)
            result.add(String.valueOf(alower) + "->" + String.valueOf(aupper));
        else if(alower == aupper)
            result.add(String.valueOf(alower));

        return result;
    }
}