package prob352.data.stream.as.disjoint.intervals;

import utils.interval.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yanya04 on 1/19/2018.
 */
public class SummaryRanges {


    private TreeMap<Integer, Integer> map;


    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<Integer, Integer>();
    }

    public void addNum(int val) {

        if(map.containsKey(val))
            return;

        Map.Entry<Integer, Integer> lower = map.lowerEntry(val);
        boolean mergedHigher = false;
        boolean mergedLower = false;

        if(lower != null){
            if(lower.getValue() >= val)
                return;
            if(lower.getValue() + 1 == val){
                map.put(lower.getKey(), lower.getValue() + 1);
                mergedHigher = true;
            }
        }

        Map.Entry<Integer, Integer> higher = map.higherEntry(val);


        if(higher != null && val + 1 == higher.getKey()){
            map.remove(higher.getKey());
            mergedLower = true;
            if(mergedHigher){
                map.put(lower.getKey(), higher.getValue());
            } else {
                map.put(higher.getKey() - 1, higher.getValue());
            }
        }

        if(!mergedHigher && !mergedLower){
            map.put(val, val);
        }

    }

    public List<Interval> getIntervals() {

        List<Interval> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            result.add(new Interval(entry.getKey(), entry.getValue()));
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
