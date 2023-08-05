package com.example.geco.recent;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MST {
    public static void main(String[] args) {
        minCostConnectPoints(new int[][]{{3,12},{-2,5},{-4,1}});
        LinkedList<String> strings = new LinkedList<>();
    }


    public static int minCostConnectPoints(int[][] points) {
        int len=points.length;
        boolean visited[]=new boolean[len];
        PriorityQueue<Point> heap=new PriorityQueue<>((a, b)-> a.weight-b.weight);
        int edgeUsed=0;
        int result=0;

        heap.add(new Point(0,0));
        while(edgeUsed<len){
            Point top=heap.poll();
            if(visited[top.index]) continue;

            visited[top.index]=true;
            edgeUsed++;
            result+=top.weight;
            for(int j=0;j<len;j++){
                if(!visited[j]){
                    int weight=Math.abs(points[j][0]- points[top.index][0]) + Math.abs(points[j][1]- points[top.index][1]);
                    heap.add(new Point(j, weight));
                }
            }
        }
        return result;
    }

    static class Point{
        int index;
        int weight;

        Point(int index, int weight){
            this.index=index;
            this.weight=weight;
        }
    }
}
