package DesignPatterns;

import java.util.*;

interface Storage{
	void add(Storage m);
	void delete();
	void displayStorage(String s);
}

class Mug implements Storage{
	
	String name;
	Mug(String name)
	{
		this.name = name;
	}
	public void add(Storage m)
	{
		System.out.println("Cant add anything to mug");
	}
	
	public void delete()
	{
		System.out.println("Cant delete a mug");
	}
	
	public void displayStorage(String indent) {
        System.out.println(indent + "File: " + name);
    }
}

class Bucket implements Storage{
	ArrayList<Storage> mugs = new ArrayList<>();
	
	String name;
	
	Bucket(String name)
	{
		this.name = name;
	}

	@Override
	public void add(Storage m) {
		mugs.add(m);
	}

	@Override
	public void delete() {
		mugs.remove(0);
	}
	
	public void displayStorage(String indent) {
        System.out.println(indent + "Folder: " + name);
        for (Storage item : mugs) {
            item.displayStorage(indent + "    ");  // Indentation for hierarchy
        }
    }
	
}

public class CompositeDesign {
	public static void main(String [] args)
	{
		Mug m1 = new Mug("mug1");
		Mug m2 = new Mug("mug2");
		Mug m3 = new Mug("mug3");
		Mug m4 = new Mug("mug4");
		
		Bucket b1 = new Bucket("Bucket1");
		Bucket b2 = new Bucket("Bucket2");
		Bucket b3 = new Bucket("Bucket3");
		
		b1.add(b2);
		b1.add(b3);
		b2.add(m1);
		b2.add(m3);
		b3.add(m4);
		
		b1.displayStorage("");
	}
}
