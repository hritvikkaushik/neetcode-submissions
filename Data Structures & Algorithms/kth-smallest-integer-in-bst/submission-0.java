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

// In-order traversal of BST gives sorted array
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        traverse(root, arr);
        return arr.get(k - 1);
    }

    void traverse(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        traverse(root.left, arr);
        arr.add(root.val);
        traverse(root.right, arr);
    }
}
