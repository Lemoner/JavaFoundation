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
			
			Scanner sc=new Scanner(in);//ɨ���������ڽ��տͻ��˵�������
			PrintWriter pw=new PrintWriter(out, true);//�������Ҫ�����Զ�ˢ�»���Ϊture
			
			pw.println("Hello!Enter BYE to exit.");
//			pw.flush();//�ֶ�ˢ�»���
			
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
		}//�ر��׽���
		
	}

}
