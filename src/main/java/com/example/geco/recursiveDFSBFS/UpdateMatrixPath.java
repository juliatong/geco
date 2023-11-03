package com.example.geco.recursiveDFSBFS;

import java.util.HashSet;
import java.util.Set;

public class UpdateMatrixPath {
    public static void main(String[] args) {
        char[][] matrix={{'1', '0', '0', '1', '0'},{'1', '0', '1', '1', '0'}, {'0', '1', '1', '0', '0'}, {'0', '1', '1', '0', '0'}};
        updateShortestPath(matrix);
    }
    private static final int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    static Set<String> minPathSet= new HashSet<>();

    public static void updateShortestPath(char[][] matrix){
        for(int j=0; j< matrix[0].length; j++){
            if(matrix[0][j]=='1') {
                Set<String> visited= new HashSet<>();
                dfs(0, j, matrix, matrix.length, matrix[0].length, visited);
            }
        }
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix[0].length; j++){
                if(!minPathSet.contains(i+","+j)) matrix[i][j]='0';
            }
        }
        System.out.print("");
    }

    private static void dfs(int i,int j, char[][] matrix, int row, int col, Set<String> visited){
        visited.add(i+","+j);

        if(i==row-1 && (minPathSet.size() == 0 || visited.size()< minPathSet.size())){
            minPathSet=new HashSet<>(visited);
            visited.remove(i+","+j);
            return;
        }

        for(int [] dir: dirs){
            int r=i+dir[0];
            int c=j+dir[1];
            if(r>=0&&r<row && c>=0&& c<col &&matrix[r][c]=='1' &&!visited.contains(r+","+c)) dfs(r,c,matrix, row, col, visited);
        }
        visited.remove(i+","+j);
    }
}
