package com.lmr.thread1_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestThread2 {
	
	JFrame jf;
	JPanel jp;
	JButton jb;
	
	Thread t;
	
	public static void main(String[] args) {
		TestThread2 testThread2=new TestThread2();
	}
	
	public TestThread2() {

		initUI();
		
		initThread();

	}

	private void initThread() {
		
		t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					
					for(int i=0;i<1000000;i++){
						System.out.println(i+" - - "+t.isInterrupted());
//						if(t.isInterrupted()){
//							throw new InterruptedException();
//						}
						Thread.sleep(0);
//						Thread.sleep(1000);
					}
					
				} catch (InterruptedException e) {
					System.out.println("Thread is stop "+" - - "+t.isInterrupted());
				}
				
			}
		});
		t.start();
		
	}

	private void initUI() {
		
		jf = new JFrame();
		jp = new JPanel();
		jb=new JButton();
		
		jb.setText("STOP");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t.interrupt();
			}
		});
		
		jp.add(jb);
		
		jf.add(jp);

		jf.setVisible(true);

		jf.setSize(500, 500);

		
	}
	
}
