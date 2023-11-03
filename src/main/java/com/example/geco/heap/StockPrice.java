package com.example.geco.heap;

import java.util.PriorityQueue;
import java.util.TreeMap;

class StockPrice {
    TreeMap<Integer, Integer> map;
    PriorityQueue<Stock> minHeap;
    PriorityQueue<Stock> maxHeap;

    public StockPrice() {
        map=new TreeMap<>();
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>( (s1,s2)->(s2.price - s1.price));
    }

    public void update(int timestamp, int price) {
        Stock stock=new Stock(timestamp, price);
        map.put(timestamp, price);

        minHeap.offer(stock);
        maxHeap.offer(stock);
    }

    public int current() {
        return map.lastEntry().getValue();
    }

    public int maximum() {
        while(!maxHeap.isEmpty()){
            Stock s=maxHeap.peek();
            if(map.get(s.timestamp)!=s.price){
                maxHeap.poll();
            }else{
                return maxHeap.poll().price;
            }
        }
        return 0;
    }

    public int minimum() {
        while(!minHeap.isEmpty()){
            Stock s=maxHeap.peek();
            if(map.get(s.timestamp)!=s.price){
                minHeap.poll();
            }else{
                return maxHeap.poll().price;
            }
        }
        return 0;
    }


    class Stock{
        public int timestamp;
        public int price;

        Stock(int timestamp, int price){
            this.timestamp=timestamp;
            this.price=price;
        }

    }
}
