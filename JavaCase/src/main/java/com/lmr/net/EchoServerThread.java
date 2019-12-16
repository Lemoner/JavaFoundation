package com.lmr.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoServerThread implements Runnable{

	private Socket soc;
	
	public EchoServerThread(Socket soc) {
		// TODO Auto-generated constructor stub
		this.soc=soc;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			InputStream in=soc.getInputStream();
			OutputStream out=soc.getOutputStream();
			
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
				}
				
			}
			
			soc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//关闭套接字
		
	}

}
