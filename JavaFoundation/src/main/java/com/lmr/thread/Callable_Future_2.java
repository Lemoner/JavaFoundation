package com.lmr.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Callable_Future_2 {

	public static void main(String[] args) {
		String directory="E:\\Java_Swing\\src\\com\\swing";
		String keyword="JPanel";
		
		MatchCount counter=new MatchCount(new File(directory), keyword);
		FutureTask<Integer> task=new FutureTask<>(counter);
		Thread t=new Thread(task);
		t.start();
		try {
			System.out.println("-------------  "+task.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

class MatchCount implements Callable<Integer>{

	private File directory;
	private String keyword;
	private int count;//关键字数目
	
	public MatchCount(File directory,String keyword) {
		// TODO Auto-generated constructor stub
		this.directory=directory;
		this.keyword=keyword;
	}
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		
		count=0;
		try{
			File[] files=directory.listFiles();
			List<Future<Integer>> results=new ArrayList<>();//Future对象List
			
			for(File file:files){
				if(file.isDirectory()){
					MatchCount counter=new MatchCount(file, keyword);//递归遍历
					FutureTask<Integer> task=new FutureTask<>(counter);
					results.add(task);
					Thread t=new Thread(task);
					t.start();
				}
				else{
					if(search(file)){//若是文件，则去计算数目
						count+=searchsum(file);
					}
				}
			}
			for(Future<Integer> result:results){//当该目录下所有文件的Future计算完后，累加数目
				count+=result.get();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	
	public boolean search(File file){//判断文件是否有关键字
		try{
			Scanner in=new Scanner(file);
			boolean found=false;
			while(!found&&in.hasNextLine()){
				String line=in.nextLine();
				if(line.contains(keyword)){
					found=true;
				}
			}
			return found;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public int searchsum(File file) throws FileNotFoundException {//关键字计数
		Scanner in = new Scanner(file);
		int found = 0;
		while (in.hasNextLine()) {
			String line = in.nextLine();
			while (line.contains(keyword)) {
				System.out.println(line);
				line=line.substring(line.indexOf(keyword)+keyword.length());
				found++;
			}
		}
		return found;
	}

}
