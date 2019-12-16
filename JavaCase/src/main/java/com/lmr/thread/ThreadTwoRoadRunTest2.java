package com.lmr.thread;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThreadTwoRoadRunTest2 {
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
	
	int index;
	
	private Object mainlock=new Object();
	private Boolean mainflag = true;
	
	Callable<Integer> maincallable;
	FutureTask<Integer> maintask;
	Thread mainthread;
	
	SecondaryCallable_1 callable1;
	FutureTask<Integer> task1;
	Thread thread1;
	SecondaryCallable_1 callable2;
	FutureTask<Integer> task2;
	Thread thread2;
	SecondaryCallable_1 callable3;
	FutureTask<Integer> task3;
	Thread thread3;
	
	public ThreadTwoRoadRunTest2() {

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
		
		maincallable=new Callable<Integer>() {
			
			
			
			
//			public Boolean getFlag() {
//				return flag;
//			}

//			public void setFlag(Boolean flag) {
//				
//				if(flag){
//					synchronized (lock) {
//						lock.notify();
//					}
//				}
				
//				this.flag = flag;
//			}
			
			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				synchronized (mainlock) {
					while (index <= 100) {
						if (!mainflag) {
							try {
								mainlock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if (index < 20) {
							jl1.setText("" + index++);
						} else if (index == 20) {
							if (task1.isDone()) {
								jl1.setText("" + index++);
								thread2.start();
							}
						} else if (index < 50) {
							jl1.setText("" + index++);
						} else if (index == 50) {
							if (task2.isDone()) {
								jl1.setText("" + index++);
								thread3.start();
							}
						} else if (index < 100) {
							jl1.setText("" + index++);
						} else if (index == 100) {
							if (task3.isDone()) {
								jl1.setText("all is done" + index++);
							}
						}

						Thread.sleep(100);
					}
				}
				
				return 1;
			}
		};
		maintask=new FutureTask<>(maincallable);
		mainthread=new Thread(maintask);
		
		
		callable1=new SecondaryCallable_1(0, 20);
		task1=new FutureTask<>(callable1);
		thread1=new Thread(task1);
		callable2=new SecondaryCallable_1(20, 50);
		task2=new FutureTask<>(callable2);
		thread2=new Thread(task2);
		callable3=new SecondaryCallable_1(50, 100);
		task3=new FutureTask<>(callable3);
		thread3=new Thread(task3);
		
		
	}

	private void initData() {
		// TODO Auto-generated method stub
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				mainthread.start();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				thread1.start();
				
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainflag=false;
				
				if(index<=20){
//					thread1.interrupt();
					callable1.setFlag(false);
				}
				else if(index<=50){
//					thread2.interrupt();
					callable2.setFlag(false);
				}
				else{
//					thread3.interrupt();
					callable3.setFlag(false);
				}
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				mainthread.resume();
				mainflag=true;
				if(mainflag){
					synchronized (mainlock) {
						mainlock.notify();
					}
				}
				if(index<20){
//					thread1.resume();
					callable1.setFlag(true);
				}
				else if(index<50){
//					thread2.resume();
					callable2.setFlag(true);
				}
				else{
//					thread3.resume();
					callable3.setFlag(true);
				}
//				if(index<20){
//					thread1.start();
//				}
//				else if(index<50){
//					thread2.start();
//				}
//				else{
//					thread3.start();
//				}
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
		
		ThreadTwoRoadRunTest2 t=new ThreadTwoRoadRunTest2();
		
	}

}

//class MainCallable implements Callable<Integer>{
//
//	@Override
//	public Integer call() throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//}

class SecondaryCallable_1 implements Callable<Integer>{

	private int start;
	private int end;
	private int result=0;
	
	private Boolean flag = true;
	private Object lock=new Object();
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		
		if(flag){
			synchronized (lock) {
				lock.notify();
			}
		}
		
		this.flag = flag;
	}
	
	public SecondaryCallable_1(int start,int end) {
		// TODO Auto-generated constructor stub
		this.start=start;
		this.end=end;
	}
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
//		while(true){
		synchronized (lock) {//该线程的锁是Object类型的lock变量
			
			for(int i=start;i<end;i++){
				if(!flag){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(i);
				Thread.sleep(500);
			}
			
		}
		
		result=1;
		return result;
//		}
	}
	
}

