package prob301.remove.invalid.parentheses;

import java.util.*;

/**
 * Created by yanya04 on 2/6/2018.
 * Modified by yanya04 on 5/19/2018.
 */
public class Solution {
    /*
        take out each ( or ) and see if they are valid
        using bfs to ensure the minimum remove
    */
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null) return res;

        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<>();

        visited.add(s);
        queue.offer(s);

        String cur = null, left = null, right = null, next = null;
        int size = 0;
        while(!queue.isEmpty() && res.isEmpty()){
            size = queue.size();
            while(size -- > 0){
                cur = queue.poll();
                if(isValid(cur)){
                    res.add(cur);
                    continue;
                }
                char[] chars = cur.toCharArray();
                for(int i = 0; i < chars.length; i ++){
                    if(chars[i] == '(' || chars[i] == ')'){
                        left = cur.substring(0, i);
                        right = (i + 1 == chars.length) ? "" : cur.substring(i + 1, chars.length);
                        next = left + right;
                        if(visited.contains(next))
                            continue;
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        return res;

    }
    private boolean isValid(String s){

        char[] chars = s.toCharArray();
        int count = 0;
        for(int i = 0; i < chars.length; i ++){
            if(chars[i] == '(') count ++;
            else if(chars[i] == ')') count --;

            if(count < 0) return false;
        }
        return count == 0;
    }
}