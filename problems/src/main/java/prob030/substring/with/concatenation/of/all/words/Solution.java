package prob030.substring.with.concatenation.of.all.words;

/**
 * Created by yanya04 on 8/20/2017.
 */
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

/*
    1. window size = words.length * words[0].length
    2. map each word and find all locations

        barfoothefoobarman
    foo    3     9
    bar 0           12      [3: foo, 9: foo, 0: bar, 12: bar]

    3. for each move, search for startIndex + 0, 3, 6, 9 ...etc

    4 if find, mark the index;

    memory      O(n)
    complexity  O(n * m)    m = words.length
*/




    public List<Integer> findSubstring(String s, String[] words) {

        if(words == null || words.length == 0) return Collections.emptyList();

        int m = words.length;
        int k = words[0].length();

        String[] distMap = new String[s.length()];
        Arrays.fill(distMap, null);

        Map<String, Integer> countMap = new HashMap<>();

        // initialize countMap
        for(int i = 0; i < m; i ++){
            String word = words[i];
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // initialize distMap
        for(int i = 0; i <= s.length() - k; i ++){
            String substr = s.substring(i, i + k);
            if(countMap.containsKey(substr)){
                distMap[i] = substr;
            }
        }



        List<Integer> result = new ArrayList<>();

        // scan
        if(s.length() < m * k) return Collections.emptyList();

        for(int i = 0; i <= s.length() - m * k; i ++){


            Map<String, AtomicInteger> statMap = new HashMap<>();
            for(int j = 0; j < m; j ++){
                String word = distMap[i + j * k];


                if(word == null) break; // does not find match, move to next index

                // most expensive ----

                AtomicInteger count = statMap.get(word);
                if(count == null){
                    count = new AtomicInteger(0);
                    statMap.put(word, count);
                }
                count.getAndIncrement();

            }


            if(countMap.size() == statMap.size()){
                boolean complete = true;
                for(Map.Entry<String, Integer> entry: countMap.entrySet()){
                    if(entry.getValue() != statMap.get(entry.getKey()).get()){
                        complete = false;
                        break;
                    }
                }

                if(complete){
                    result.add(i);
                }
            }
        }
        return result;
    }

}
