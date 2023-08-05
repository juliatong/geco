package com.example.geco.recent;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MinSteps {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'S', '1', '1', 'X'},
                {'1', '0', '1', '0'},
                {'1', '0', '1', '0'},
                {'1', '1', '1', '0'}};
        int minStep = miniDistance(grid);
        System.out.println("min steps needs:" + minStep);
    }

    public static int miniDistance(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        LinkedList<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new int[]{0, 0});
        visited.add(0 + "," + 0);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                if (grid[top[0]][top[1]] == 'X') return level;
                for (int[] dir : directions) {
                    int r = dir[0] + top[0];
                    int c = dir[1] + top[1];
                    if (r >= 0 && r < row && c >= 0 && c < col && grid[r][c] !='0' && visited.add(r + "," + c)) {
                        System.out.println("level:" + level+","+ "row:" + r+ ","+ "col:" + c);
                        queue.add(new int[]{r, c});
                    }
                }
            }
            level++;
        }
        return level;
    }
}

//    chamadol.nameklap@agoda.com

