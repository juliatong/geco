package com.example.geco.recent;

import java.util.ArrayDeque;

public class SlidingWin {
    public static void main(String[] args) {
        int [] nums=new int[]{1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums,3);
    }
    static ArrayDeque<Integer> stack=new ArrayDeque<>();
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int i=0; int len=nums.length;
        if (len * k == 0) return new int[0];
        if (k == 1) return nums;

        int result[]=new int[len-k+1];
        for(;i<k;i++){
            clean(i,k, nums);
            stack.addLast(i);
        }
        result[0]=nums[stack.getFirst()];

        while(i<len){
            clean(i,k, nums);
            stack.push(i);
            result[i-k+1]=nums[stack.getFirst()];
            i++;
        }
        return result;
    }
    private static void clean(int i,int k, int [] nums){
        if(!stack.isEmpty()&&stack.getFirst() == i - k) stack.pollFirst();
        while(!stack.isEmpty()&& nums[stack.getLast()]<nums[i]){
            stack.pollLast();
        }
    }
}
