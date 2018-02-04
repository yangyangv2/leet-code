package prob293.flip.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 2/3/2018.
 */
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s.length() - 1; i ++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if(c1 == c2 && c1 == '+'){
                StringBuilder sb = new StringBuilder(s);
                char newChar = '-';
                sb.setCharAt(i, newChar);
                sb.setCharAt(i + 1, newChar);
                res.add(sb.toString());
            }
        }
        return res;
    }

}