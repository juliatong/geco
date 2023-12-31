package com.example.geco.binarysearch;

public class MissingElementInSortedArray {
    public static void main(String[] args) {
        int nums[]={4,7,9,10};
//        missingElement2(nums,1);
    }
    //find the nearest value to k. 2 possibility: gap<k or gap>K
    public int missingElement(int[] nums, int k) {
        int base = nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] - mid - base < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] - left - base < k) return nums[left] + k - (nums[left] - left - base);
        int start = left - 1;
        return nums[start] + k - (nums[start] - start - base);
    }

}
