package com.lmr.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestOrderWrapper {

	public static void TestOne(){
		List<OrderWrapper> chinesesOrderList = new ArrayList<OrderWrapper>();    
        chinesesOrderList.add(new OrderWrapper("����80������������-1.mp3"));    
        chinesesOrderList.add(new OrderWrapper("��80������������-10.mp3"));    
        chinesesOrderList.add(new OrderWrapper("��80������������-11.mp3"));    
        chinesesOrderList.add(new OrderWrapper("��80������������-12.mp3"));    
        chinesesOrderList.add(new OrderWrapper("��80������������-13.mp3"));    
        chinesesOrderList.add(new OrderWrapper("��80������������-25.mp3"));    
        chinesesOrderList.add(new OrderWrapper("��80������������-26.mp3"));    
        chinesesOrderList.add(new OrderWrapper("��80������������-2.mp3"));    
        chinesesOrderList.add(new OrderWrapper("��80������������-3.mp3"));    
        chinesesOrderList.add(new OrderWrapper("��80������������-4.mp3"));    
        chinesesOrderList.add(new OrderWrapper("a80������������-4.mp3"));    
     
        Collections.sort(chinesesOrderList);    
  
        System.out.println("����+�������� = ");    
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
