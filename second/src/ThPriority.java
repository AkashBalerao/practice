

class MyThread1 extends Thread{
	public void run()
	{
		for(int i=0; i<10; i++)
		{
			System.out.println(i);
		}
	}
}

public class ThPriority {
	public static void main(String [] args)
	{
		System.out.println(Thread.currentThread().getPriority());
		
		Thread t1 = new Thread(new MyThread1());
		
		t1.setPriority(10);
		t1.start();
		
		System.out.println("MainThread");
		
		
		System.out.println(t1.getPriority());
	}
}
