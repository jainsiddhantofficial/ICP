/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean check = true;
    public boolean isUnivalTree(TreeNode root) {
        dfs(root, root.val);
        return check;
    }

    public void dfs(TreeNode root, int value){
        if(root == null || !check) return;
        if(value != root.val){
            check = false;
        }

        dfs(root.left, value);
        dfs(root.right, value);
    }
}