package prob249.group.shifted.strings;

import java.util.*;

/**
 * Created by yanya04 on 1/21/2018.
 * Modified by yanya04 on 6/1/2018.
 */
public class Solution {

    /*
        [
          ["abc","bcd","xyz"],

          "abc" -> "bcd"

          1 2 3

          2 3 4
        ]
    */
    public List<List<String>> groupStrings(String[] strings) {

        Map<String, List<String>> group = new HashMap<>();
        for(String str: strings){
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(0));
            for(int i = 1; i < str.length(); i ++){
                int diff = str.charAt(i) - str.charAt(i - 1);
                if(diff < 0) diff += 26;
                sb.append(String.valueOf(diff));
            }
            String key = sb.toString();
            group.putIfAbsent(key, new ArrayList<>());
            group.get(key).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(group.values());


        return res;
    }
}