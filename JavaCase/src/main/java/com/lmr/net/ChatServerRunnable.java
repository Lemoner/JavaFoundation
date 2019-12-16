package com.lmr.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatServerRunnable implements Runnable{

	private Socket socket;
	private String name;
	
	private InputStream in;
	private OutputStream out;
	
	private Scanner sc;
	private PrintWriter pw;
	
	public ChatServerRunnable(Socket socket, String name) {
		// TODO Auto-generated constructor stub
		
		this.socket=socket;
		this.name=name;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			in=socket.getInputStream();
			out=socket.getOutputStream();
			
			sc=new Scanner(in);
			pw=new PrintWriter(out,true);
			
			ChatTools.addClient(this);
			
			pw.println("Hello!Enter BYE to exit.");
			
			ChatTools.sendMessage(name+" is connecting");
			
			boolean isdone=true;
		
			while(isdone&&sc.hasNextLine()){
				String line=sc.nextLine();
				ChatTools.sendMessage(name+" : "+line);
				System.out.println(line);
				
				if(line.equals("BYE")){
					isdone=false;
				}
				
			}
			
			ChatTools.removeClient(this);
			
			in.close();
			out.close();
			
			sc.close();
			pw.close();
			
			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void sendMessage(String msg){
		
		pw.println(msg);
		
	}

}
