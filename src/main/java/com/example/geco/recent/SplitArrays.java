package com.example.geco.recent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitArrays {
    public static void main(String[] args) {
//        static int nums[]={1,2,2,2,5,0};
//        waysToSplit(new int[]{1,2,2,2,5,0});
        knightDialer(2);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int total=0;
        for(char c : s1.toCharArray()){
            total+=(int) c;
        }
        for(char c : s2.toCharArray()){
            total+=(int) c;
        }
        int overlapMax=findPalindromeSubsequence(0,0, s1, s2);
        return total-2*overlapMax;
    }

    private int findPalindromeSubsequence(int i, int j, String s1, String s2) {
        if(i>=s1.length()) return 0;
        if(j>=s2.length()) return 0;

        int res1=0; int res2=0;
        if(s1.charAt(i)==s2.charAt(j)){
            int i1 = (s1.charAt(i)) + findPalindromeSubsequence(i + 1, j + 1, s1, s2);
        }
        res2=findPalindromeSubsequence(i+1, j, s1, s2);;
        return Math.max(res1, res2);
    }

    public static int knightDialer(int n) {
        if(n==1) return 10;
        Map<Integer, List<Integer>> routes=prepareRoutes();

        int total=0;
        for(int src=0; src<=9; src++){
            total+= dfs(""+src, src, n-1, routes);
        }
        return total;
    }

    private static int dfs(String s, int src, int jumps, Map<Integer, List<Integer>> routes){
        if(jumps==0){
            System.out.println(s+""+src);
            return 1;
        }
        int count=0;
        for(int dest : routes.get(src)){
            count+=dfs(s+""+dest, dest, jumps-1, routes);
        }
        return count;
    }

    private static Map<Integer, List<Integer>> prepareRoutes(){
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0; i<=9; i++){
            map.putIfAbsent(i, new ArrayList<>());
        }

        //none map.get(5)
        map.get(1).add(6);
        map.get(1).add(8);

        map.get(2).add(9);
        map.get(2).add(7);

        map.get(3).add(8);
        map.get(3).add(4);

        map.get(4).add(3);
        map.get(4).add(9);

        map.get(6).add(7);
        map.get(6).add(1);

        map.get(7).add(2);
        map.get(7).add(6);

        map.get(8).add(1);
        map.get(8).add(3);

        map.get(9).add(2);
        map.get(9).add(4);

        map.get(0).add(4);
        map.get(0).add(6);
        return map;
    }

    public static int waysToSplit(int[] nums) {
        int len=nums.length;
        int prefixSum=0;
        for(int i=0; i< len; i++){
            prefixSum+=nums[i];
            nums[i]=prefixSum;
        }

        int count=0;
        int MOD=(int)(1e9+7);
        for(int i=0; i<len-2; i++){
            int j=binarySearchLeft(i+1, nums[i], nums);
            if(j==-1 || j>=len) continue;
            int k=binarySearchRight(j, nums[i], nums);
            if( k==-1 || k<j) continue;
            count=(count+k-j+1) % MOD;
        }
        System.out.print("==========="+count);
        return count;
    }

    private static int binarySearchLeft(int left, int presum, int [] nums){
        int len=nums.length;
        int right=len-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]< 2* presum){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left]>=2*presum? left: left==len? -1: left+1;
    }

    private static int binarySearchRight(int left, int presum, int [] nums){
        int len=nums.length;
        int right=len-1;
        while(left<right){
            int mid=left+(right-left)/2;
            int midArr=nums[mid]-presum;
            int rightArr=nums[len-1] -nums[mid];
            if(midArr<=rightArr){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[len-1]-nums[right]>= nums[right] -presum? right: right==len? -1: right-1;
    }
}
