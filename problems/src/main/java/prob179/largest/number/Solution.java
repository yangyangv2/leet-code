package prob179.largest.number;

import java.util.*;

public class Solution {

    /*
        9
        98
        => 998 is larger than 989

        edge case "0000001"
    */
    public String largestNumber(int[] nums) {
        if(nums == null) return null;

        List<String> list = new ArrayList<>();
        for(int num: nums)
            list.add(String.valueOf(num));

        Collections.sort(list, new Comparator<String>(){
            public int compare(String str1, String str2){
                String num1 = str1 + str2;
                String num2 = str2 + str1;
                return num2.compareTo(num1);
            }
        });

        String res = String.join("", list);

        StringBuilder sb = new StringBuilder();
        for(char c: res.toCharArray()){
            if(sb.length() == 0 && c == '0')
                continue;
            sb.append(c);
        }


        return sb.length() == 0 ? "0" : sb.toString();
    }
}