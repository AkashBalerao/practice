package DesignPatterns;

import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Book{
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void reading()
	{
		lock.readLock().lock();
		
		for(int i=0; i<500; i++)
		{
			System.out.println(i);
		}
		
		try {
			System.out.println(Thread.currentThread().getName()+" is reading");
			Thread.sleep(1000);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		lock.readLock().unlock();
	}
	
	public void writing()
	{
		lock.writeLock().lock();
		
		
		try {
			System.out.println(Thread.currentThread().getName()+" is writing");
			Thread.sleep(1000);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		lock.writeLock().unlock();
	}
}

class Reader extends Thread{
	Book b;
	
	Reader(Book b)
	{
		this.b = b;
	}
	
	public void run()
	{
		b.reading();
	}
}

class Writer extends Thread{
	Book b;
	
	Writer(Book b)
	{
		this.b = b;
	}
	
	public void run()
	{
		b.writing();
	}
}

public class ReadwriteLock {
	public static void main(String [] args) {
		
		Book b = new Book();
		
		Reader r = new Reader(b);
		Writer w = new Writer(b);
		
//		Runnable r1 = b::reading;
//		
//		Runnable r2 = ()->{
//			b.reading();
//		};
//		
//		Runnable w1 = ()->{
//			b.writing();
//		};
//		
//		Thread t1 = new Thread(r1);
//		Thread t2 = new Thread(r2);
//		Thread t3 = new Thread(w1);
//		
//		t1.start();
//		t2.start();
//		t3.start();
		
//		try {
//		    throw new OutOfMemoryError("Critical failure");
//		} catch (Throwable t) {
//		    System.out.println("Caught: " + t);
//		    throw t; 
//		}

	}
}
