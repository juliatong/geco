package com.example.geco.recent;

import java.util.*;

public class KDistance {
    class Solution {
        public int[][] candyCrush(int[][] board) {
            int N = board.length, M = board[0].length;
            boolean found = true;
            while (found) {
                found = false;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        int val = Math.abs(board[i][j]);
                        if (val == 0) continue;
                        if (j < M - 2 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
                            found = true;
                            int ind = j;
                            while (ind < M && Math.abs(board[i][ind]) == val) board[i][ind++] = -val;
                        }
                        if (i < N - 2 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
                            found = true;
                            int ind = i;
                            while (ind < N && Math.abs(board[ind][j]) == val) board[ind++][j] = -val;
                        }
                    }
                }
                if (found) { // move positive values to the bottom, then set the rest to 0
                    for (int j = 0; j < M; j++) {
                        int storeInd = N - 1;
                        for (int i = N - 1; i >= 0; i--) {
                            if (board[i][j] > 0) {
                                board[storeInd--][j] = board[i][j];
                            }
                        }
                        for (int k = storeInd; k >= 0; k--) board[k][j] = 0;
                    }
                }
            }
            return board;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(1);
        root.left=node1;
        root.right=node5;
        node1.right=node2;
        node2.left=node3;
        node2.right=node4;
        distanceK(root,node1,2);
    }

    static Map<TreeNode, TreeNode> map=new HashMap<>();
    static List<Integer> result=new ArrayList<>();

        public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            if(root==null||target==null) return result;
            preorderTree(null,root);

            LinkedList<TreeNode> queue=new LinkedList<>();
            bfs(queue, target,k);
            return result;
        }

        private static void bfs(LinkedList<TreeNode> queue, TreeNode target, int k){
            queue.add(target);
            Set<TreeNode> visited=new HashSet<>();
            visited.add(target);

            while(!queue.isEmpty()&&k>=0){
                int size=queue.size();
                for(int i=0;i<size;i++){
                    TreeNode top=queue.poll();
                    if(k==0) result.add(top.val);
                    System.out.println(top.val);
                    if(top.left!=null &&visited.add(top.left)) queue.add(top.left);
                    if(top.right!=null &&visited.add(top.right)) queue.add(top.right);
                    if(map.containsKey(top)&&visited.add(map.get(top))) {
                        queue.add(map.get(top));
                    }
                }
                k--;
            }
        }

        private static void preorderTree(TreeNode parent, TreeNode root){
            if(root==null) return;
            map.put(root, parent);

            preorderTree(root, root.left);
            preorderTree(root, root.right);
        }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
