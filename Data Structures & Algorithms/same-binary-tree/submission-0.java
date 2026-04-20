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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            if (q == null) {
                return true;
            } else {
                return false;
            }
        }
        if (q == null) {
            return false;
        }
        boolean leftSame = isSameTree(p.left, q.left);
        if (!leftSame) {
            return false;
        }
        boolean rightSame = isSameTree(p.right, q.right);
        if (!rightSame) {
            return false;
        }
        return p.val == q.val;
    }
}
