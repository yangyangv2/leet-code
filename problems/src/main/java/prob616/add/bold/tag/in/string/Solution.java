package prob616.add.bold.tag.in.string;

/**
 *  Created by yanya04 on 5/24/2018.
 *  Modified by yanya04 on 6/1/2018.
 */
public class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for(String word: dict){
            int index = -1;
            while( (index = s.indexOf(word, index + 1)) >= 0){
                for(int i = index; i < index + word.length(); i ++){
                    bold[i] = true;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        boolean b = false;
        for(int i = 0; i < s.length(); i ++){

            if(!b && bold[i]){
                res.append("<b>");
                b = true;
            }

            if(b && !bold[i]) {
                res.append("</b>");
                b = false;
            }

            res.append(s.charAt(i));

        }

        if(b) res.append("</b>");
        return res.toString();

    }
}