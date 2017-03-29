package com.lmr.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestServer {

	public static void main(String[] args) {
		
//		initTestEchoServer();
		
		initMoreEchoServer();
		
	}

	private static void initMoreEchoServer() {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket ss=new ServerSocket(8888);
			
			while(true){
				Socket soc=ss.accept();
				
				new Thread(new EchoServerThread(soc)).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void initTestEchoServer() {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket ss=new ServerSocket(8888);//开启一个监控端口的服务器
			
			Socket incoming=ss.accept();
			
			InputStream in=incoming.getInputStream();
			OutputStream out=incoming.getOutputStream();
			
			Scanner sc=new Scanner(in);//扫描器，用于接收客户端的输入流
			PrintWriter pw=new PrintWriter(out, true);//输出流，要设置自动刷新缓存为ture
			
			pw.println("Hello!Enter BYE to exit.");
//			pw.flush();//手动刷新缓存
			
			boolean isdone=true;
			
			while(isdone&&sc.hasNextLine()){
				String line=sc.nextLine();
				pw.println("accept :"+line);
				
				if(line.equals("BYE")){
					isdone=false;
					incoming.close();//关闭套接字
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
