package com.example.geco.recursivedp;

public class dp {

    public static void main(String[] args) {
        int mums[]={10,15,20};
        minCostClimbingStairs(mums);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int len=cost.length;
        int [] dp=new int[len];
        dp[0]=cost[0];
        dp[1]=cost[1];

        for(int i=2; i<len;i++){
            dp[i]=Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i]);
        }
        return Math.min(dp[len-2],dp[len-1]);
    }

}
