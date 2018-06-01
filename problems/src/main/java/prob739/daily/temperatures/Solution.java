package prob739.daily.temperatures;

import java.util.Stack;

/**
 * Created by yanya04 on 6/1/2018.
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] temp = temperatures;
        int n = temp.length;
        int[] res = new int[n];
        int[] stack = new int[n];
        int top = -1;
        for(int i = 0; i < n; i ++){
            while(top > -1 && temp[i] > temp[stack[top]]){
                int index = stack[top--];
                res[index] = i - index;
            }
            stack[++top] = i;
        }
        return res;
    }
}