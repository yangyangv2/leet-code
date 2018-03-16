package prob049.group.anagrams;

import java.util.*;

/**
 * Created by yanya04 on 8/10/2017.
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // return sort(strs);
        return countSort(strs);
    }


    //  count sort, O(m * n), space O(m * n)
    private List<List<String>> countSort(String[] strs){
        List<List<String>> res = new ArrayList<>();
        if(strs == null) return res;
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            if(str == null) continue;
            int[] counts = new int[26];
            for(char c: str.toCharArray()){
                counts[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < counts.length; i ++){
                int count = counts[i];
                if(count == 0) continue;
                sb.append((char) (i + 'a')).append(count);
            }
            String key = sb.toString();

            List<String> list = map.get(key);
            if(list == null){
                list = new ArrayList<String>();
                map.put(key, list);
                res.add(list);
            }
            list.add(str);
        }
        return res;
    }


    //  time: O(m * n * log(n)), space O(m * n)
    private List<List<String>> sort(String[] strs){
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0)
            return res;

        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){

            if(str == null) continue;

            // n*log(n)
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.get(key);
            if(list == null){
                list = new ArrayList<String>();
                map.put(key, list);
                res.add(list);
            }
            list.add(str);
        }
        return res;
    }
}
