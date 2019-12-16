package com.lmr.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	
	public static void main(String[] args) {
		String directory="E:\\Java_Swing\\src\\com\\swing";
		String keyword="JPanel";
		
		final int MAX_FILE_QUEUE_SIZE=10;//队列的长度
		final int MAX_SEARCH_THREAD_SIZE=100;//最大并发线程数
		
		BlockingQueue<File> queue=new ArrayBlockingQueue<>(MAX_FILE_QUEUE_SIZE);
		
		FileEnumerationTask enumeraor=new FileEnumerationTask(queue, new File(directory));
		new Thread(enumeraor).start();
		
		for(int i=0;i<MAX_SEARCH_THREAD_SIZE;i++){
			new Thread(new SearchTask(queue, keyword)).start();
		}
	}
	
}

class FileEnumerationTask implements Runnable{

	public static File DUMMY=new File("");//队列结束标识
	private BlockingQueue<File> queue;
	private File startingDirectory;
	
	public FileEnumerationTask(BlockingQueue<File> queue,File startingDirectory) {
		// TODO Auto-generated constructor stub
		this.queue=queue;
		this.startingDirectory=startingDirectory;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			enumerate(startingDirectory);
			queue.put(DUMMY);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enumerate(File directory) throws InterruptedException{
		File[] files=directory.listFiles();
		for(File file:files){
			if(file.isDirectory()){
				enumerate(file);
			}
			else{
				queue.put(file);//队列空间不足时，一直阻塞，直到有空间
//				queue.add(file);//队列空间不足时，直接抛出异常
			}
		}
	}
	
}

class SearchTask implements Runnable{

	private BlockingQueue<File> queue;
	private String keyword;
	
	public SearchTask(BlockingQueue<File> queue,String keyword) {
		// TODO Auto-generated constructor stub
		this.queue=queue;
		this.keyword=keyword;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		process();
	}
	
	public synchronized void process(){
		try{
			boolean done=false;
			while(!done){
				File file=queue.take();//取元素
				if(file==FileEnumerationTask.DUMMY){
					queue.put(file);
					done=true;//队列执行完结束标志
				}
				else{
					search(file);
				}
			}
		}catch (IOException | InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	public synchronized void search(File file) throws IOException{
		Scanner in=new Scanner(file);
		int lineNumber=0;
		int count=0;
		while(in.hasNextLine()){
			lineNumber++;
			String line =in.nextLine();
			if(line.contains(keyword)){
				System.out.printf("%s  -:-  %d  -:-  %s\n",file.getPath(),lineNumber,line);
				count++;
			}
		}
	}
	
}