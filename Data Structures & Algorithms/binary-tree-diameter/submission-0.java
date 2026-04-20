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

 // One path can be through leaf to node to leaf - length = maxHeight(left) + maxHeight(right) + 2
 // Other can be through leaf to node to root: max(maxHeight(left), maxHeight(right)) + 1 -> this will be maximized when recursion resolves back to root


class Solution {

    int longest = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        return Math.max(maxHeight(root) - 1, longest);
    }

    private int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);
        int leafToLeaf = lh + rh;
        longest = Math.max(longest, leafToLeaf);
        int res = Math.max(lh, rh) + 1;
        System.out.println("root: " + root.val + " lh: " + lh + " rh: " + rh + " longest: " + longest + " return: " + res);
        return res;
    }
}
