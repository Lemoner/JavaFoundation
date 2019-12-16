package com.lmr.thread;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//线程暂停和继续

public class TestThread_1 {
	
	JFrame jf;

	JPanel jp;
	
	JPanel jp1;
	JPanel jp2;
	
	JLabel jl1;
	JLabel jl2;
	JLabel jl3;
	
	JButton jb1;
	JButton jb2;
	JButton jb3;
	
	Thread thread1;
	Thread thread2;
	Thread thread3;
	
//	Runnable_1 thread1;
	
	Runnable_1 runnable11;
	Runnable_2 runnable1;
	
	int flag1=1;
	int flag2=1;
	int flag3=1;
	
	Object lock1=new Object();
	Object lock2;
	Object lock3;

	public TestThread_1() {

		jf = new JFrame();
		jp = new JPanel();

		initUI();
		
		initData();
		
		initThread();

		jf.add(jp);

		jf.setVisible(true);

		jf.setSize(500, 500);

	}

	private void initThread() {
		// TODO Auto-generated method stub
		
//		runnable1=new Runnable_2();
//		thread1=new Thread(runnable1);
//		thread1.start();
		
//		thread1=new Runnable_1();
		
		runnable11=new Runnable_1(){

			@Override
			protected void runPersonelLogic() {
				// TODO Auto-generated method stub
				for(int i=0;i<10;i++){
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		};
		thread1=new Thread(runnable11);
		thread1.start();
		
	}

	private void initData() {
		// TODO Auto-generated method stub
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					
//					if(runnable1.isFlag()){
//						runnable1.setFlag(false);
//						System.out.println("---------------------");
//					}
				
				runnable11.setFlag(true);
					
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
//				if(!runnable1.isFlag()){
//					runnable1.setFlag(true);
//					System.out.println("*********************");
//					synchronized (runnable1) {
//					runnable1.notify();	
//					}
//				}
				
				runnable11.setFlag(false);
				
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jl3.setText("789");
			}
		});
		
	}

	private void initUI() {
		// TODO Auto-generated method stub
		
		jl1=new JLabel();
		jl2=new JLabel();
		jl3=new JLabel();
		
		jb1=new JButton("Label1");
		jb2=new JButton("Label2");
		jb3=new JButton("Label3");
		
		jp1=new JPanel();
		jp2=new JPanel();
		
		jp1.setLayout(new GridLayout(1, 3));
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		
		jp2.setLayout(new GridLayout(1, 3));
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		
		jp.setLayout(new GridLayout(2, 1));
		jp.add(jp1);
		jp.add(jp2);
		
		
	}
	
	public static void main(String[] args) {
		
		TestThread_1 t=new TestThread_1();
		
	}

}

