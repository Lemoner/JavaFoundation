package com.lmr.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;

public class TestFrame {

	private JFrame jf;
	private JSplitPane jp;
	
	private TestFrame2 jframe1;
	private TestFrame2 jframe2;
	
	public TestFrame() {
		// TODO Auto-generated constructor stub
		
		jf=new JFrame();
		jp=new JSplitPane();
		
		initpanel();
		
		jf.getContentPane().add(jp, BorderLayout.CENTER);
		
		jf.setVisible(true);
		jf.setSize(500, 500);
		
		
	}
	
	private void initpanel() {
		// TODO Auto-generated method stub
		
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		
		initJP2();
		
		NativeInterface.open();  
		  
        SwingUtilities.invokeLater(new Runnable() {  
            public void run() {  
            	
            	jframe1=new TestFrame2();
            	jframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            	jframe1.setExtendedState(JFrame.MAXIMIZED_BOTH);  
            	jframe1.setLocationByPlatform(true);  
//            	jframe1.setVisible(true);  
            	
            	jframe2=new TestFrame2();
            	jframe2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            	jframe2.setExtendedState(JFrame.MAXIMIZED_BOTH);  
            	jframe2.setLocationByPlatform(true);  
//            	jframe2.setVisible(true);  
            }  
        });  
        NativeInterface.runEventPump();  
		
        jp1.setLayout(new GridLayout());
		
		jp2.setLayout(new GridLayout());
		jp2.add(jframe1.getContentPane());
		
		jp1.setBackground(Color.red);
		jp2.setBackground(Color.blue);
		
//		jp.setLayout(new GridLayout(2, 1));
		
//		jp.add(jp1);
//		jp.add(jp2);
		
		jp.setLeftComponent(jp1);
		jp.setRightComponent(jp2);
		jp.setDividerLocation(200);
		
		
	}

	private void initJP2() {
		// TODO Auto-generated method stub
		
		
		
		
	}

	public static void main(String[] args) {
		
		TestFrame tf=new TestFrame();
		
	}
	
}
