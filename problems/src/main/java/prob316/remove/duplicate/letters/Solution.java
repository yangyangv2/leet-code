package prob316.remove.duplicate.letters;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by yanya04 on 3/6/2018.
 * Modified by yanya04 on 6/1/2018.
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
        int[] stats = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i ++){
            stats[s.charAt(i) - 'a']++;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        char c = 0;
        for(int i = 0; i < n; i ++){
            c = s.charAt(i);
            stats[c - 'a']--;
            if(visited[s.charAt(i) - 'a']) continue;
            while(!stack.isEmpty() && c < s.charAt(stack.peek()) && stats[s.charAt(stack.peek()) - 'a'] > 0){
                visited[s.charAt(stack.pop()) - 'a'] = false;
            }
            visited[s.charAt(i) - 'a'] = true;
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, s.charAt(stack.pop()));
        }
        return sb.toString();
    }
}