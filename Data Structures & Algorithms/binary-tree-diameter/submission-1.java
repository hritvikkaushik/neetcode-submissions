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

 // One path can be through leaf to node to leaf - length = maxHeight(left) + maxHeight(right)
 // Other can be through leaf to node to root: max(maxHeight(left), maxHeight(right)) + 1 -> this will be maximized when recursion resolves back to root


class Solution {

    int longest = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight(root);
        return longest;
    }

    private int maxHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);
        int diameterThroughThisNode = lh + rh + 2;
        longest = Math.max(longest, diameterThroughThisNode);
        return Math.max(lh, rh) + 1;
    }
}
