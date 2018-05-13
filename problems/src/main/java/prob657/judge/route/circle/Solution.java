package prob657.judge.route.circle;

/**
 * Created by yanya04 on 5/13/2018.
 */
public class Solution {
    public boolean judgeCircle(String moves) {

        int x = 0, y = 0;
        for(char c : moves.toCharArray()){
            switch(c){
                case 'U': y ++; break;
                case 'D': y --; break;
                case 'L': x --; break;
                case 'R': x ++; break;
            }
        }
        return x == 0 && y == 0;

    }
}
