package DesignPatterns;

interface Image{
	void display();
}

class RealImage implements Image{
	
	String filename;
	
	RealImage(String name){
		this.filename = name;
		loadImage();
	}
	
	void loadImage()
	{
		System.out.println("Loading image: "+this.filename);
	}
	
	public void display()
	{
		System.out.println("displaying image: "+this.filename);
	}
	
}

class ProxyImage implements Image{
	
	RealImage ri;
	
	String filename;
	
	ProxyImage(String filename)
	{
		this.filename = filename;
	}
	
	public void display()
	{
		if(ri==null)
		{
			ri = new RealImage(filename);
		}
		
		ri.display();
	}
}

public class VirtualProxy {
	public static void main(String [] args)
	{
		Image r1 = new ProxyImage("image1");
		
		Image r2 = new ProxyImage("image2");
		
		r1.display();
		
		
		r1.display();
		
		
		r2.display();
	}
}
