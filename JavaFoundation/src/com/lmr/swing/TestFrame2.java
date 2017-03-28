package com.lmr.swing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class TestFrame2 extends JFrame{

	private JPanel jp;
	
	private JPanel webBrowserPanel;  
	  
    private JWebBrowser webBrowser;
	
	public TestFrame2() {
		// TODO Auto-generated constructor stub
		
//		jp=new JPanel();
//		jp.setBackground(Color.gray);
//		
//		add(jp);
		
		init();
		
	}

	private void init() {
		// TODO Auto-generated method stub
		final String url = "http://www.baidu.com"; 
		
		webBrowserPanel = new JPanel(new BorderLayout());  
        webBrowser = new JWebBrowser();  
        webBrowser.navigate(url);  
        webBrowser.setButtonBarVisible(false);  
        webBrowser.setMenuBarVisible(false);  
        webBrowser.setBarsVisible(false);  
        webBrowser.setStatusBarVisible(false);  
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);  
        add(webBrowserPanel, BorderLayout.CENTER);
		
	}
	
	
}
