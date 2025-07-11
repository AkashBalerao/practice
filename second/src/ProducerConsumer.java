//import java.util.*;
//
//class SharedResource{
//	private int data;
//	private boolean avaliable = false;
//	
//	public synchronized void produce(int value)
//	{
//		while(avaliable)
//		{
//			try {
//				wait();
//			}catch(InterruptedException e)
//			{
//				System.out.println(e);
//			}
//		}
//		data = value;
//		System.out.println("Produced: "+ data);
//		avaliable = true;
//		notify();
//	}
//
//	public synchronized void consume()
//	{
//		while(!avaliable)
//		{
//			try {
//				wait();
//			}catch(InterruptedException e)
//			{
//				System.out.println(e);
//			}
//		}
//		data = 0;
//		avaliable = false;
//		System.out.println("Consumed: "+ data);
//		notify();
//	}
//}
//
//class Producer extends Thread{
//	SharedResource r;
//	
//	Producer(SharedResource s)
//	{
//		this.r = s;
//	}
//	
//	public void run()
//	{
//		for(int i=1; i<=5; i++)
//		{
//			r.produce(i);
//			try {
//				Thread.sleep(1000);
//			}catch(InterruptedException e)
//			{
//				System.out.println(e);
//			}
//		}
//	}
//}
//
//class Consumer extends Thread{
//	SharedResource r;
//	
//	Consumer(SharedResource s)
//	{
//		this.r = s;
//	}
//	
//	public void run()
//	{
//		for(int i=1; i<=5; i++)
//		{
//			r.consume();
//			try {
//				Thread.sleep(1000);
//			}catch(InterruptedException e)
//			{
//				System.out.println(e);
//			}
//		}
//	}
//}
//
//public class ProducerConsumer {
//	public static void main(String [] args)
//	{
//		SharedResource r = new SharedResource();
//		
//		Producer p = new Producer(r);
//		Consumer c = new Consumer(r);
//		
//		Thread t1 = new Thread(p);
//		Thread t2 = new Thread(c);
//		
//		t1.start();
//		t2.start();
//	}
//}

//package MultiThreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//
class Producer implements Runnable{
	private final BlockingQueue<String> bq;
	
	public Producer(BlockingQueue<String> bq) {
		this.bq = bq;
	}
	
	public void run() {
		for(int i=1;i<=5;i++) {
			String temp = ""+i;
			try {
				bq.put(temp);
				System.out.println("Produced log: "+temp);
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable{
	
	private final BlockingQueue<String> bq;
	
	public Consumer(BlockingQueue<String> bq) {
		this.bq = bq;
	}
	
	public void run() {
		for(int i=1;i<=5;i++) {
			try {
				String val = bq.take();
				System.out.println("Consumed value: "+val);
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ProducerConsumer{
	public static void main(String[] args) {
		
		BlockingQueue<String> bq = new LinkedBlockingQueue<>();
		
		ExecutorService exe = Executors.newFixedThreadPool(5);
		
		Thread p = new Thread(new Producer(bq));
		Thread c = new Thread(new Consumer(bq));
		
		Future<?> ft1 = exe.submit(p);
		Future<?> ft2 = exe.submit(c);
		
		try {
			ft1.get();
			ft2.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		exe.shutdown();
	}
}

//class Producer implements Runnable{
//	private final BlockingQueue<Integer> bq;
//	
//	public Producer(BlockingQueue<Integer> bq) {
//		this.bq = bq;
//	}
//	
//	public void run() {
//		for(int i=1;i<=5;i++) {
//			try {
//				bq.put(i);
//				System.out.println("Produced value: "+i);
//				Thread.sleep(500);
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}
//
//class Consumer implements Runnable{
//	
//	private final BlockingQueue<Integer> bq;
//	
//	public Consumer(BlockingQueue<Integer> bq) {
//		this.bq = bq;
//	}
//	
//	public void run() {
//		for(int i=1;i<=5;i++) {
//			try {
//			int val = bq.take();
//			System.out.println("Consumed value: "+val);
//			Thread.sleep(500);
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}
//
//public class ProducerConsumer {
//	public static void main(String[]args) {
//		BlockingQueue<Integer> bq = new LinkedBlockingQueue<>(3);
//		Thread p = new Thread(new Producer(bq));
//		Thread c = new Thread(new Consumer(bq));
//		
//		p.start();
//		c.start();
//		
//		
//	}
//}
