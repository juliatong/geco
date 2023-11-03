package com.example.geco.recursiveDFSBFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Maze {
    public static void main(String[] args) {
        int [][] maze=new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int [] start={0,4};
        int [] dest={1,2};
        hasPath(maze, start, dest);
    }
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        LinkedList<int[]> queue=new LinkedList<>();
        int row=maze.length;
        int col=maze[0].length;
        int dirs[][]={{0,1},{0,-1},{1,0},{-1,0}};
        queue.add(start);
        Set<String> visited=new HashSet<>();
        if(!visited.add(start[0]+","+ start[1])) return true;

        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            int count=0;
            for(int[] dir: dirs){
                int r=cur[0]+ dir[0];
                int c=cur[1]+ dir[1];
                int rr=r;
                int cc=c;
                while(rr>=0&& rr<row && cc>=0&& cc<col && maze[rr][cc]==0){
                    rr+=dir[0];
                    cc+=dir[1];
                }
                rr-=dir[0];
                cc-=dir[1];
                if(!visited.add(rr+","+cc)) continue;
                if(rr==destination[0] && cc==destination[1]) return true;
                queue.add(new int[]{rr,cc});
            }
        }
        return false;
    }
}
