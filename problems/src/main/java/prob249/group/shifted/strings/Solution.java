package prob249.group.shifted.strings;

import java.util.*;

/**
 * Created by yanya04 on 1/21/2018.
 */
public class Solution {

    /*
        [
          ["abc","bcd","xyz"],

          "abc" -> "bcd"


          ["az","ba"],
          ["acef"],
          ["a","z"]
        ]
    */
    public List<List<String>> groupStrings(String[] strings) {

        Map<String, List<String>> group = new HashMap<>();
        for(String str: strings){
            int offset = str.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i ++){
                int diff = str.charAt(i) - offset - 'a';
                if(diff < 0) diff += 26;
                sb.append((char)(diff));
            }
            String key = sb.toString();
            List<String> list = group.get(key);
            if(list == null){
                list = new ArrayList<>();
                group.put(key, list);
            }
            list.add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> value: group.values()){
            Collections.sort(value);
            res.add(value);
        }
        return res;
    }
}