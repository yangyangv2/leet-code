package prob093.restore.ip.addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 1/8/2018.
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();

        if(s == null || s.length() == 0)
            return result;

        backtrack(result, new ArrayList<String>(), s, 0);

        return result;
    }

    private void backtrack(List<String> result, List<String> list, String s, int start){


        if(list.size() == 4){
            String temp =String.join("", list);
            if(temp.length() == s.length()){
                result.add(String.join(".", list));
            }
        } else if(list.size() > 4)
            return;


        for(int i = 1; i < 4; i ++){
            if(start + i > s.length())
                continue;
            String next = s.substring(start, start + i);

            // exclude "001" and "011";

            if(next.length() > 1 && next.startsWith("0"))
                continue;

            if(Integer.parseInt(next) <= 255){
                list.add(next);
                backtrack(result, list, s, start + i);
                list.remove(list.size() - 1);
            }
        }

    }
}
