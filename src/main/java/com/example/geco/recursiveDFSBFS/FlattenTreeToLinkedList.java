package com.example.geco.recursiveDFSBFS;

import com.example.geco.tree.TreeNode;
//Similar to moving the pointers on the node
// and recursively construct linkedlist using recursive
public class FlattenTreeToLinkedList {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
