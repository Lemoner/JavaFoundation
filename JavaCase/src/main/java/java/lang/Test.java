package java.lang;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Loader loader=new Loader();
		String s=(String) loader.loadClass("java.lang.String").newInstance();
		
	}
}
