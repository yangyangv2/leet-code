package utils.random;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by yanya04 on 8/18/2017.
 */
public class Solution {
    public static void main(String[] args) {

        int time = 300;
        System.out.print("|");
        for(int i = 0; i < time - 2; i ++){
            System.out.print("-");
        }
        System.out.print("|");

        int totalPoll = 1350;

        int[] pollSlots = new int[time];
        Arrays.fill(pollSlots, -1);

        int rate = 1;

        Random rand = new Random();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < totalPoll; i ++){
            int randIndex = rand.nextInt(time * rate / 10);

            if(pollSlots[randIndex] == -1){
                pollSlots[randIndex] = 0;
            }
            pollSlots[randIndex]++;
            max = Math.max(max, pollSlots[randIndex]);
        }

        for(int k = String.valueOf(max).length() - 1; k >= 0; k -- ){
            int base = (int)Math.pow(10, k);
            System.out.println();
            for(int i = 0; i < time; i ++){
                int value = pollSlots[i];
                if(value == -1){
                    System.out.print(" ");
                } else {
                    int digit = value / base;
                    if(digit == 0){
                        System.out.print(digit);
                    } else {
                        System.out.print(digit);
                    }
                    pollSlots[i] = value % base;
                }
            }

        }
        System.out.println();
    }
}
