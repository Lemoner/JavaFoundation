package com.lmr.thread;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Callable_Future_Panel {

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
	
	ExecutorService exector;
	Callable_1 callable1;
	Future<Integer> result;
	
	public Callable_Future_Panel() {

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
		
		exector=Executors.newCachedThreadPool();
		callable1=new Callable_1();
		result=exector.submit(callable1);
		exector.shutdown();
		
	}

	private void initData() {
		// TODO Auto-generated method stub
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					jl1.setText(result.get()+"");
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExecutionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				jl2.setText(result.isDone()+"");
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				result.cancel(true);
				jl3.setText(result.isCancelled()+"");
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
		
		Callable_Future_Panel t=new Callable_Future_Panel();
		
	}

	
}
