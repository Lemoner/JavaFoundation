package com.lmr.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestFileFour {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("++");
		
		String path="D:\\R\\sc2Data.txt";
//		String path="D:\\R\\123.txt";
//		String path="D:\\R\\example01.txt";
		
		//BufferedReader
        FileInputStream inputStream = new FileInputStream(path);  
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));  
              
        String str;
        int index=1;
        int m,n,p,q,tc,lc;
        double T,O,D;
        int[][] a=new int[3000][1000];
        
        tc=0;lc=0;
        while((str=bufferedReader.readLine())!=null)  
        {  
        	if(!str.trim().equals("")){
        		String[] s=str.trim().split("	");
        		lc=s.length;
        		for(int i=0;i<lc;i++){
        			a[tc][i]=Integer.parseInt(s[i].trim());
        		}
        		tc++;
        	}
        }
        
        System.out.println(tc+" "+lc);
        
        for(int i=0;i<lc-1;i++){
        	m=n=p=q=0;
        	for(int j=0;j<tc;j++){
        		if(a[j][lc-1]==0&&a[j][i]==1){
        			m++;
        		}
        		else if(a[j][lc-1]==0&&a[j][i]==0){
        			n++;
        		}
        		else if(a[j][lc-1]==1&&a[j][i]==1){
        			p++;
        		}
        		else if(a[j][lc-1]==1&&a[j][i]==0){
        			q++;
        		}
        	}
        	
        	T=(m*1.0/(m+n))/((p*1.0/(p+q))+(m*1.0/(m+n)));
        	O=m*1.0/Math.sqrt((m+n)*(m+p));
        	D=m*m*m*1.0/(n+p);
        	
//        	System.out.println(i+" - "+m+" "+n+" "+p+" "+q);
        	System.out.println((i+1)+" - "+T+"\t"+O+"\t"+D);
        }
        
//        while((str=bufferedReader.readLine())!=null)  
//        {  
//        	if(!str.trim().equals("")){
//        		m=n=p=q=0;
//        		String[] s=str.trim().split("	");
////        		System.out.println(Arrays.toString(s));
//        		if(s[s.length-1].trim().equals("0")){
//        			for(int i=0;i<s.length-1;i++){
//        				if(s[i].trim().equals("0")){
//        					n++;
//        				}
//        				else{
//        					m++;
//        				}
//        			}
//        		}
//        		else{
//        			for(int i=0;i<s.length-1;i++){
//        				if(s[i].trim().equals("0")){
//        					q++;
//        				}
//        				else{
//        					p++;
//        				}
//        			}
//        		}
//        		System.out.println((index++)+" - "+m+" "+n+" "+p+" "+q);
//        	}
//        }  
              
        //close  
        inputStream.close();  
        bufferedReader.close();  
		
	}
	
}
