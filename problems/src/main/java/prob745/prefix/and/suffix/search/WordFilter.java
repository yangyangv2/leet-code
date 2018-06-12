package prob745.prefix.and.suffix.search;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 6/12/2018.
 */
public class WordFilter {

    private Map<String, Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();
        int n = words.length;
        for(int w = 0; w < n; w ++){
            String word = words[w];
            int len = word.length();
            for(int i = 0; i <= len; i ++){
                for(int j = 0; j <= len; j ++){
                    String token = word.substring(0, i) + "#" + word.substring(len - j);
                    map.put(token, w);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        String token = prefix + "#" + suffix;
        if(map.containsKey(token)){
            return map.get(token);
        } else {
            return - 1;
        }
    }
}
