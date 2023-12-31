package com.example.geco.recursivedp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSequence {
    public static void main(String args[]) {
        String text1 = "abcde";
        String text2 = "ace";
        longestCommonSubsequence(text1,text2);
        String str1 = "a";
        String str2 = "z";
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length();
        int column = text2.length();
        int[][] dp = new int[row+1][column+1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <=column ; j++) {
               if(text1.charAt(i-1)==text2.charAt(j-1)){
                   dp[i][j]=dp[i-1][j-1]+1;
               } else {
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
            }
        }
        return dp[row][column];
    }


}
