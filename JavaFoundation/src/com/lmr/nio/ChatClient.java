package com.lmr.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

import com.mysql.jdbc.Buffer;

public class ChatClient {

	private static Selector selector;
	
//	private static String address="127.0.0.1";
	private static String address="localhost";
	private static int port=8888;
	
	public static void main(String[] args) {
		
//		initClient();
		
	}
	
	public static void initClient(String name) {
		// TODO Auto-generated method stub
		
		try {
			
//			selector=Selector.open();
			selector=ChatMain.selector;
			
//			SocketChannel sc=SocketChannel.open(new InetSocketAddress(address, port));
			SocketChannel sc=SocketChannel.open();
			sc.connect(new InetSocketAddress(address, port));
			sc.configureBlocking(false);
			sc.register(selector, SelectionKey.OP_CONNECT);
			
			System.out.println(sc.isConnected());
			
			new Thread(new ChatClientRunnable(sc,selector,name)).start();
			
			sc.write(ByteBuffer.wrap((name+" come on").getBytes()));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
