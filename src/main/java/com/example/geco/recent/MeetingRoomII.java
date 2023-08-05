package com.example.geco.recent;

import java.util.*;

public class MeetingRoomII {
    public static void main(String[] args) {
        minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}});
    }
    static List<int[]> result=new ArrayList<>();
    public static int minMeetingRooms(int[][] intervals) {
        if(intervals==null) return 0;
        if(intervals.length<=1) return intervals.length;

        Arrays.sort(intervals, (a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->(a[1]==b[1]?a[0]-b[0]:a[1]-b[1]));
        heap.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int [] cur=intervals[i];
            int [] top=heap.peek();
            if(top[1]<=cur[0]){//can reuse
                heap.poll();
                heap.add(new int[]{top[0], cur[1]});
            }else{
                heap.add(cur);
            }
        }
        return heap.size();
    }
}
