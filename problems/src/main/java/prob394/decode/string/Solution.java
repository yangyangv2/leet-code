package prob394.decode.string;

import java.util.Stack;

public class Solution {

    /*  2 stacks
          - number
          - words
    */
    public String decodeString(String s) {

        if(s == null || s.length() == 0) return "";


        Stack<Integer> countStack = new Stack<>();
        Stack<String> wordStack = new Stack<>();

        int idx = 0;

        StringBuilder countSb = new StringBuilder();
        StringBuilder wordSb = new StringBuilder();

        // s = "c3[a2[c]b]e", return "accaccacc".

        while(idx < s.length()){
            char c = s.charAt(idx);
            if(Character.isDigit(c)){
                while( Character.isDigit(c = s.charAt(idx)) ){
                    countSb.append(c);
                    idx++;
                }
                countStack.push(Integer.parseInt(countSb.toString()));
                countSb.setLength(0);
            } else if(c == '['){
                wordStack.push(wordSb.toString());
                wordSb = new StringBuilder();
                idx ++;
            } else if(c == ']'){
                int count = countStack.pop();
                String word = wordStack.pop();
                String cur = wordSb.toString();
                wordSb = new StringBuilder(word);
                for(int i = 0; i < count; i ++){
                    wordSb.append(cur);
                }
                idx ++;
            } else {
                // words
                wordSb.append(c);
                idx ++;
            }
        }
        return wordSb.toString();
    }
}