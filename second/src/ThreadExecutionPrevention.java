
class Resource1 extends Thread{
	
	public void run()
	{
		for(int i=0; i<1000; i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}
}


public class ThreadExecutionPrevention {
	public static void main(String [] args) throws Exception
	{
		Resource1 r = new Resource1();
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.setPriority(2);
		t1.start();
		t2.start();
		//t1.yield();
	}
}
