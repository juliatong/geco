package com.example.geco.recent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReversePartialList {
    //hello
    public static void main(String[] args) {
        Map<String, List<Float>> prices=new HashMap<>();
        int numDigits = (int) Math.log10(10) + 1;

        ListNode node5=new ListNode(5,null);
        ListNode node4=new ListNode(4,node5);
        ListNode node3=new ListNode(3,node4);
        ListNode node2=new ListNode(2,node3);
        ListNode node1=new ListNode(1,node2);
        ListNode head=reverseFromPostion(node1, 2,4);
        iterateNodes(head);
    }


    public static ListNode reverseFromPostion(ListNode head, int m, int n){
        //1.capture node
        ListNode copy=head; ListNode previous=null;
        int p=1;
        ListNode start=null; ListNode beforeStart=null;
        ListNode end=null; ListNode afterEnd=null;
        while(p<=n){
            if(p==m) {
                beforeStart=previous;
                start=copy;
            }
            if(p==n) {
                end=copy;
                afterEnd=copy.next;
            }
            previous=copy;
            copy=copy.next;
            p++;
        }
        System.out.print(" 1 beforeStart node" + beforeStart.val);
        System.out.print(" 1 afterEnd node" + afterEnd.val);

        //2. dosconnect
        previous.next=null;
        end.next=null;

        //3. reverse
        List<ListNode> nodes=reverse(start); //0-> head, 1-> tail

        System.out.print("partial new head" + nodes.get(0).val);
        System.out.print("partial new tail" + nodes.get(1).val);
        System.out.print("beforeStart node" + beforeStart.val);
        System.out.print("afterEnd node" + afterEnd.val);
        //4. reconnect
        beforeStart.next=nodes.get(0);
        nodes.get(1).next=afterEnd;
        return head;
    }

    private static List<ListNode> reverse(ListNode head){
        List<ListNode> nodes=new ArrayList<>();

        ListNode cur=head; ListNode previous=null;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=previous;

            previous=cur;
            cur=next;
        }
        nodes.add(cur);//reversed head
        nodes.add(head);
        return nodes;
    }


    private static void iterateNodes(ListNode head){
        while(head!=null){
            System.out.print(head.val);
            head=head.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }
}
