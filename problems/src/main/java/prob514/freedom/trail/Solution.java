package prob514.freedom.trail;

/**
 * Created by yanya04 on 6/2/2018.
 */
public class Solution {

    /*
        there is only 2 operations (clockwise & anti-clockwise) at each step
        try bruteforce + memo

    */
    public int findRotateSteps(String ring, String key) {

        String[] rings = new String[ring.length()];
        for(int i = 0; i < ring.length(); i ++){
            rings[i] = ring.substring(i) + ring.substring(0, i);
        }

        int[][] memo = new int[ring.length()][key.length()];

        return dfs(0, key, 0, rings, memo);
    }


    private int dfs(int ringIndex, String key, int start, String[] rings, int[][] memo){

        if(start == key.length()) return 0;
        if(memo[ringIndex][start] > 0) return memo[ringIndex][start];

        int steps = 0;
        char ch = key.charAt(start);

        String ring = rings[ringIndex];

        int f = findPos(ring, ch);
        int b = findPosAnti(ring, ch);

        // take existing ringIndex as offset for where the next ring starts
        int nf = (f + ringIndex) % ring.length();
        int nb = (b + ringIndex) % ring.length();

        int forward = 1 + (f) + dfs( nf, key, start + 1, rings, memo);
        int backward = 1 + (ring.length() - b) + dfs(nb, key, start + 1, rings, memo);

        steps = Math.min(forward, backward);
        memo[ringIndex][start] = steps;

        return steps;

    }


    private int findPos(String ring, char ch){
        return ring.indexOf(ch);
    }

    private int findPosAnti(String ring, char ch){
        if(ring.charAt(0) == 0) return 0;
        for(int i = ring.length() - 1; i > 0; i --){
            if(ring.charAt(i) == ch) return i;
        }
        return 0;
    }
}