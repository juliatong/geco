package com.example.geco.recent;

public class Palindrome {

    public static void main(String[] args) {
        String result = addLetterPalindrome("aacecaaa");
        System.out.println("hello world:" + result);
    }

    //abb
    //bbabb
    //s = "aacecaaa"
    // aacecaa + a
    // (a)+ aacecaa + a  //replica the hanging substr at the back
    // --> [aacecaa]+ a

    // cabab
    // c+ abab
    // baba + c+ abab //replic palindrome itself
    // --> [c]+ abab

    // cacdbdbd
    // dbdbd
    //(cac) + dbdbd //
    // --> [cac]+ (dbdbd)
    static int end = 0;
    static int max = Integer.MIN_VALUE;

    public static String addLetterPalindrome(String s) {
        int end = findLongestPalindromeFromStart(s);

        int p = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (p > end) {
            sb.append(s.charAt(p));
            p--;
        }
        return sb.toString();
    }

    private static int findLongestPalindromeFromStart(String s) {
        if (s == null || s.length() <= 1) return -1;
        int len = s.length();
        int i = 0;
        int end1=0;
        int end2=0;
        while (i < len) {
            end1 = extendPanlidrome(i, i, s);
            end2 = extendPanlidrome(i, i + 1, s);
        }
        return (end1 > end2)? end1: end2;
    }

    private static int extendPanlidrome(int i, int j, String s) {
        if (i < 0 || j < i) return -1;
        int len = s.length();// abba; i=1, int j=1;
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            if (j - i + 1 > max && i == 0) {
                end = j;
                max = j - i + 1;
            }
            i--;
            j++;
        }
        return end;
    }
}

    

