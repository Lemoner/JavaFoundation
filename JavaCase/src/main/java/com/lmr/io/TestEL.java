package com.lmr.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestEL {

	public static void main(String[] args) {
		
		String str=" asd123";
		Pattern part=Pattern.compile("[a-z]+[0-9]+");
		Matcher m=part.matcher(str);
		if(m.matches()){
			System.out.println(true);
		}
		else{
			System.out.println(false);
		}
		if(m.find()){
			System.out.println(true+"++");
		}
		else{
			System.out.println(false+"--");
		}
		
	}
	
}
