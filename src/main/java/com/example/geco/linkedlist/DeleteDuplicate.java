package com.example.geco.linkedlist;


import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicate {
    //Solution 1: hash. delete node. have to preserve the node ahead of it.
    public void deleteDup(ListNode node){
        ListNode previous = new ListNode(-1);
        Set<Integer> set = new HashSet<>();

        while(node!=null){
            if(set.contains(node.val)){//connect to next next ele
                previous.next=node.next;
            }else{
                set.add(node.val);
                //pick the element
                previous=node;
            }
            node=node.next;
        }
    }

//  Solution 2: for loop
    public void deleteDupLoop(ListNode node) {
        ListNode current = node;
        while (current != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
    
}
