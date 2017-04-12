package com.lmr.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class TestCopy {

	public static void main(String[] args) {

		String sourcepath="D:\\FileData\\TestXml\\UAVForXStream3.1.6.xml";
		String targetpath="D:\\FileData\\TestXml\\copy.xml";
		
		ACopyToB(sourcepath, targetpath);
		
	}

	private static void ACopyToB(String sourcepath, String targetpath) {
		// TODO Auto-generated method stub
		
		File sourcefile=new File(sourcepath);
		File targetfile=new File(targetpath);
		
		try {
			SAXReader saxReader = new SAXReader(); // 用来读取xml文档
			Document document = saxReader.read(sourcefile);
			
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");//指定编码
			
			XMLWriter writer = new XMLWriter(new FileOutputStream(targetfile), format);
			writer.write(document);
			writer.flush();
			writer.close();
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
