package prob294.flip.game.ii;

/**
 * Created by yanya04 on 2/3/2018.
 */
public class Solution {
    public boolean canWin(String s) {
        for(int i = 0; i < s.length() - 1; i ++){
            if(s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+'){
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                if(!canWin(sb.toString())) return true;
            }
        }
        return false;
    }
}