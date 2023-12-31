package com.example.geco.tree;

public class SymmetricTree {
    public static void main(String args[]) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(2);
        TreeNode nodex = new TreeNode(4);
        TreeNode nodey = new TreeNode(4);
        TreeNode node5 = new TreeNode(1,node2,nodex);
        TreeNode node1 = new TreeNode(1,nodey,node4);
        TreeNode node3 = new TreeNode(3, node5, node1);
        isSymmetric(node3);
    }

    //image there are 2 trees and we traverse them from diff sides
    public static boolean isSymmetricGood(TreeNode root) {
        if (root == null) return true;
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) return t1 == t2;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }


    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkSymmetric(root.left, root.right);
    }

    public static boolean checkSymmetric(TreeNode left,TreeNode right) {
        if (left == null || right == null)
            return left == right;
        else if (left.val != right.val)
            return false;
        else
            return checkSymmetric(left.left, right.right) && isMirror(left.right, right.left);
    }

}