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

    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> indices;

    public record Range(int l, int r) {};

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        indices = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }

        return build(new Range(0, preorder.length), new Range(0, inorder.length));
    }

    TreeNode build(Range pre, Range in) {
        if (pre.r == pre.l) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre.l]);

        int k = indices.get(root.val);
        int sizeL = k - in.l;

        root.left = build(new Range(pre.l + 1, pre.l + sizeL + 1), new Range(in.l, k));
        root.right = build(new Range(pre.l + sizeL + 1, pre.r), new Range(k + 1, in.r));

        return root;
    }
}
