package prob752.open.the.lock;

import java.util.*;

/**
 *  Created by yanya04 on 5/23/2018.
 *
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        queue.offer("0000");

        int size = 0, level = 0;
        String code = null, next = null;
        StringBuilder sb = null;
        char c = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            while(size > 0){
                size --;
                code = queue.poll();
                if(!deads.add(code)) continue;
                if(code.equals(target)) return level;
                sb = new StringBuilder(code);
                // try each combinations
                for(int i = 0; i < 4; i ++){
                    c = sb.charAt(i);
                    sb.setCharAt(i, c == '0' ? '9': (char)(c - 1));
                    next = sb.toString();
                    sb.setCharAt(i, c);
                    queue.offer(next);
                    sb.setCharAt(i, c == '9' ? '0': (char)(c + 1));
                    next = sb.toString();
                    sb.setCharAt(i, c);
                    queue.offer(next);
                }
            }
            level ++;
        }

        return - 1;
    }
}