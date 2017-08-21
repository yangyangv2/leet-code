package prob042.trapping.rain.water;

/**
 * Created by yanya04 on 8/20/2017.
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
}
