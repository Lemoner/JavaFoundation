package com.lmr.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientRunnable implements Runnable{

	private Socket socket;
	
	private InputStream in;
	private OutputStream out;
	
	private Scanner sc;
	private PrintWriter pw;
	
	private String message=null;
	
	public ChatClientRunnable(Socket socket) {
		// TODO Auto-generated constructor stub
		
		this.socket=socket;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			in=socket.getInputStream();
			out=socket.getOutputStream();
			
			sc=new Scanner(in);
			pw=new PrintWriter(out,true);
			
			System.out.println("client is connecting ... "); 
			
			ChatClientUI ccu=new ChatClientUI(pw);
			JTextArea textarea=ccu.getTextarea();
			
			while(true){
				message=receiveMessage();
//				System.out.println("client - - - - "+message);
				
				textarea.append(message+"\n");
				
//				sendMessage();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void sendMessage() {
		// TODO Auto-generated method stub
		
		Random rand=new Random();
		String msg=null;
		
		for(int i=0;i<10;i++){
			msg +='a'+rand.nextInt(26);
		}
		
		pw.println(msg);
		
	}

	private String receiveMessage() {
		// TODO Auto-generated method stub
		
		String msg = null;
		msg=sc.nextLine();
		return msg;
	}

}
