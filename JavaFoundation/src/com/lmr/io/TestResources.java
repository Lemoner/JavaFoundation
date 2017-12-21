package com.lmr.io;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

public class TestResources {

	public static void main(String[] args) {
		
		String path="xxx.xml";
		URL url=Thread.currentThread().getContextClassLoader().getResource(path);
		URL url1=TestResources.class.getClassLoader().getResource(path);
		String file=url.getFile();
		
	}
	
}
