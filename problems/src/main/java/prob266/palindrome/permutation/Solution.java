package prob266.palindrome.permutation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanya04 on 1/23/2018.
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 2) return true;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i ++)
        {
            char c = s.charAt(i);
            if(set.contains(c)){
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() || set.size() == 1;
    }
}
