package prob316.remove.duplicate.letters;

import java.util.Stack;

/**
 * Created by yanya04 on 3/6/2018.
 */
public class Solution {

    /*
        b c a a a b a a b a
        v v v x x v x x x x
            ^b
            cab

        c b a c d c b c
        v v v v v x x x
            ^b
            ^c

        acdb

    */

    public String removeDuplicateLetters(String s) {

        int[] count = new int[26];
        for(char c: s.toCharArray()){
            count[c - 'a'] ++;
        }

        boolean[] visited = new boolean[26];

        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            count[c - 'a'] --;
            if(visited[c - 'a']) continue;
            while(!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0){
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        return sb.toString();

    }



}
