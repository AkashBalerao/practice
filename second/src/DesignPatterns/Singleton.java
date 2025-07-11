package DesignPatterns;

import java.io.*;

class Box implements Serializable{
	private static Box box;
	
	int num = 10;
	
	private Box() {};
	
	public static Box getBox()
	{
		if(box == null)
		{
			box = new Box();
		}
		return box;
	}
	
//	public Object readResolve()
//	{
//		return box; 
//	}
}

public class Singleton {
	public static void main(String [] args) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Box b1 = Box.getBox();
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("abc.txt")));
		
		oos.writeObject(b1);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("abc.txt")));
		
		Box b2 = (Box)ois.readObject();
		
		System.out.println(b1==b2);
	}
}
