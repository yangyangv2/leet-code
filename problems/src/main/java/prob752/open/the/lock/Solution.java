package prob752.open.the.lock;

import java.util.*;

/**
 *  Created by yanya04 on 5/23/2018.
 *  Modified by yanya04 on 5/31/2018.
 *
 */
public class Solution {
    public int openLock(String[] deadends, String target) {

        int move = 0;
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        int size = 0;
        while(!queue.isEmpty()){

            size = queue.size();
            while(size -- > 0){
                String next = queue.poll();
                if(!deads.add(next)) continue;
                if(target.equals(next)){
                    return move;
                }
                StringBuilder sb = new StringBuilder(next);
                char c = 0;
                for(int i = 0; i < 4; i ++){
                    c = sb.charAt(i);
                    sb.setCharAt(i, (c == '9') ? '0': (char)(c + 1));
                    queue.offer(sb.toString());
                    sb.setCharAt(i, c);
                    sb.setCharAt(i, (c == '0') ? '9': (char)(c - 1));
                    queue.offer(sb.toString());
                    sb.setCharAt(i, c);
                }
            }
            move ++;
        }
        return -1;
    }
}