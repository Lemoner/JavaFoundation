package com.lmr.thread;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestThread {
	
	JFrame jf;

	JPanel jp;
	
	JPanel jp1;
	JLabel jl1;
	Thread thread1;
	
	JPanel jp2;
	JLabel jl2;
	Thread thread2;
	
	JButton jb;
	int flag=1;

	public TestThread() {

		jf = new JFrame();
		jp = new JPanel();

		initUI();
		
		initData();

		jf.add(jp);

		jf.setVisible(true);

		jf.setSize(500, 500);

	}
	
	
	private void initData() {
		// TODO Auto-generated method stub
		
//		Mythread1 thread1=new Mythread1();
//		Mythread2 thread2=new Mythread2();
//		
//		thread1.start();
//		thread2.start();
		
		thread1=new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<100;i++){
					jl1.setText(i+"");
					try {
						sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		};
		
		thread2=new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
//				for(int i=1;i<100;i++){
//					jl2.setText("-"+i+"");
//					try {
//						sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
				
				TestMehtodOne.Method();
			}
			
		};
		
		thread1.start();
		thread2.start();
		
	}

	private void initUI() {
		// TODO Auto-generated method stub
		
		jp1=new JPanel();
		jl1=new JLabel();
		
		jp2=new JPanel();
		jl2=new JLabel();
		
		jp1.setLayout(new BorderLayout());
		jp1.add(jl1, BorderLayout.CENTER);
		
		jp2.setLayout(new BorderLayout());
		jp2.add(jl2, BorderLayout.CENTER);
		
		jb=new JButton("test");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(flag==1){
					thread1.suspend();
					thread2.suspend();
					flag=0;
				}
				else{
					thread1.resume();
					thread2.resume();
					flag=1;
				}
				
			}
		});
		
		jp.setLayout(new BorderLayout());
		jp.add(jp1, BorderLayout.NORTH);
		jp.add(jp2, BorderLayout.SOUTH);
		jp.add(jb, BorderLayout.CENTER);
		
		
	}

	public static void main(String[] args) {
		
		TestThread tt=new TestThread();
		
	}
	

}

class Mythread_1 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=1;i<100;i++){
			System.out.println(i);
		}
		
	}
	
}

class Mythread_2 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=1;i<100;i++){
			System.out.println(-i);
		}
		
	}
	
}
