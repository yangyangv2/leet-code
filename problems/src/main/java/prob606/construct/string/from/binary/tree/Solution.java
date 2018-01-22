package prob606.construct.string.from.binary.tree;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/21/2018.
 */
public class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(t, sb);
        return sb.toString();
    }

    private void helper(TreeNode t, StringBuilder sb){
        if(t == null) return;
        sb.append(t.val);

        if(t.right != null){
            sb.append("(");
            helper(t.left, sb);
            sb.append(")");

            sb.append("(");
            helper(t.right, sb);
            sb.append(")");
        } else if(t.left != null){
            sb.append("(");
            helper(t.left, sb);
            sb.append(")");
        }
    }
}
