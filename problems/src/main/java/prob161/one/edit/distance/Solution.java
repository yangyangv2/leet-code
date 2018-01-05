package prob161.one.edit.distance;

/**
 * Created by yanya04 on 1/3/2018.
 */
public class Solution {

    /*
        1. abc vs ace
        2. abce vs abc
        3. abc vs abcd


    */
    public boolean isOneEditDistance(String s, String t) {

        int len1 = s.length(), len2 = t.length();

        for(int i = 0; i < Math.min(len1, len2); i ++){

            if(s.charAt(i) != t.charAt(i)){
                if(len1 == len2){
                    return s.substring(i + 1).equals(t.substring(i + 1));   // delete both
                } else if(len1 > len2){
                    return s.substring(i + 1).equals(t.substring(i));   // delete s
                } else {
                    return s.substring(i).equals(t.substring(i + 1));   // delete t
                }
            }
        }

        return Math.abs(len1 - len2) == 1;

    }
}
