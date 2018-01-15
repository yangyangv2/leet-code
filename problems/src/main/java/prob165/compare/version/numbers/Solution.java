package prob165.compare.version.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 1/15/2018.
 */
public class Solution {

    /*  1. tokenize
        2. compare by token
        3. edge case:
           1.0 vs 1.0.0

    */
    public int compareVersion(String version1, String version2) {

        if(version1 == null && version2 == null)
            return 0;
        else if(version1 == null)
            return -1;
        else if(version2 == null)
            return 1;

        return compare(tokenize(version1), tokenize(version2));
    }

    private int compare(List<Integer> version1, List<Integer> version2){


        int min = Math.min(version1.size(), version2.size());

        for(int i = 0; i < min; i ++){
            if(version1.get(i) > version2.get(i)){
                return 1;
            } else if(version1.get(i) < version2.get(i)){
                return -1;
            }
        }

        if(version1.size() > version2.size()) {
            for(int i = min; i < version1.size(); i ++){
                if(version1.get(i) != 0)
                    return 1;
            }
        } else if(version1.size() < version2.size()){
            for(int i = min; i < version2.size(); i ++){
                if(version2.get(i) != 0)
                    return -1;
            }
        }

        return 0;
    }

    private List<Integer> tokenize(String version){
        String[] tokens = version.split("\\.");

        List<Integer> list = new ArrayList<>(tokens.length);
        for(String token: tokens){
            list.add(Integer.parseInt(token));
        }
        return list;
    }
}
