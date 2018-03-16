package prob042.trapping.rain.water;

/**
 * Created by yanya04 on 8/20/2017
 * Modified by yanya04 on 3/14/2018
 */
public class Solution {
/*
    from left to right

    get non-zero, find on the right, where x > h

*/

    public int trap(int[] height) {
        int i = 0, j = 0;
        int totalVolume = 0;
        while(i < height.length - 1){
            j = i + 1;
            int maxIndex = j;
            int maxHeight = height[j];

            while(j < height.length && height[j] < height[i]){
                if(height[j] > maxHeight){
                    maxHeight = height[j];
                    maxIndex = j;
                }
                j ++;
            }

            int next = 0;
            if(j == height.length){
                // reaches the end
                next = maxIndex;
            } else {
                // reaches the higher
                next = j;
            }

            // calculate size;

            int volume = 0;
            int mark = Math.min(height[i], height[next]);
            for(int k = i + 1; k < next; k ++){
                volume += mark - height[k];
            }
            totalVolume += volume;
            i = next;
        }
        return totalVolume;
    }



        /*
        optimized solution: O(n)

        input:  0,1,0,2,1,0,1,3,2,1,2,1
        left:   0 0 1 1 2 2 2 2 3 3 3 3
        right:  3 3 3 3 3 3 3 2 2 2 1 0
        min     0 0 1 1 2 2 2 2 2 2 1 0
                0 0 1 0 1 2 1 0 0 1 0 0 = 6

    */

    private int solution2(int[] height){

        int n = height.length;
        int[] leftHigh = new int[n];
        int[] rightHigh = new int[n];

        int max = 0;
        for(int i = 1; i < n; i ++){
            max = Math.max(max, height[i - 1]);
            leftHigh[i] = max;
        }
        max = 0;


        for(int i = n - 2; i >= 0; i --){
            max = Math.max(max, height[i + 1]);
            rightHigh[i] = max;
        }


        int sum = 0;

        for(int i = 0; i < n; i ++){
            sum += Math.max(0, Math.min(rightHigh[i], leftHigh[i]) - height[i]);
        }
        return sum;
    }


    /*
        naive solution: O(n^2)
        timeout
    */
    private int solution1(int[] height){
        int sum = 0;
        for(int i = 0; i < height.length; i ++){

            int h = height[i];
            int left = leftHigh(height, i);
            int right = rightHigh(height, i);

            sum += Math.max(0, Math.min(left, right) - h);
        }
        return sum;
    }

    private int leftHigh(int[] height, int index){
        if(index == 0) return 0;
        int max = 0;
        for(int i = 0; i < index; i ++){
            max = Math.max(height[i], max);
        }
        return max;
    }

    private int rightHigh(int[] height, int index){
        if(index == height.length - 1) return 0;
        int max = 0;
        for(int i = index + 1; i < height.length; i ++){
            max = Math.max(height[i], max);
        }
        return max;
    }
}
