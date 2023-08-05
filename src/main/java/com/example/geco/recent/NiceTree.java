package com.example.geco.recent;

import java.util.*;

public class NiceTree {
    public static void main(String[] args) {
        int i = "dog".indexOf("dog");
        double pow = Math.pow(1, 2);
    }

    TreeNode root;
    private void prettyTree(TreeNode root,int val){
        if(root==null) return ;

        root.val=val;
        prettyTree(root.left, 2 * val + 1);
        prettyTree(root.right, 2 * val + 2);
    }

    ArrayDeque <Integer> stack=new ArrayDeque<>();
    public  boolean query(int target){
        //step1: re-create parents
        traceParents(target);

        //step 2:
        return preorder(root);
    }
    private void traceParents (int target){
        stack.add(target);
        while(target!=0){
            int parent;
            if(target%2==0){
                parent=(target-2)/2;
            }else{
                parent=(target-1)/2;
            }
            stack.add(parent);
            target=parent;
        }
    }

    private boolean preorder(TreeNode root){
        if(root==null) return false;
        if(stack.isEmpty()) return true;

        int ele=stack.poll();
        if(ele%2==0){
            return preorder(root.right);
        }else{
            return preorder(root.left);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
