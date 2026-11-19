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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // post order traversal: left - right - root;
        // find the heihgt first?
        if (root == null)
            return false;
        if (compare(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) ||
        isSubtree(root.right, subRoot);
    }

    private boolean compare(TreeNode node, TreeNode subNode) {
        if (node == null && subNode == null)
            return true;
        if (node == null || subNode == null)
            return false;
        if (node.val != subNode.val)
            return false;
        return compare(node.left, subNode.left) && compare(node.right, subNode.right);
    }
}
