package prob222.count.complete.tree.nodes;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 8/19/2017.
 */
class Solution {

/*
    1. find left height
    2. find right height
    3. find the first difference
*/




    public int countNodes(TreeNode root) {
        int height = getLeftHeight(root);
        return countNode(root, 0, height);
    }


    private int countNode(TreeNode root, int depth, int height){

        if(root == null){
            return 0;
        }

        int leftHeight = getLeftHeight(root.left);

        int rightHeight = getRightHeight(root.right);

        int result = 0;

        if(leftHeight == rightHeight){
            result = (1 << rightHeight + 1) - 1;
        } else {

            result = countNode(root.left, depth + 1, height)
                    + countNode(root.right, depth + 1, height) + 1;
        }

        return result;
    }




    private int getLeftHeight(TreeNode root){
        int height = 0;
        TreeNode node = root;
        while(node != null){
            height ++;
            node = node.left;
        }
        return height;
    }


    private int getRightHeight(TreeNode root){
        int height = 0;
        TreeNode node = root;
        while(node != null){
            height ++;
            node = node.right;
        }
        return height;
    }


}
