package com.lmr.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args){
		
		Socket socket;
		try {
			socket = new Socket("localhost", 9999);
			InputStream input=socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			
			PrintWriter writer=new PrintWriter(out);
			writer.println("TCPClient : Hello ");
			writer.flush();
			
			socket.shutdownOutput();
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(input));
			String infor=null;
			while((infor=reader.readLine())!=null){
				System.out.println("TCPClient : "+infor);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
