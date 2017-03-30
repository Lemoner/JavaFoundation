package com.lmr.webBrowser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;

public class TestStartPanel {
	
	private JFrame jf;
	private JPanel jp;
	
	private JPanel jp1;
	private JPanel jp2;
	
	private WebFrame webframe;

	public TestStartPanel() {
		// TODO Auto-generated constructor stub
		
		jf=new JFrame();
		jp=new JPanel();
		
		jp1=new JPanel();
		jp2=new JPanel();
		
		initpanel();
		
		jf.add(jp);
		jf.setSize(500, 500);
		jf.setVisible(true);
		
	}
	
	private void initpanel() {
		// TODO Auto-generated method stub
		
		jp1.setBackground(Color.BLUE);
		
		initJPanel2();
		
		jp.setLayout(new GridLayout(2, 1));
		jp.add(jp1);
		jp.add(jp2);
		
	}

	private void initJPanel2() {
		// TODO Auto-generated method stub
		
		NativeInterface.open();  
		  
        SwingUtilities.invokeLater(new Runnable() {  
            public void run() {  
            	webframe = new WebFrame();
//            	webframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//            	webframe.setExtendedState(JFrame.MAXIMIZED_BOTH);  
//            	webframe.setLocationByPlatform(true);  
//            	webframe.setVisible(true);  
            }  
        });  
        NativeInterface.runEventPump();  
        
        jp2.setLayout(new GridLayout());
        jp2.add(webframe.getContentPane());
		
	}

	public static void main(String[] args) {
		
		TestStartPanel tsp=new TestStartPanel();
		
	}
	
}
