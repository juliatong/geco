package com.example.geco.recent;

import java.util.*;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        removeKdigits("1432219", 3);
        numberOfArithmeticSlices(new int[]{1,2,3,4,5});
        characterReplacement("AABABBA",1);
        Map<Character, Integer> map=new HashMap<>();
        Integer integer = map.values().stream().max((v1, v2) -> v2 - v1).get();

    }

    public static String removeKdigits(String num, int k) {
        int len=num.length();

        LinkedList<Integer> stack=new LinkedList<>();
        // stack.push(-1);
        int i=0;
        while(i<len){
            while(i<len && !stack.isEmpty()&& num.charAt(i)-'0'<stack.peek() &&k>0){
                stack.poll();
                k--;
            }
            if(i<len) {
                stack.push(num.charAt(i)-'0');
                i++;
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pollLast());
        return sb.toString();
    }
        public static int numberOfArithmeticSlices(int[] A) {
            int[] dp = new int[A.length];
            int sum = 0;
            for (int i = 2; i < dp.length; i++) {
                if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                    dp[i] = 1 + dp[i - 1];
                    sum += dp[i];
                }
            }
            return sum;
        }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map=new HashMap<>();

        int i = 0, j=0;
        int res=0;
        int len=s.length();
        while(j<len){
            char cur=s.charAt(j);
            map.put(cur, map.getOrDefault(cur,0)+1);
            Integer max1 = map.values().stream().max((v1, v2) -> v2 - v1).get();
            Integer max2 = map.values().stream().reduce(Integer::max).get();

            while(j-i +1 -map.values().stream().reduce(Integer::max).get()>k){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                i++;
            }
            res=Math.max(res, j-i+1);
            j++;
        }
        return res;
    }


}
