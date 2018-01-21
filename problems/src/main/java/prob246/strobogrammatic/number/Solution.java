package prob246.strobogrammatic.number;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 1/21/2018.
 */
public
class Solution {
    /*
        6 - 9
        9 - 6
        1 - 1
        0 - 0
        8 - 8
    */
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        map.put('0', '0');
        map.put('8', '8');
        int n = num.length();
        for(int i = 0; i <= (n - 1) / 2; i ++){
            char a = num.charAt(i);
            char b = num.charAt(n - 1 - i);

            if(!map.containsKey(a)) return false;
            if(b != map.get(a)) return false;
        }
        return true;
    }
}
