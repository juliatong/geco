package com.example.geco.recursiveDFSBFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WallsAndGates {
    public static void main(String[] args) {
        int rooms[][] = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGates(rooms);
    }
    static int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
    public static void wallsAndGates(int[][] rooms) {
        int row=rooms.length;
        int col=rooms[0].length;

        LinkedList<int[]> queue=new LinkedList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(rooms[i][j]==0){//gate
                    Set<String> visited=new HashSet<>();
                    queue.add(new int[]{i,j});
                    visited.add(i+","+j);
                    bfs(queue, visited, rooms, row, col);
                }
            }
        }
    }

    private static void bfs(LinkedList<int[]> queue, Set<String> visited, int[][] rooms, int row, int col){
        int distance=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i< size; i++){
                int[] cur=queue.poll();
                for(int []dir: dirs){
                    int r=cur[0]+dir[0];
                    int c=cur[1]+dir[1];
                    if(r>=0 && r<row && c>=0 && c<col && rooms[r][c]>distance+1 && visited.add(r+","+c)){ rooms[r][c]=distance+1;queue.add(new int[]{r,c});}
                }
            }
            distance++;
        }
    }
}
