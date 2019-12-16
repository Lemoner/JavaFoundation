package com.lmr.net;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientUI{
	
	private PrintWriter pw;

	private JFrame jf;
	private JPanel jp;
	
	private JPanel editpanel;
	
	private JTextArea textarea;
	private JTextField textfield;
	private JButton button;
	
	public ChatClientUI(PrintWriter pw) {
		// TODO Auto-generated constructor stub
		
		this.pw=pw;
		
		jf=new JFrame();
		jp=new JPanel();
		
		initJPanel();
		
		jf.add(jp);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500, 500);
		jf.setVisible(true);
		
	}

	private void initJPanel() {
		// TODO Auto-generated method stub
		
		editpanel=new JPanel();
		
		textarea=new JTextArea();
		textfield=new JTextField();
		button=new JButton("SEND");
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String msg=textfield.getText();
				pw.println(msg);
				textfield.setText("");
			}
		});
		
		editpanel.setLayout(new BorderLayout());
		editpanel.add(textfield, BorderLayout.CENTER);
		editpanel.add(button, BorderLayout.EAST);
		
		jp.setLayout(new BorderLayout());
		jp.add(textarea, BorderLayout.CENTER);
		jp.add(editpanel, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
//		ChatClientUI ccu=new ChatClientUI();
	}

	public JTextArea getTextarea() {
		return textarea;
	}
	
	
}
