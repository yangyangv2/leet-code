package prob606.construct.string.from.binary.tree;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/21/2018.
 * Modified by yanya04 on 5/20/2018.
 */
public class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        dfs(t, sb);
        return sb.toString();
    }

    private void dfs(TreeNode node, StringBuilder sb){
        if(node == null)
            return;
        sb.append(String.valueOf(node.val));

        if(node.right != null) {
            sb.append("(");
            dfs(node.left, sb);
            sb.append(")");

            sb.append("(");
            dfs(node.right, sb);
            sb.append(")");
        } else if(node.left != null){
            sb.append("(");
            dfs(node.left, sb);
            sb.append(")");
        }
    }
}