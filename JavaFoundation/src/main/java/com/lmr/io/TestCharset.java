package com.lmr.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

public class TestCharset {

	final static String str="I am ĮȻ ��";
	
	public static void main(String[] args) {
		
//		EnOrDe();
		Encode();
		
		
	}

	private static void Encode() {
		
		try {
			byte[] iso=str.getBytes("ISO-8859-1");
			System.out.println(Arrays.toString(iso));
			byte[] gb2312=str.getBytes("GB2312");
			System.out.println(Arrays.toString(gb2312));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private static void EnOrDe() {

		Charset charset=Charset.forName("UTF-8");
		
		System.out.println(str.length());
		System.out.println(str);
		
		ByteBuffer byteBuffer=charset.encode(CharBuffer.wrap(str));
		byte[] bytes=byteBuffer.array();
		System.out.println(bytes.length);
		System.out.println(Arrays.toString(bytes));
		
		CharBuffer charBuffer=charset.decode(ByteBuffer.wrap(bytes));
		char[] chars=charBuffer.array();
		System.out.println(chars.length);
		System.out.println(Arrays.toString(chars));
		
	}
	
}
