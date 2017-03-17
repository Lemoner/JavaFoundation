
package cn.edu.hdu.ckt.handle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class TestDFS {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileInputStream fis=new FileInputStream("D:\\qqq\\111.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		Automatic am=(Automatic) ois.readObject();
		
		System.out.println(am.toString());
		System.out.println(am.getStateSet().size());
		System.out.println(am.getTransitionSet().size());
		
		
		FileInputStream fis1=new FileInputStream("D:\\qqq\\222.txt");
		ObjectInputStream ois1=new ObjectInputStream(fis1);
		
		List<Automatic> la=(List<Automatic>) ois1.readObject();
		
		System.out.println(la.size());
		for(Automatic a:la){
			System.out.println(a.toString());
			System.out.println(a.getStateSet().size());
			System.out.println(a.getTransitionSet().size());
		}
		
	}
	
}
