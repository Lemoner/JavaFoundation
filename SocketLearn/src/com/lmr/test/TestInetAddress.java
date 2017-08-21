package com.lmr.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TestInetAddress {

	public static void main(String[] args) throws UnknownHostException {
		
		//获取本机的InetAddress实例
		InetAddress address=InetAddress.getLocalHost();
		System.out.println(address);
		System.out.println("计算机名："+address.getHostName());
		//字节数组形式的IP
		byte[] bs=address.getAddress();
		System.out.println(Arrays.toString(bs));
		
		InetAddress address2=InetAddress.getByName("10.1.16.19");
		System.out.println(address2.getHostName());
		
	}
	
}
