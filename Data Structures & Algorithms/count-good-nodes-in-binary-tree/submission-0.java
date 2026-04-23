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
    public int goodNodes(TreeNode root) {
        int[] res = new int[1];
        res[0] = 0;
        traverse(root, Integer.MIN_VALUE, res);
        return res[0];
    }

    void traverse(TreeNode root, int greatestSeen, int[] res) {
        if (root == null) {
            return;
        }
        if (root.val >= greatestSeen) {
            res[0] += 1;
        }
        traverse(root.left, Math.max(greatestSeen, root.val), res);
        traverse(root.right, Math.max(greatestSeen, root.val), res);
    }
}
