package com.lmr.collection;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args) {
//		initQueue();
		
		initPriorityQueue();
	}
	
	public static void initQueue(){
		
//		Queue<Integer> qA=new ArrayDeque<>();
//		Queue<Integer> qL=new LinkedList<>();
		
		List<Integer> ll=new LinkedList<>();
		for(int i=0;i<10;i++){
			ll.add(i);
		}
		
		Iterator<Integer> ii=ll.iterator();
//		ii.next();
		ii.remove();
//		ii.remove();
		
		System.out.println(ii.next());
		
	}
	
	public static void initPriorityQueue(){
		
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
		pq.add(2);
		pq.add(4);
		pq.add(5);
		pq.add(1);
		pq.add(0);
		pq.add(6);
		
//		for(Integer i:pq){
//			System.out.println(i);
//		}
		
		System.out.println(pq);

		pq.remove();

		System.out.println(pq);

		pq.remove();

		System.out.println(pq);
		
		
	}
}
