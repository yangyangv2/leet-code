package prob331.verify.preorder.serialization.of.a.binary.tree;

/**
 *  Created by yanya04 on 5/19/2018.
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null) return true;
        String[] tokens = preorder.split(",");
        int indegree = -1;
        for(int i = 0; i < tokens.length; i ++){

            // every node has one indegree
            indegree ++;
            if(indegree > 0)
                return false;

            // non-leaf node has two outdegree
            if(!"#".equals(tokens[i])){
                indegree -= 2;
            }
        }
        return indegree == 0;
    }
}