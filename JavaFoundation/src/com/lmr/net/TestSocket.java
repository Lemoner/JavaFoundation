package com.lmr.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestSocket {

	public static void main(String[] args) {
		
//		initSocketOne();
		
		try {
			initInetSocketAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void initInetSocketAddress() throws UnknownHostException {
		// TODO Auto-generated method stub
		
		InetAddress local=InetAddress.getLocalHost();//获取本机IP地址
		System.out.println(local);
		
//		String host="www.baidu.com";
		String host="www.google.com";
		InetAddress[] addresses=InetAddress.getAllByName(host);//获取目标主机的所有IP地址
		
		for(InetAddress a:addresses){
			System.out.println(a);
		}
		
		System.out.println(InetAddress.getByName(host));
		
	}

	private static void initSocketOne() {
		// TODO Auto-generated method stub
		
		try {
//			Socket soc=new Socket("time-A.timefreq.bldrdoc.gov", 13);
//			Socket soc=new Socket("www.baidu.com", 3306);
			
			Socket soc=new Socket();
			soc.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov", 13));//将套接字连接到指定的地址
			soc.setSoTimeout(100);//设置超时值
			
			System.out.println(soc.isConnected());//套接字是否被连接
			
			InputStream in=soc.getInputStream();
			Scanner sc=new Scanner(in);
			
			while(sc.hasNextLine()){
				String line=sc.nextLine();
				System.out.println(line);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
