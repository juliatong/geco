package com.example.geco.recent;

public class JumpGame {
    public static void main(String[] args) {
        canReach("011010", 2,3);
    }
    public static boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(0)!=0 || s.charAt(s.length()-1)!='0') return false;
        return recursive(0,s, minJump, maxJump);
    }

    private static boolean recursive(int i,String s, int minJump, int maxJump){
        if(i==s.length()-1) return true;
        if(i>=s.length()) return false;
        if(s.charAt(i)!='0') return false;
        for(int j=minJump; j<=maxJump; j++){
            if(recursive(i+j, s, minJump, maxJump)) return true;
        }
        return false;
    }
}
