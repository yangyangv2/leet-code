package prob301.remove.invalid.parentheses;

import java.util.*;

/**
 * Created by yanya04 on 2/6/2018.
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        bfs(set, s);
        return new ArrayList<String>(set);
    }

    private void bfs(Set<String> set, String s){
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        Set<String> visited = new HashSet<>();
        while(!queue.isEmpty()){
            String str = queue.poll();
            if(isValid(str)){
                set.add(str);
                continue;
            }
            for(int i = 0; i < str.length(); i ++){
                if(str.charAt(i) != '(' && str.charAt(i) != ')')
                    continue;
                StringBuilder sb = new StringBuilder(str);
                sb.deleteCharAt(i);
                if(set.isEmpty()){
                    String newStr = sb.toString();
                    if(!visited.contains(newStr)){
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
    }

    private boolean isValid(String s){
        if(s.isEmpty()) return true;
        int balance = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                balance ++;
            } else if(c == ')'){
                balance --;
            }
            if(balance < 0) return false;
        }
        return balance == 0;
    }

}