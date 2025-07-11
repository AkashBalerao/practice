package ConcurrencyUtilties;

import java.util.concurrent.*;

class Resource{
	private static final Semaphore semaphore = new Semaphore(2);
	
	public void useResource(String name)
	{
		try {
			semaphore.acquire();
			System.out.println("Lock acquired by ..."+ name);
			Thread.sleep(1000);
			System.out.println("Lock released by ..."+ name);
			semaphore.release();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

public class SemaphoresExample {
	public static void main(String [] args)
	{
		Resource s = new Resource();
		ExecutorService executor = Executors.newFixedThreadPool(5); // Thread pool of size 5

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> s.useResource(Thread.currentThread().getName()));
        }

        executor.shutdown();
	}
}
