

class Resource extends Thread{
	
	public void run()
	{
		System.out.println("Start of Thread "+Thread.currentThread().getName());
		
		
		try {
			Thread.sleep(1000);			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		if(true)
		{
			Thread.yield();
		}
		
		System.out.println("End of Thread "+Thread.currentThread().getName());
		
	}
}

public class YeildOperatioon {
	
	public static void main(String [] args) throws InterruptedException
	{
		Resource f = new Resource();
		
		Thread t1 = new Thread(f, "Thread1");
		Thread t2 = new Thread(f, "Thread2");
		
		t1.start();
		
		t2.start();
		
		Thread.sleep(1000);
	}

}
