package com.example.geco.tree;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

public class MatchRegex {
    public static void main(String[] args) {
        List<String> words = Lists.newArrayList("world", "word", "would", "wont", "which", "hello");
        getMatchingWords("w2*d", words);
    }

    public static List<String> getMatchingWords(String regex, List<String> words){
        Node root=new Node('\0');
        insert(regex, 0, root);

        List<String> result = new ArrayList<>();
        for (String word: words) {
            Node end=search(word, 0, root);
            if( end!=null&& end.isEnd) result.add(word);
        }
        return result;
    }

    private static Node search(String word, int index, Node parent){
        if(index>= word.length()) return parent;
        if(parent==null) return parent;

        char cur=word.charAt(index);
        return search(word, index+1, parent.children[cur-'a']);
    }

    private static void insert(String regex, int index, Node root){

    }




    static class Node{
        char c;
        boolean isEnd;
        Node[] children;
        Node(char c){
            this.c=c;
            this.children=new Node[26];
        }
    }
    private static boolean isMatch(String word, int i, String regex, int j){
        //base case
        if(i>= word.length() && j>= regex.length()) return true;
        if(i>=word.length() || j>=regex.length()) return false;

        char w= word.charAt(i);
        char r= regex.charAt(j);
        if(Character.isDigit(r)){
            return isMatch(word, i+(r-'0'), regex, j+2);
        } else if (w!=r) {
            return false;
        }
        return isMatch(word, i+1, regex, j+1);
    }
}
