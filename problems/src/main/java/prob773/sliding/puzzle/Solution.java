package prob773.sliding.puzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *  Created by yanya04 on 6/3/2018.
 */
public class Solution {
/*
    4 1 2
    5 0 3

    swap up/down/left/right

    serialize ===>  412503
                            matrix                 serialize
    swap up     (0 -> 1) 0: [1][1], 1[0][1]         4 <-> 1
    swap left   (0 -> 5) 0: [1][1], 5[1][0]         3 <-> 4
*/

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int slidingPuzzle(int[][] board) {

        String end = "123450";
        String start = serialize(board);
        if(start.equals(end)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visits = new HashSet<>();
        visits.add(start);

        int step = 0, size = 0;
        while(!queue.isEmpty()) {
            size = queue.size();
            while(size -- > 0){
                String current = queue.poll();
                if(current.equals(end)) return step;
                for(int[] dir : dirs){
                    String next = move(current, dir, board);
                    if(next == null) continue;
                    if(!visits.add(next)) continue;
                    queue.offer(next);
                }
            }
            step ++;
        }
        return -1;
    }


    private String move(String serial, int[] dir, int[][]board){
        int m = board.length, n = board[0].length;
        int start = serial.indexOf('0');
        int x = start / n, y = start % n;
        x += dir[0]; y += dir[1];
        if(x < 0 || y < 0 || x == m || y == n) return null;
        int newpos = x * n + y;
        char[] chars = serial.toCharArray();
        char c = chars[start];
        chars[start] = chars[newpos];
        chars[newpos] = c;
        return new String(chars);
    }


    private String serialize(int[][] board){
        int m = board.length, n = board[0].length;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }
}