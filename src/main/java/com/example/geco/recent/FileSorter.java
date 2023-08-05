package com.example.geco.recent;

import java.util.*;

public class FileSorter {
    public static void main(String[] args) {
//        'a' - '1'
        List<String> files= new ArrayList<>(Arrays.asList("file1","file2","file10"));

        Collections.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int i=0; int j=0;
                int len1=s1.length(); int len2=s2.length();
                while(i<len1&& j<len2){
                    char c1=s1.charAt(i);
                    char c2=s2.charAt(j);
                    if(Character.isDigit(c1)&& Character.isDigit(c2)){
                        int count1=0; int count2=0;
                        while((i<len1&&Character.isDigit(s1.charAt(i))) ||(j<len2&&Character.isDigit(s2.charAt(j))) ){
                            if(i<len1) {
                                count1 = count1 * 10 + s1.charAt(i) - '0';
                                i++;
                            }
                            if(j<len2) {
                                count2 = count2 * 10 + s2.charAt(j) - '0';
                                j++;
                            }
                        }
                        return count1-count2;
                    }else if(c1==c2){
                        i++; j++;
                    }else{
                        return c1-c2;
                    }
                }
                return i-j;
            }
        });
        System.out.println("xx");
    }
}
