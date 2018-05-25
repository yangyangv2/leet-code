package prob753.cracking.the.safe;

import java.util.HashSet;
import java.util.Set;

/**
 *  Created by yanya04 on 5/23/2018.
 */
public class Solution {
    /*
        (k ^ n) combinations
    */
    public String crackSafe(int n, int k) {

        Set<String> visited = new HashSet<>();
        int target = (int)Math.pow(k, n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i ++){
            sb.append(String.valueOf(0));
        }
        visited.add(sb.toString());
        dfs(sb, visited, target, n, k);
        return sb.toString();
    }

    private boolean dfs(StringBuilder sb, Set<String> visited, int target, int n, int k){

        if(visited.size() == target){
            return true;
        }

        // take the last n - 1 chars
        // 0000 -> 000 + [0-9]
        String str = sb.substring(sb.length() - n + 1, sb.length());
        String next = str;
        for(int i = 0; i < k; i ++){
            next = str + i;
            if(!visited.contains(next)){
                visited.add(next);
                sb.append(String.valueOf(i));
                if(dfs(sb, visited, target, n, k)){
                    return true;
                } else {
                    visited.remove(next);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return false;
    }
}