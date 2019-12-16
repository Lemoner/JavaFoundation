package com.lmr.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFileOne {

	public static void main(String[] args) {
		String headpath="D:\\TestIOData\\";
		AllFiles(headpath);
	}
	
	public static void AllFiles(String s){
		Path path=Paths.get(s);
		try {
			DirectoryStream<Path> allpaths=Files.newDirectoryStream(path);
			
			for(Path p:allpaths){
				System.out.println(p);
				
				TestByteStream.FileInputMethod(p.toString());
				
				System.out.println("----------------------------------------------------------");
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
