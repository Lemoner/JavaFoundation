package com.lmr.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Comparator;

public class TestFileThree {

	public static void main(String[] args) throws IOException {

//		fun2();
		fun3();

		// String s="";

	}

	public static void fun3() throws IOException {
		
		String rpath="";
		
		File allFile=new File("");
		
		for(File sfile:allFile.listFiles()){
			
			if(sfile.isDirectory()){
				
				String srpath = rpath+sfile.getName()+".txt";
				File srfile=new File(srpath);
				while(!srfile.exists()){
					srfile.createNewFile();
				}
				BufferedWriter writer = new BufferedWriter(new FileWriter(srfile, true));
				
				File[] files=sfile.listFiles();
				Arrays.sort(files, new Comparator<File>() {

					@Override
					public int compare(File o1, File o2) {
						
						int f1,f2;
						f1=Integer.parseInt(o1.getName().split("\\.")[2]);
						f2=Integer.parseInt(o2.getName().split("\\.")[2]);
						
						return f1-f2;
					}
				});
				
				for(File file:files){
					FileInputStream inputStream = new FileInputStream(file);
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

					String str;

					while ((str = bufferedReader.readLine()) != null) {
						if (str.length() == 1) {
							continue;
						}
						StringBuilder sb = new StringBuilder();
						for (char c : str.toCharArray()) {
							if (c != 0) {
								sb.append(c);
							}
						}
						str = sb.toString();
						String[] s = str.split("\\:");
						if(!s[0].trim().equals("-")){
							if(s[0].contains("#")){
								System.out.println("0");
								writer.write("0 ");
							}
							else{
								System.out.println(s[0].trim());
								writer.write(s[0].trim()+" ");
							}
						}

					}
					
					writer.write("\n");
					writer.flush();

					inputStream.close();
					bufferedReader.close();
				}

				writer.close();
				
			}
			
		}
		
	}

	public static void fun2() throws IOException {

		String path = "D:\\R\\结果1.txt";

		FileInputStream inputStream = new FileInputStream(path);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		String str;

		while ((str = bufferedReader.readLine()) != null) {
			// System.out.println(str.replaceAll("\\t", ""));
			if (str.length() == 1) {
				continue;
			}
			StringBuilder sb = new StringBuilder();
			for (char c : str.toCharArray()) {
				if (c != 0) {
					sb.append(c);
				}
			}
			str = sb.toString();
			String[] s = str.split("\\|");
			// System.out.println(s.length);
			if (!s[2].trim().equals(s[5].trim())) {
				System.out.println(s[1].trim() + " 1");
			} else {
				System.out.println(s[1].trim() + " 0");
			}

		}

		inputStream.close();
		bufferedReader.close();

	}

	public static void fun1() throws IOException {
		String path2 = "D:\\R\\runall.sh";
		String path1 = "D:\\R\\runall1.test.sh";
		String path3 = "D:\\R\\tt.sh";

		new File(path3).createNewFile();
		new File(path3).delete();
		new File(path3).createNewFile();

		String result1 = readToString(path1);

		// BufferedReader是可以按行读取文件
		FileInputStream inputStream = new FileInputStream(path2);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path3), true));

		writer.write(bufferedReader.readLine());
		String str;
		int index = 1;
		while ((str = bufferedReader.readLine()) != null) {
			writer.write("\n" + str);

			String s = bufferedReader.readLine();

			System.out.println(s);

			String s1, s2, s3, s4;

			if (s.indexOf("exe ") + 4 > s.indexOf("  < ..")) {
				s1 = "";
			} else {
				s1 = s.substring(s.indexOf("exe ") + 4, s.indexOf("  < .."));
			}
			s2 = s.substring(s.indexOf("/input/") + 6, s.indexOf(" > .."));

			s3 = result1.replace("7 1 9", s1);
			s4 = s3.substring(0, s3.indexOf("/input/") + 6) + s2 + s3.substring(s3.indexOf(" > /home"));

			writer.write("\n#" + s);
			writer.write("\ncount=" + index++);
			writer.write("\n" + s4);
			// if(index>100){
			// break;
			// }
		}

		// close
		inputStream.close();
		bufferedReader.close();

		writer.close();
	}

	public static String readToString(String fileName) {
		String encoding = "UTF-8";
		File file = new File(fileName);
		Long filelength = file.length();
		byte[] filecontent = new byte[filelength.intValue()];
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return new String(filecontent, encoding);
		} catch (UnsupportedEncodingException e) {
			System.err.println("The OS does not support " + encoding);
			e.printStackTrace();
			return null;
		}
	}

}
