package prob267.palindrome.permutation.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanya04 on 1/23/2018.
 */
public class Solution {
    /*
        1. count the character and if there're more than one odd, it's not palindrome
        2. take half of the characters to make permutation

    */
    public List<String> generatePalindromes(String s) {

        // stats the chars
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for(int i = 0; i < n; i ++){
            char c = chars[i];
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        Character mid = null;
        // get the mid character if exist
        // get the permutation of the chars in map.

        List<Character> input = new ArrayList<Character>();
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() % 2 != 0){
                if(mid == null) mid = entry.getKey();
                else return new ArrayList<>(); // if there're more than one odd character, then not a palindome

                for(int i = 0; i < (entry.getValue() - 1) / 2; i ++)
                    input.add(entry.getKey());

            } else {
                for(int i = 0; i < entry.getValue() / 2; i ++)
                    input.add(entry.getKey());
            }
        }

        List<String> result = new ArrayList<>();


        helper(result, input, new boolean[input.size()], new StringBuilder(), mid);

        return result;
    }

    private void helper(List<String> result, List<Character> input, boolean[] used, StringBuilder sb, Character mid){
        if(sb.length() == used.length){
            StringBuilder tail = new StringBuilder(sb.toString());
            tail.reverse();
            if(mid == null){
                result.add(sb.toString() + tail.toString());
            } else {
                result.add(sb.toString() + mid + tail.toString());
            }
            return;
        }

        // the input is comming in group such as aaabbbccceeeddd
        // skip the duplicates

        for(int i = 0; i < input.size(); i ++){
            if(used[i]) continue;
            if(i > 0 && input.get(i) == input.get(i - 1) && !used[i - 1]) continue;
            used[i] = true;
            sb.append(input.get(i));
            helper(result, input, used, sb, mid);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}