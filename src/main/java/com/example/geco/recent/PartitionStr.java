package com.example.geco.recent;


import java.util.HashSet;
import java.util.Set;

public class PartitionStr {
    public static void main(String[] args) {
        int res=partitionString("aba");
        System.out.print(res);
    }
    public static int partitionString(String s) {
        if(s.length()<=1) return s.length();
        return recursive(s);
    }

    private static int recursive(String s){
        if(s==null || s.length()<=1 || isUnique(s)) return 1;

        int min=Integer.MAX_VALUE;
        for(int i=1;i<s.length(); i++){
            min=Math.min(min, recursive(s.substring(0,i)) +recursive(s.substring(i)));
        }
        return min;
    }

    private static boolean isUnique(String s){
        Set<Character> seen=new HashSet<>();
        for(char c: s.toCharArray()) {
            if(!seen.add(c)) return false;
        }
        return true;
    }
}
