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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        while (root != null) {
            if (a.val < root.val && b.val < root.val) {
                root = root.left;
            } else if (a.val > root.val && b.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
