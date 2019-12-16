package com.lmr.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestOrderWrapper {

	public static void TestOne(){
		List<OrderWrapper> chinesesOrderList = new ArrayList<OrderWrapper>();    
        chinesesOrderList.add(new OrderWrapper("我们80后相亲奇遇记-1.mp3"));    
        chinesesOrderList.add(new OrderWrapper("他80后相亲奇遇记-10.mp3"));    
        chinesesOrderList.add(new OrderWrapper("我80后相亲奇遇记-11.mp3"));    
        chinesesOrderList.add(new OrderWrapper("啊80后相亲奇遇记-12.mp3"));    
        chinesesOrderList.add(new OrderWrapper("我80后相亲奇遇记-13.mp3"));    
        chinesesOrderList.add(new OrderWrapper("我80后相亲奇遇记-25.mp3"));    
        chinesesOrderList.add(new OrderWrapper("我80后相亲奇遇记-26.mp3"));    
        chinesesOrderList.add(new OrderWrapper("我80后相亲奇遇记-2.mp3"));    
        chinesesOrderList.add(new OrderWrapper("我80后相亲奇遇记-3.mp3"));    
        chinesesOrderList.add(new OrderWrapper("我80后相亲奇遇记-4.mp3"));    
        chinesesOrderList.add(new OrderWrapper("a80后相亲奇遇记-4.mp3"));    
     
        Collections.sort(chinesesOrderList);    
  
        System.out.println("中文+数字排序： = ");    
        for (int i = 0; i < chinesesOrderList.size(); i++) {    
            OrderWrapper chinese = chinesesOrderList.get(i);    
            System.out.println("" + chinese);    
        } 
	}
	
	public static void TestTwo(){
		
		String[] names = new String[3];
		names[0]="result_Performance_10.txt";
		names[1]="result_Performance_8.txt";
		names[2]="result_Performance_9.txt";
		
		List<OrderWrapper> namelist=new ArrayList<>();
		
		for(String name:names){
			namelist.add(new OrderWrapper(name));
		}
		
		Collections.sort(namelist);
		
		for(OrderWrapper s:namelist){
			System.out.println(s);
		}
		
		
	}
	
	public static void main(String[] args) {
		
//		TestOne();
		TestTwo();
		
	}
	
}
