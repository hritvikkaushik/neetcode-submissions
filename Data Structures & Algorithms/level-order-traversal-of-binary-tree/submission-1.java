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

    // DFS Solution: Pass the level at each depth.
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, 0, res);
        return res;
    }

    void traverse(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(depth, new ArrayList<>());
        }
        res.get(depth).add(root.val);
        traverse(root.left, depth + 1, res);
        traverse(root.right, depth + 1, res);
    }
}
