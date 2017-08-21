package com.lmr.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args){
		
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("***********TCPServer***********");
			
			Socket socket=serverSocket.accept();
			InputStream input=socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(input));
			String infor=null;
			while((infor=reader.readLine())!=null){
				System.out.println("TCPServer : "+infor);
			}
			
			socket.shutdownInput();
			
			PrintWriter writer=new PrintWriter(out);
			writer.println("TCPServer : Hello "+socket.getInetAddress());
			writer.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
