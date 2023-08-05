package com.example.geco.recent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Singtel {
    static int max;
    static int operationHead;
    public static int findMaxNum(int x, int y, int z){
        Random random = new Random();
        int i = random.nextInt(1);
        operationHead=z;
        max=x;
        recursive(x,y,0,x);
        return max;
    }

    private static void recursive(int source, int target, int count, int pathMax) {
        if(count>operationHead) {
            return;
        }

        if(source==target){
            max=Math.max(max,pathMax);
        }
        pathMax=Math.max(pathMax,source);
        recursive(source+1, target, count+1, pathMax);
        recursive(source-1, target, count+1, pathMax);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 3, 5, 7, 9, 11);
        int m1=findMaxNum(4,4,4);
        int m2=findMaxNum(8,5,3);
        int m3=findMaxNum(4,4,6);
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }
}
