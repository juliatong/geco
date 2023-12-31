package com.example.geco.recursive.backtracking;

import com.example.geco.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int []nums = {1,2,3};
        subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);//must sort
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }




    //solution 1: backtrack
    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        //base case
        list.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    //solution2:can also be solved using knapsack thinking
    //solution 3: iterative with append
    //{a,b}, {}{a}-->{}{a}+{b}{ab}
}
