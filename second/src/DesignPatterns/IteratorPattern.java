package DesignPatterns;

interface iterator{
	boolean hasNext();
    boolean next();
}

interface IterableCollection{
	iterator getIterator();
}

class Bins implements IterableCollection{
	boolean typs[] = {true, true, false, false};
	int size = typs.length;
	
	public iterator getIterator()
	{
		return new Types(typs);
	}
}

class Types implements iterator{
	
	boolean typs[];
	int index;
	
	Types(boolean ty[])
	{
		this.typs = ty;
		index = 0;
	}
	
	public boolean hasNext()
	{
		return index < typs.length;
	}
	
	public boolean next()
	{
		if(hasNext())
		{
			return typs[index++];
		}
		return false;
	}
}

public class IteratorPattern {
	public static void main(String [] args)
	{
		IterableCollection binaryies = new Bins();
		
		iterator it = binaryies.getIterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
