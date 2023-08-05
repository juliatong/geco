package com.example.geco.recent;

public class SearchInsertionPoint {
    public static void main(String[] args) {
        searchInsert(new int[]{1,3,5,6}, 7);
    }
    public static int searchInsert(int[] nums, int target) {
        int left=0; int right=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        if(nums[left]<target) return left+1;
        return left;
    }
}
