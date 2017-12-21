package com.lmr.xml.read;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMRead {
	
	public void XMLParser(){
		
		String name="books.xml";
		String path=Thread.currentThread().getContextClassLoader().getResource(name).getPath();
		
		try{
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			
			Document document=db.parse(path);
			
			NodeList nodeList=document.getElementsByTagName("book");
			System.out.println(nodeList.getLength());
			for(int i=0;i<nodeList.getLength();i++){
				System.out.println("----------------");
				Node node=nodeList.item(i);
				System.out.println(node.getNodeName());
				NamedNodeMap attributes=node.getAttributes();
				System.out.println("----Attribute");
				for(int j=0;j<attributes.getLength();j++){
					Node attrinode=attributes.item(j);
					System.out.println(attrinode.getNodeName()+" : "+attrinode.getNodeValue());
				}
				System.out.println("----ChildNode");
				NodeList childNodeList=node.getChildNodes();
				for(int j=0;j<childNodeList.getLength();j++){
					Node childNode=childNodeList.item(j);
					if(childNode.getNodeType()==Node.ELEMENT_NODE){
						System.out.println(childNode.getNodeName()+" : "+childNode.getTextContent());
					}
				}
			}
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
	}

	public static void main(String[] args){
		
		DOMRead read=new DOMRead();
		
		read.XMLParser();
		
	}
	
}
