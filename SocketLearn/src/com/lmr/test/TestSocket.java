package com.lmr.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSocket {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("10.1.16.89", 5555);
			if (socket != null) {
				System.out.println("++++++++++++++");
			}
			else{
				System.out.println("--------------");
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
