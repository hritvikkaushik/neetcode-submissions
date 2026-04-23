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

// BFS Solution
class Solution {
    public int goodNodes(TreeNode root) {
        int res = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, root.val));

        while (!q.isEmpty()) {
            var pair = q.poll();
            var node = pair.getKey();
            var greatestSeenOnPath = pair.getValue();
            if (node.val >= greatestSeenOnPath) {
                greatestSeenOnPath = node.val;
                ++res;
            }
            if (node.left != null) {
                q.add(new Pair<>(node.left, greatestSeenOnPath));
            }
            if (node.right != null) {
                q.add(new Pair<>(node.right, greatestSeenOnPath));
            }
        }
        return res;
    }
}
