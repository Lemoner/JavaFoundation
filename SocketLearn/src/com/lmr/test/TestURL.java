package com.lmr.test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {

	public static void main(String[] args) {
		
		try {
			URL url=new URL("http://www.baidu.com");
			
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
