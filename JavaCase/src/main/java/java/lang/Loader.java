package java.lang;

public class Loader extends ClassLoader{

	@Override
	public Class<?> loadClass(java.lang.String name) throws ClassNotFoundException {
		
		
		return findClass(name);
	}

	@Override
	protected Class<?> findClass(java.lang.String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.findClass(name);
	}

	
	
}
