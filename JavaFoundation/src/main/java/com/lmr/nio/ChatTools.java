package com.lmr.nio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatTools {

	private static List<ChatServerRunnable> clientlist=new ArrayList<>();
	
	public ChatTools() {
		// TODO Auto-generated constructor stub
	}
	
	public static void addClient(ChatServerRunnable csr){
		clientlist.add(csr);
	}
	
	public static void removeClient(ChatServerRunnable csr){
		clientlist.remove(csr);
	}
	
	public static void sendMessage(String msg){
		Iterator<ChatServerRunnable> clientiterator=clientlist.iterator();
		while (clientiterator.hasNext()) {
			ChatServerRunnable csr = (ChatServerRunnable) clientiterator.next();
			csr.sendMessage(msg);
		}
	}
	
}
