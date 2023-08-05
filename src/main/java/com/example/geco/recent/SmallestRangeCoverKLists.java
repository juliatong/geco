package com.example.geco.recent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoverKLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        List<Integer> list3 = Arrays.asList(1, 2, 3);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        smallestRange(lists);
    }
    static PriorityQueue<Node> queue=new PriorityQueue<>((a, b)->(a.val-b.val));
    static int min=Integer.MAX_VALUE;
    static int max=Integer.MIN_VALUE;
    static int range=Integer.MAX_VALUE;

    public static int[] smallestRange(List<List<Integer>> nums) {
        for(int i=0;i<nums.size();i++) {
            List<Integer> rows=nums.get(i);
            max=Math.max(max, rows.get(0));
            queue.add(new Node(rows.get(0),0,i));
        }

        while(true){
            Node top=queue.poll();
            if(max-top.val<=range){
                range=max-top.val;
                min=top.val;
            }
            if(top.index==nums.get(top.row).size()-1) break;
            int val=nums.get(top.row).get(top.index+1);
            queue.add(new Node(val, top.index+1, top.row));
            max=Math.max(max, val);
        }
        return new int[]{min, max};
    }



    static class Node{
        int val;
        int index;
        int row;

        Node(int v, int index, int r){
            val=v;
            this.index=index;
            row=r;
        }
    }
}
