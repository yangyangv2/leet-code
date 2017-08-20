package prob014.longest.common.prefix;

/**
 * Created by yanya04 on 8/20/2017.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }

        String str = strs[0];
        int index = 0;
        while(index < str.length()){
            char c = str.charAt(index);
            for(int i = 1; i < strs.length; i ++){
                if(index < strs[i].length() && strs[i].charAt(index) == c){
                    continue;
                } else {
                    return str.substring(0, index);
                }
            }
            index ++;
        }
        return str.substring(0, index);
    }
}
