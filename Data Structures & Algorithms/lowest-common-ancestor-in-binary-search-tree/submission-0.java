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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            var node = q.poll();
            if (node.val == a.val || node.val == b.val) {
                return node;
            }
            TreeNode containingA = find(node, a);
            TreeNode containingB = find(node, b);
            if (containingA != containingB) {
                return node;
            } else {
                q.add(containingA);
            }
        }
        return null;
    }

    TreeNode find(TreeNode root, TreeNode a) {
        if (root != null && search(root.left, a)) {
            return root.left;
        } else {
            return root == null ? null : root.right;
        }
    }

    boolean search(TreeNode root, TreeNode q) {
        if (root == null) {
            return false;
        }
        if (root.val == q.val) {
            return true;
        }
        if (q.val < root.val) {
            return search(root.left, q);
        }
        return search(root.right, q);
    }
}
