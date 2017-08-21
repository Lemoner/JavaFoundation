package com.lmr.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

	public static void main(String[] args) {
		
		try {
			InetAddress address = InetAddress.getLocalHost();
			DatagramSocket socket=new DatagramSocket();
			
			byte[] bytes = new byte[1024];
			String infor="UDPClient : Hello";
			bytes=infor.getBytes();
			DatagramPacket packet1=new DatagramPacket(bytes, bytes.length, address, 9999);
			
			socket.send(packet1);
			
			DatagramPacket packet2=new DatagramPacket(bytes, bytes.length);
			
			socket.receive(packet2);
			System.out.println("UDPClient : "+new String(bytes));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
