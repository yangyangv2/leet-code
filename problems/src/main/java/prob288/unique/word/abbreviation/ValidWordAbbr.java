package prob288.unique.word.abbreviation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yanya04 on 2/3/2018.
 */
public class ValidWordAbbr {

    private Map<String, Set<String>> dict;

    public ValidWordAbbr(String[] dictionary) {
        dict = new HashMap<String, Set<String>>();
        if(dictionary != null){
            for(String str: dictionary){
                String abre = toAbre(str);
                Set<String> set = dict.get(abre);
                if(set == null){
                    set = new HashSet<String>();
                    dict.put(abre, set);
                }
                set.add(str);
            }
        }

    }

    private String toAbre(String str){
        if(str.length() > 2){
            return str.charAt(0) + String.valueOf((str.length() - 2)) + str.charAt(str.length() - 1);
        } else {
            return str;
        }
    }

    public boolean isUnique(String word) {
        String abre = toAbre(word);
        Set<String> set = dict.get(abre);
        if(set == null)
            return true;

        if(set.size() > 1)
            return false;

        return set.contains(word);
    }
}
