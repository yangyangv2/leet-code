package prob028.implement.strstr;

/**
 * Created by yanya04 on 8/20/2017.
 */
class Solution {
    public int strStr(String haystack, String needle) {

        if(haystack == null || needle == null) return -1;
        if(needle.equals("")) return 0;
        for(int i = 0; i < haystack.length() - needle.length() + 1; i ++){
            for(int j = 0; j < needle.length(); j ++){
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
                if(j == needle.length() - 1) return i;
            }
        }
        return -1;
    }
}