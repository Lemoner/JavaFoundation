package com.lmr.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ChatServerRunnable implements Runnable{

	private SocketChannel socket;
	private String name;
	
	public ChatServerRunnable(SocketChannel socket, String name) {
		// TODO Auto-generated constructor stub
		
		this.socket=socket;
		this.name=name;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			ChatTools.addClient(this);
			
			socket.write(ByteBuffer.wrap("Hello!Enter BYE to exit.".getBytes()));
//			
//			ChatTools.sendMessage(name+" is connecting");
			
//			ByteBuffer buff = ByteBuffer.allocate(10240);
//		
//			while(socket.read(buff)!=-1){
//				String line=new String(buff.array(), 0, buff.position());;
//				ChatTools.sendMessage(name+" : "+line);
//				System.out.println("line "+line);
//				buff.clear();
//				
//				if(line.equals("BYE")){
//					break;
//				}
//				
//			}
//			
//			ChatTools.removeClient(this);
//			
//			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void sendMessage(String msg){
		
		try {
			socket.write(ByteBuffer.wrap(msg.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
