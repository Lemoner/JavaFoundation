package com.lmr.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) {
		
		try {
			DatagramSocket socket=new DatagramSocket(9999);
			System.out.println("*************UDPServer************");
			
			byte[] bytes = new byte[1024];
			DatagramPacket packet1=new DatagramPacket(bytes, bytes.length);
			
			socket.receive(packet1);
			System.out.println("UDPServer : "+new String(bytes));
			
			InetAddress address=packet1.getAddress();
			int port=packet1.getPort();
			
			String infor="UDPServer : Hello";
			bytes=infor.getBytes();
			DatagramPacket packet2=new DatagramPacket(bytes, bytes.length, address, port);
			socket.send(packet2);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
