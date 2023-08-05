package com.example.geco.recent;

import java.util.*;

public class BrowserHistory {
    public static void main(String[] args) {
        boolean b = false && false;
        System.out.print(b);
        BrowserHistory browser = new BrowserHistory("leetcode.com");
        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");
        browser.back(1);//facebook.com
        browser.back(1);//google.com.com
        browser.forward(1);//facebook.com
        browser.visit("linkedin.com");//linkedin.com
        browser.forward(2);//"linkedin.com",
        browser.back(2);//"google.com",
        browser.back(7);//"leetcode.com"
    }
    static Node head;
    static Node tail;
    static Node cur;
    public BrowserHistory(String homepage) {
        head=new Node("\0");
        tail=new Node("\0");
        cur=new Node(homepage);
        head.next=cur;
        cur.prev=head;

        cur.next=tail;
        tail.prev=cur;
    }

    public static void visit(String url) {
        Node node=new Node(url);
        head.next=node;
        node.prev=head;

        node.next=cur;
        cur.prev=node;

        cur=node;
    }

    public static String back(int steps) {
        while(cur.next!=tail&&steps>0){
            cur=cur.next;
            steps--;
        }
        System.out.println(cur.url);
        return cur.url;
    }

    public static String forward(int steps) {
        while(cur.prev!=head &&steps>0){
            cur=cur.prev;
            steps--;
        }
        System.out.println(cur.url);
        return cur.url;
    }

    static class Node{
        String url;
        Node prev;
        Node next;

        Node(String s){
            url=s;
        }
    }

    public static class BusRoute {
        public static void main(String[] args) {
            maxScore(new int[]{3,0,-3,0});
            numBusesToDestination(new int[][]{{1},{15,16,18},{10},{3,4,12,14}}, 3, 15);
        }



        public static int maxScore(int[] nums) {
            if(nums==null|| nums.length==0) return 0;
            int sum=0;  int score=0;
            PriorityQueue<Integer> heap=new PriorityQueue<>((a, b)->(b-a));
            boolean hasPos=false;
            int zeros=0;

            for(int n: nums){
                if(n>0) {
                    hasPos=true;
                    sum+=n; score++;
                }else if(n==0){
                    zeros++;
                }else{
                    heap.add(n);
                }
            }
            if(hasPos&&zeros>0) score++;

            while(!heap.isEmpty()&& sum>0){
                if((sum+=heap.poll())>0) {
                    score++;
                }
            }
            return score;
        }
        static Map<Integer, List<Integer>> map=new HashMap<>();

        public static int numBusesToDestination(int[][] routes, int source, int target) {
            if(routes==null|| routes.length==0 || source==target) return 0;
            int n=routes.length;

            buildGraph(routes);

            // create source and target states
            LinkedList<Point> queue=new LinkedList<>();
            Set <Integer> seen= new HashSet<>(); //do not ride the same bus again
            Set <Integer> targets= new HashSet<>();
            for(int i=0;i<n;i++){
                if(Arrays.binarySearch(routes[i], source) >-1){
                    queue.add(new Point(i,0));
                    seen.add(i);
                }
                if(Arrays.binarySearch(routes[i], target) >-1){
                    targets.add(i);
                }
            }

            return bfs(queue, seen, targets);
        }

        private static int bfs(LinkedList<Point> queue, Set<Integer> seen, Set <Integer> targets){
            while(!queue.isEmpty()){
                Point top=queue.poll();
                if(targets.contains(top.x)) return top.y+1;

                for(int next: map.get(top.x)){
                    if(seen.add(next)){
                        queue.add(new Point(next, top.y+1));
                    }
                }
            }
            return -1;
        }

        private static void buildGraph(int [][] routes){
            int n=routes.length;
            for(int i=0;i<n;i++){
                map.putIfAbsent(i, new ArrayList<>());
                for(int j=i+1;j<n;j++){
                    map.putIfAbsent(j, new ArrayList<>());
                    if(intersect(routes[i], routes[j])){
                        map.get(i).add(j);
                        map.get(j).add(i);
                    }
                }
            }
        }

        private static boolean intersect(int [] arr1, int [] arr2){
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int i=0, j=0;
            int len1=arr1.length, len2=arr2.length;

            while(i<len1&&j<len2){
                if(arr1[i]==arr2[j]) return true;
                if(arr1[i]>arr2[j]){
                    j++;
                }else{
                    i++;
                }
            }
            return false;
        }


        static class Point{
            int x;//bus no
            int y;//numbers of bus

            Point(int x, int y){
                this.x=x;
                this.y=y;
            }
        }

    }

    public static class CanIWin {
        public static void main(String[] args) {
            canIWin(10,0);
        }
        public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if(maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return false;
            return recursive(maxChoosableInteger, new HashSet<>(), desiredTotal);
        }

        private static boolean recursive(int max, Set<Integer> visited, int target){
            if(target<=0) return false;

            boolean canWin=false;
            for(int i=1;i<=max;i++){
                if(visited.add(i)){
                    if(!recursive(max, visited, target-i)){
                        visited.remove(i);
                        return true;
                    }
                    visited.remove(i);
                }
            }
            return canWin;
        }
    }

    public static class CountVowelSubstringsOfString {
        public static void main(String[] args) {
            countVowelSubstrings("cuaieuouac");
        }


        public static int countVowelSubstrings(String word) {
            Map<Character, Integer> map=new HashMap<>();
            map.put('a', 0);
            map.put('e',0);
            map.put('i',0);
            map.put('o',0);
            map.put('u',0);

            int len=word.length();
            int vowels=5;
            int j=0;
            int i=0; int k=0;
            int result=0;
            int count=0;
            while(j<len){
                char cur=word.charAt(j);
                if(map.containsKey(cur)){
                    map.put(cur, map.get(cur)+1);
                    if(map.get(cur)==1) count++;
                    j++;

                    while(count==vowels){
                        char prev=word.charAt(k);
                        map.put(prev, map.get(prev)-1);
                        if(map.get(prev)==0) count--;
                        k++;
                    }
                    result+=k-i;
                }else{
                    map.forEach((k1, v) -> {map.put(k1, 0);});
                    count=0;
                    j++;
                    i=k=j;
                }
            }
            return result;
        }
    }
}
