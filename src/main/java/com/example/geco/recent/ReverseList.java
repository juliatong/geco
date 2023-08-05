package com.example.geco.recent;

import java.util.PriorityQueue;

public class ReverseList {
    PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a, b)->(b-a));

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2, null);
        ListNode node1 = new ListNode(1, node2);
        reverseList(node1);
    }
    static ListNode nHead=null;

    public static ListNode reverseList(ListNode head) {
        if(head==null|| head.next==null) return head;
        recursive(head);
        System.out.println(nHead);
        return nHead;
    }

    private static ListNode recursive(ListNode head){
        if(head.next==null) {
            nHead=head;
            return head;
        }


        ListNode next=head.next;
        head.next=null;
        ListNode rest=recursive(next);
        rest.next=head;
        return head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
