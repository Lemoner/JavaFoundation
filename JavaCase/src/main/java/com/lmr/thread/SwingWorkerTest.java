package com.lmr.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.xml.soap.Text;

public class SwingWorkerTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame frame=new SwingWorkerFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class SwingWorkerFrame extends JFrame{
	private JFileChooser chooser;
	private JTextArea textArea;
	private JLabel statusLine;
	private JMenuItem openItem;
	private JMenuItem cancelItem;
	private SwingWorker<StringBuilder, ProgressData> textReader;
	public static final int TEXT_ROWS=20;
	public static final int TEXT_COLUMNS=60;
	
	public SwingWorkerFrame(){
		chooser=new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		
		textArea=new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
		add(new JScrollPane(textArea));
		
		statusLine=new JLabel(" ");
		add(statusLine,BorderLayout.SOUTH);
		
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu=new JMenu("File");
		menuBar.add(menu);
		
		openItem=new JMenuItem("Open");
		menu.add(openItem);
		
		openItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result=chooser.showOpenDialog(null);
				if(result==JFileChooser.APPROVE_OPTION){
					textArea.setText("");
					openItem.setEnabled(false);
					textReader=new TextReader(chooser.getSelectedFile());
					textReader.execute();//为工作器线程的执行预定这个工作器
					cancelItem.setEnabled(true);
				}
			}
		});
		
		cancelItem=new JMenuItem("Cancel");
		menu.add(cancelItem);
		cancelItem.setEnabled(false);
		
		cancelItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textReader.cancel(true);
			}
		});
		
		pack();
		
	}
	
	private class ProgressData{
		public int number;
		public String line;
	}

	private class TextReader extends SwingWorker<StringBuilder, ProgressData>{

		private File file;
		private StringBuilder text=new StringBuilder();
		
		public TextReader(File file){
			this.file=file;
		}
		
		@Override
		protected StringBuilder doInBackground() throws Exception {
			// TODO Auto-generated method stub
			//执行后台的任务并返回这一工作的结果
			int lineNumber=0;
			try(Scanner in=new Scanner(new FileInputStream(file))){
				while(in.hasNextLine()){
					String line=in.nextLine();
					lineNumber++;
//					text.append(line);
//					text.append("\n");
					ProgressData data=new ProgressData();
					data.number=lineNumber;
					data.line=line;
					publish(data);//传递中间进度数据到事件分配线程池，从doInBackground调用
					Thread.sleep(100);
				}
			}
			return text;
		}
		

		@Override
		public void process(List<ProgressData> data) {
			// TODO Auto-generated method stub
			//处理事件分配线程中的中间进度数据
			if(isCancelled()){
				return;
			}
//			StringBuilder b=new StringBuilder();
			statusLine.setText(""+data.get(data.size()-1).number);
//			for(ProgressData d:data){
//				b.append(d.line);
//				b.append("\n");
//			}
//			textArea.append(b.toString());
			textArea.append(data.get(data.size()-1).line.toString());
			textArea.append("\n");
		}

		@Override
		protected void done() {
			// TODO Auto-generated method stub
			try{
				StringBuilder result=get();
				textArea.append("*******"+result.toString());
				textArea.append("*****---------****");
				statusLine.setText("Done");
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			cancelItem.setEnabled(false);
			openItem.setEnabled(true);
		}
		
	}
	
}



