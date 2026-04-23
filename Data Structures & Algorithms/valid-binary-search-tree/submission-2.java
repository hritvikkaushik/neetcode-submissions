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
    public boolean isValidBST(TreeNode root) {
        return checkValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean checkValid(TreeNode node, long least, long greatest) {
        if (node == null) return true;

        if (node.val <= least || node.val >= greatest) {
            return false;
        }

        return checkValid(node.left, least, node.val) &&
               checkValid(node.right, node.val, greatest);
    }
}