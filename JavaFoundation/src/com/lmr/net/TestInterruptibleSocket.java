package com.lmr.net;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestInterruptibleSocket {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				JFrame frame=new InterruptibleSocketFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
		});
		
	}
	
}

class InterruptibleSocketFrame extends JFrame{
	
	public static final int rows=20;
	public static final int columns=60;
	
	private Scanner in;
	private JButton interruptibleButton;
	private JButton blockingButton;
	private JButton cancelButton;
	private JTextArea messages;
	private TestSocketServer server;
	private Thread connectThread;
	
	public InterruptibleSocketFrame() {
		// TODO Auto-generated constructor stub
		
		JPanel northPanel=new JPanel();
		add(northPanel, BorderLayout.NORTH);
		
		messages=new JTextArea(rows, columns);
		add(new JScrollPane(messages));
		
		interruptibleButton=new JButton("Interruptible");
		blockingButton=new JButton("Blocking");
		cancelButton=new JButton("Cancel");
		northPanel.add(interruptibleButton);
		northPanel.add(blockingButton);
		northPanel.add(cancelButton);
		
		interruptibleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				interruptibleButton.setEnabled(false);
				blockingButton.setEnabled(false);
				cancelButton.setEnabled(true);
				
				connectThread=new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						connectInterruptibly();
					}
				});
				
				connectThread.start();
				
			}
		});
		
		blockingButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				interruptibleButton.setEnabled(false);
				blockingButton.setEnabled(false);
				cancelButton.setEnabled(true);
				
				connectThread=new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						connectBlocking();
					}
				});
				
				connectThread.start();
				
			}
		});
		
		cancelButton.setEnabled(false);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				connectThread.interrupt();
				cancelButton.setEnabled(false);
			}
		});
		
		server=new TestSocketServer();
		new Thread(server).start();
		
		pack();
		
	}
	
	public void connectInterruptibly(){
		
		messages.append("Interruptibe:\n");
		try {
			
			InetSocketAddress address=new InetSocketAddress("localhost", 8888);
			SocketChannel channel=SocketChannel.open(address);
			
			in=new Scanner(channel);
			
			while(!Thread.currentThread().isInterrupted()){
				messages.append("Reading ");
				if(in.hasNextLine()){
					String line=in.nextLine();
					messages.append(line);
					messages.append("\n");
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			EventQueue.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					messages.append("Channel closed\n");
					interruptibleButton.setEnabled(true);
					blockingButton.setEnabled(true);
				}
			});
		}
		
	}
	
	public void connectBlocking(){
		messages.append("Blocking:\n");
		
		try {
			
			Socket sock=new Socket("localhost", 8888);
			
			in=new Scanner(sock.getInputStream());
			
			while(!Thread.currentThread().isInterrupted()){
				messages.append("Reading ");
				if(in.hasNextLine()){
					String line=in.nextLine();
					messages.append(line);
					messages.append("\n");
				}
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					messages.append("Socket closed\n");
					interruptibleButton.setEnabled(true);
					blockingButton.setEnabled(true);
				}
			});
		}
	}

	class TestSocketServer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			try {
				
				ServerSocket s=new ServerSocket(8888);
				
				while(true){
					Socket incoming=s.accept();
					Runnable r=new TestSocketServerHandler(incoming);
//					Runnable r=new EchoServerThread(incoming);
					Thread t=new Thread(r);
					t.start();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				messages.append("");
			}
			
		}
		
	}

	class TestSocketServerHandler implements Runnable{

		private Socket incoming;
		private int counter;
		
		public TestSocketServerHandler(Socket i) {
			// TODO Auto-generated constructor stub
			
			incoming=i;
			
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			try{
				
				OutputStream outStream=incoming.getOutputStream();
				PrintWriter pw=new PrintWriter(outStream,true);
				
				while(counter<100){
					counter++;
					if(counter<=10){
						pw.println(counter);
					}
					Thread.sleep(100);
				}
				incoming.close();
				
			}catch (Exception e) {
				// TODO: handle exception
			}finally {
				messages.append("Closing server\n");
			}
			
		}
		
	}

}


