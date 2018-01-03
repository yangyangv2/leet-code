package prob068.text.justification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
        each word
            if(len + word exceeds max)
                calculate maximum space
                add remaining

        add remaining
    */
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();

        int index = 0;
        int len = 0;
        int wordLen = 0;
        while(index < words.length){
            String word = words[index++];
            wordLen += word.length();
            len += (len == 0) ? word.length() : word.length() + 1;
            if(len > maxWidth){
                wordLen -= word.length();
                result.add(merge(list, wordLen, maxWidth));
                index --;
                len = 0;
                wordLen = 0;
                list.clear();
            } else {
                list.add(word);
            }
        }

        result.add(tails(String.join(" ", list), maxWidth));
        return result;
    }

    private String tails(String input, int maxWidth){

        StringBuilder sb = new StringBuilder();
        sb.append(input);
        for(int i = 0; i < maxWidth - input.length(); i ++)
            sb.append(" ");
        return sb.toString();
    }

    private String merge(List<String> list, int wordLen, int maxWidth){
        StringBuilder sb = new StringBuilder();


        if(list.size() == 1){
            // only append tails
            sb.append(list.get(0));
        } else if(list.size() > 1){


            String[] words = new String[list.size() - 1];
            int totalPads = maxWidth - wordLen;
            int pads = 0;

            for(int i = 1; i < list.size(); i ++){
                words[i - 1] = list.get(i);
            }

            while(pads < totalPads){
                int index = pads % words.length;
                words[index] = " " + words[index];
                pads ++;
            }

            sb.append(list.get(0));
            for(int i = 0; i < words.length; i ++){
                sb.append(words[i]);
            }
        }
        return tails(sb.toString(), maxWidth);
    }
}