package prob605.can.place.flowers;

/**
 *  Created by yanya04 on 5/16/2018.
 */
public class Solution {
    /*

    */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(flowerbed == null || flowerbed.length == 0)
            return false;

        boolean clear = true;
        int flower = 0;
        int count = 0;
        for(int i = 0; i < flowerbed.length; i ++){
            flower = flowerbed[i];
            if(flower == 1){
                // there's a flower just planted, remove it
                if(!clear) count --;

                clear = false;
            } else {
                if(clear) {
                    // plant
                    count ++;
                    clear = false;
                } else {

                    clear = true;
                }
            }
        }

        return count >= n;
    }
}