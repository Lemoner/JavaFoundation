package com.lmr.io;

import java.io.File;

import org.jfree.io.FileUtilities;

public class TestFileTwo {

	public static void main(String[] args) {
		
//		File f=new File("F:123.txt");
//		f.delete();
		
		String originaluppaalbaseurl="D:\\ModelDriverProjectFile\\WJXML\\飞向指定位置\\";
		
		File originaluppaalbasefile=new File(originaluppaalbaseurl);
		File[] originaluppaalbasefilelist=originaluppaalbasefile.listFiles();
		for(File f:originaluppaalbasefilelist){
			
			String fname=f.getName();
//			&&!fname.contains("-----")
			if(fname.endsWith(".xml")&&!fname.contains("ForXStream")){
			}
			System.out.println(fname);
			
		}
		System.out.println(originaluppaalbasefilelist.length);
		
	}
	
}
