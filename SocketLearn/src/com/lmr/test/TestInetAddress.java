package com.lmr.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TestInetAddress {

	public static void main(String[] args) throws UnknownHostException {
		
		//��ȡ������InetAddressʵ��
		InetAddress address=InetAddress.getLocalHost();
		System.out.println(address);
		System.out.println("���������"+address.getHostName());
		//�ֽ�������ʽ��IP
		byte[] bs=address.getAddress();
		System.out.println(Arrays.toString(bs));
		
		InetAddress address2=InetAddress.getByName("10.1.16.19");
		System.out.println(address2.getHostName());
		
	}
	
}
