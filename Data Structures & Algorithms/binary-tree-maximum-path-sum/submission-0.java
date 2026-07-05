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

    int maximum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxValue(root);
        return maximum;
    }

    int maxValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxValue(root.left));
        int right = Math.max(0, maxValue(root.right));
        int pathBetweenChildren = left + right + root.val;
        maximum = Math.max(maximum, pathBetweenChildren);
        return Math.max(root.val + left, root.val + right);
    }
}
