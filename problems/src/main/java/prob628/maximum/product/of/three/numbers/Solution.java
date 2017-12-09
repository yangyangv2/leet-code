package prob628.maximum.product.of.three.numbers;

public
class Solution {

    private final int MAX = Integer.MAX_VALUE;
    private final int MIN = Integer.MIN_VALUE;


    public int maximumProduct(int[] nums) {

        int max1 = MIN, max2 = MIN, max3 = MIN, min1 = MAX, min2 = MIN;

        for(int n : nums){

            if(n > max1){
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if(n > max2){
                max3 = max2;
                max2 = n;
            } else if(n > max3){
                max3 = n;
            }

            if(n < min1){
                min2 = min1;
                min1 = n;
            } else if(n < min2){
                min2 = n;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}