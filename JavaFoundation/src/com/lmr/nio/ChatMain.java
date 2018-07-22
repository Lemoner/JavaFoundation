package com.lmr.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ChatMain {
	
	public static Selector selector;
	
	private static int index=1;
	private static String name;

	public static void main(String[] args) throws IOException {
		
		selector=Selector.open();
		
		ChatServer.init(selector);
		
		ChatClient.initClient("Jack");
		ChatClient.initClient("Pobl");
		
		while(true){
			
			selector.select();
			
			Set selectedKeys=selector.selectedKeys();
			Iterator it=selectedKeys.iterator();
			while(it.hasNext()){
				SelectionKey key=(SelectionKey) it.next();
				System.out.println(key.isAcceptable()+" "+key.isConnectable()+" "+key.isReadable());
				if(key.isAcceptable()){
					ServerSocketChannel ssc1=(ServerSocketChannel) key.channel();
					SocketChannel sc=ssc1.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
					
					name="clinet "+index++;
					new Thread(new ChatServerRunnable(sc, name)).start();
					System.out.println(name+" is runing ...");
					
					it.remove();
				}
				
				else if(key.isReadable()){
					
					SocketChannel sc=(SocketChannel) key.channel();
					
					ByteBuffer buff = ByteBuffer.allocate(10240);
					String msg="";
					while(sc.read(buff)>0){
						buff.flip();
						System.out.println(buff.toString());
						String line=new String(buff.array(), 0, buff.limit());;
						msg+=line;
						System.out.println("line+ "+line);
						buff.clear();
					}
					
					if(!msg.trim().equals("")){
						ChatTools.sendMessage(msg);
					}
					
					key.interestOps(SelectionKey.OP_READ); 
					
					it.remove();
					
				}
				
			}
			
		}
		
	}
	
}
