package prob236.lowest.common.ancestor.of.a.binary.tree;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 1/20/2018.
 */
public class Solution {

    /*
        1. traverse and get two path;
        2. find from the root and get the last common node
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> list1 = find(root, p, new ArrayList<>());
        List<TreeNode> list2 = find(root, q, new ArrayList<>());

        TreeNode ancestor = root;
        for(int i = 0; i < Math.min(list1.size(), list2.size()); i ++){
            if(list1.get(i).val == list2.get(i).val){
                ancestor = list1.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    /**
     traverse tree with a node
     */
    public List<TreeNode> find(TreeNode root, TreeNode p, List<TreeNode> path){
        if(root == null){
            return null;
        }
        path.add(root);
        if(root == p){
            return path;
        }
        List<TreeNode> left = find(root.left, p, path);
        if(left != null) return left;
        List<TreeNode> right = find(root.right, p, path);
        if(right!= null) return right;
        path.remove(path.size() - 1);
        return null;
    }
}
