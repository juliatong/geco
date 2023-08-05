package com.example.geco.recent;

import java.util.*;

public class MiniScorePath {
    public static void main(String[] args) {
        int[][] arr={{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
        minScore(4, arr);
    }
    public static int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> map=new HashMap<>();
        for(int i=0;i<=n;i++) map.put(i, new ArrayList<>());
        for(int[] road: roads){
            map.get(road[0]).add(new int[]{road[1], road[2]});
            map.get(road[1]).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<int[]> queue=new PriorityQueue<>((a, b)->(a[1]-b[1]));
        int[] visited=new int[n+1];
        int result=Integer.MAX_VALUE;

        queue.add(new int[]{1,Integer.MAX_VALUE});
        visited[1]=1;

        while(!queue.isEmpty()){
            int [] top=queue.poll();
            for( int[] dest: map.get(top[0])){
                result=Math.min(result, dest[1]);
                if(visited[dest[0]]==0){
                    queue.add(dest);
                    visited[dest[0]]=1;
                }
            }
        }

        return result;
    }
}
