package prob616.add.bold.tag.in.string;

/**
 *  Created by yanya04 on 5/24/2018.
 */
public class Solution {
    public String addBoldTag(String s, String[] dict) {

        boolean[] bold = new boolean[s.length()];
        int index = -1;
        for(String word: dict){
            while((index = s.indexOf(word, index + 1)) >= 0){
                for(int i = index; i < index + word.length(); i ++)
                    bold[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean started = false;
        for(int i = 0; i < s.length(); i ++){
            if(bold[i] && !started){
                sb.append("<b>");
                started = true;
            } else if(!bold[i] && started){
                sb.append("</b>");
                started = false;
            }
            sb.append(s.charAt(i));
        }

        if(started){
            sb.append("</b>");
        }

        return sb.toString();

    }
}