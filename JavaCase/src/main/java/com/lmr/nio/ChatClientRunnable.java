package com.lmr.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientRunnable implements Runnable{

	private Selector selector;
	private SocketChannel socket;
	
	private String message=null;
	private String name;
	
	public ChatClientRunnable(SocketChannel socket, Selector selector, String name) {
		// TODO Auto-generated constructor stub
		
		this.socket=socket;
		this.selector=selector;
		
		this.name=name;
		
	}
	
	@Override
	public void run(){
		// TODO Auto-generated method stub
		
		System.out.println(name+" client is connecting ... ");
		
		ChatClientUI ccu=new ChatClientUI(socket,name);
		JTextArea textarea=ccu.getTextarea();
		
		while(true){
			
			Set selectedKeys=selector.selectedKeys();
//			System.out.println("selectedKeys.size() "+selectedKeys.size());
			Iterator it=selectedKeys.iterator();
			while(it.hasNext()){
				SelectionKey key=(SelectionKey) it.next();	
				if(key.isReadable()){
					message=receiveMessage();
					System.out.println("message1 "+message);
					if(!message.trim().equals("")){
						textarea.append(message+"\n");
					}
					key.interestOps(SelectionKey.OP_READ);
//					it.remove();
				}
			}
		}
		
		
	}

	private String receiveMessage() {
		// TODO Auto-generated method stub
		
		String msg = "";
		
		ByteBuffer buff = ByteBuffer.allocate(10240);
		
		try {
			while(socket.read(buff)>0){
				buff.flip();
				String line=new String(buff.array(), 0, buff.limit());;
				msg+=line;
				System.out.println(line);
				buff.clear();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

}
