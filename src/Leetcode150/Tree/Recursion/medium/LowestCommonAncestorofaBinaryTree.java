package Leetcode150.Tree.Recursion.medium;
/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”



Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1


Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
 */


public class LowestCommonAncestorofaBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root; // Return the node itself if it's p or q - one of the target found
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) { //one target is in left, the other is in right
            return root; // The LCA
        }

        return left == null ? right : left; //If only one subtree found a target, pass it upward
    }

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);

        n3.left = n5;
        n3.right = n1;
        n5.left = n6;
        n5.right = n2;
        n1.left = n0;
        n1.right = n8;
        n2.left = n7;
        n2.right = n4;


        // Example 1: p = 5, q = 1 → LCA = 3
        TreeNode lca1 = lowestCommonAncestor(n3, n5, n1);
        System.out.println("LCA of 5 & 1 = " + lca1.val);  // 3

        // Example 2: p = 5, q = 4 → LCA = 5
        TreeNode lca2 = lowestCommonAncestor(n3, n5, n4);
        System.out.println("LCA of 5 & 4 = " + lca2.val);  // 5

        // Example 3: p = 1, q = 2 → LCA = 3
        TreeNode lca3 = lowestCommonAncestor(n3, n1, n2);
        System.out.println("LCA of 1 & 2 = " + lca3.val);  // 3
    }
}
