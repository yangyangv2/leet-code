package prob475.heaters;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{1,3,3,5};

        System.out.println(Arrays.binarySearch(array, 2));
        System.out.println(Arrays.binarySearch(array, 4));
        System.out.println(Arrays.binarySearch(array, 6));
        System.out.println(Arrays.binarySearch(array, 0));
        System.out.println(Arrays.binarySearch(array, -99));
        System.out.println(Arrays.binarySearch(array, -4));

    }

    public int findRadius(int[] houses, int[] heaters) {

        if(heaters == null || heaters.length == 0 || houses == null || houses.length == 0){
            return 0;
        }

        Arrays.sort(heaters);

        int minRadius = 0;

        for(Integer house : houses){

            int index = Arrays.binarySearch(heaters, house);
            int radius = 0;
            if(index >= 0) {
                // means house and heaters collapse, so the distance is zero, ignore
            } else if(index == -1){
                // houses fall into the left-most heater
                radius = Math.abs(house - heaters[0]);
            } else if(Math.abs(index) == heaters.length + 1){
                // houses fall into the right-most heater
                radius = Math.abs(house - heaters[heaters.length - 1]);
            } else {
                // houses fail in between two heaters
                // - length < index <= -2
                index = 0 - index - 1;
                radius = Math.min(Math.abs(house - heaters[index]),
                        Math.abs(house - heaters[index - 1]));
            }
            minRadius = Math.max(radius, minRadius);
        }
        return minRadius;
    }
}
