package prob374.guess.number.higher.or.lower;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {
    public int guessNumber(int n) {

        return guess(0, n);

    }

    int guess(int num){
        return 0;
    }


    private int guess(int start, int end){

        if(start > end){
            return guess(start) == 0? start : - 1;
        }

        int mid = start + (end - start) / 2;

        int result = guess(mid);
        if(result == 0){
            return mid;
        } else if(result < 0){
            return guess(start, mid - 1);
        } else {
            return guess(mid + 1, end);
        }
    }
}
