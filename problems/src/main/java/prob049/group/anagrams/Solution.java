package prob049.group.anagrams;

import java.util.*;

/**
 * Created by yanya04 on 8/10/2017.
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();
        for(String str: strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = dict.get(key);
            if(list == null){
                dict.put(key, new ArrayList<String>());
                list = dict.get(key);
            }
            list.add(str);
        }

        return new ArrayList<>(dict.values());
    }
}
