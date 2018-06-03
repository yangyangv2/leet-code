package prob679.twofour.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 6/2/2018.
 */
public class Solution {

    private double small = 0.01;

    public boolean judgePoint24(int[] nums) {
        List<Double> arr = new ArrayList<>();

        for(int num: nums){
            arr.add((double) num);
        }

        return dfs(arr);
    }


    private boolean dfs(List<Double> arr){

        if(arr.size() == 1){
            return Math.abs(arr.get(0) - 24) < small;
        }


        for(int i = 1; i < arr.size(); i ++){
            for(int j = 0; j < i; j ++){

                double a = arr.get(i), b = arr.get(j);

                List<Double> next = new ArrayList<>();

                next.add(a + b);
                next.add(a - b);
                next.add(b - a);
                next.add(a * b);

                if(Math.abs(b) > small) next.add(a / b);
                if(Math.abs(a) > small) next.add(b / a);

                arr.remove(i);
                arr.remove(j);

                for(Double v: next){
                    arr.add(v);
                    if(dfs(arr)) return true;
                    arr.remove(arr.size() - 1);
                }

                arr.add(j, b);
                arr.add(i, a);
            }
        }
        return false;
    }
}