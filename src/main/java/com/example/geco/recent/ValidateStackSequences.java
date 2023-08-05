package com.example.geco.recent;

import java.util.Arrays;

public class ValidateStackSequences {
    public static void main(String[] args) {
        int[][] dp=new int[4][5];
        validateStackSequences(new int []{1,2,3,4,5}, new int[]{4,3,5,2,1});
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0;
        int j=0;
        int len=pushed.length;

        for(int val : pushed){
            pushed[i++] = val; // using pushed as the stack.
            while(i > 0 && pushed[i - 1] == popped[j]){ // pushed[i - 1] values equal to popped[j];
                i--; // decrement i
                j++; // increment j
            }
        }
        return i==0;
    }

    int mod= 1000000007;
    public int numWays(String[] words, String target) {
        int[][] fre=new int[words[0].length()][26];
        int[][] dp=new int[words.length+1][target.length()+1];
        Arrays.fill(dp,-1);
        for(String w: words){
            for(int j=0;j<words.length; j++){
                fre[j][w.charAt(j)-'a']++;
            }
        }

        return recursive(words, target, 0,0, dp, fre);
    }

    private int recursive(String [] words, String target, int i, int j, int[][] dp, int[][] fre){
        if(j>=target.length()) return 1;
        if(i>=words[0].length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int count=0;
        count=fre[i][target.charAt(j)-'a'] * recursive(words, target,i+1, j+1, dp, fre);
        count%=mod;


        count+=recursive(words, target,i+1,j, dp, fre);
        count%=mod;
        dp[i][j]=count;
        return count;
    }
}
