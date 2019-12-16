package com.lmr.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	private static String address="127.0.0.1";
	private static int port=8888;
	
	public static void main(String[] args) {
		
		initClient();
		
	}

	private static void initClient() {
		// TODO Auto-generated method stub
		
		try {
			Socket soc=new Socket(address, port);
			
			new Thread(new ChatClientRunnable(soc)).start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
