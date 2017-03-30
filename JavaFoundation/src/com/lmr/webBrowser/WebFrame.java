package com.lmr.webBrowser;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class WebFrame extends JFrame{
	
	private JPanel webBrowserPanel;  
	  
    private JWebBrowser webBrowser;  
  
     private String url; 

	public WebFrame() {
		// TODO Auto-generated constructor stub
		
//		String url = "http://demo.mycodes.net/houtai/H-ui.admin/";  
		String url="http://www.baidu.com";
		
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
