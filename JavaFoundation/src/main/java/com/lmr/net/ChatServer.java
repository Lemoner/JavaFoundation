package com.lmr.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	
	private static int port=8888;

	public static void main(String[] args) {
		
		initServer();
		
	}
	
	public static void initServer(){
		
		int index=1;
		String name;
		try {
			ServerSocket ss=new ServerSocket(port);
			System.out.println("Server is start ...");
			
			while(true){
				Socket soc=ss.accept();
				name="clinet "+index++;
				new Thread(new ChatServerRunnable(soc, name)).start();
				System.out.println(name+" is runing ...");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
