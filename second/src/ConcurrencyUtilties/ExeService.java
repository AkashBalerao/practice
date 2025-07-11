package ConcurrencyUtilties;

import java.util.concurrent.*;

//class Invoker implements Executor{
//	
//	public void execute(Runnable e) {
//		e.run();
//	}
//	
//}

public class ExeService {
	
	public static void main(String [] args)
	{
		ScheduledExecutorService e = Executors.newScheduledThreadPool(1);
		
		Runnable l = () -> {System.out.println("current Time: "+System.currentTimeMillis());
		};
		
		System.out.println("outside time: "+System.currentTimeMillis());
		e.schedule(l, 3, TimeUnit.SECONDS);
		
		e.scheduleAtFixedRate(l, 1, 3, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(8000);
		}catch(Exception r)
		{
			System.out.println(r);
		}
		
		e.shutdown();
	}
}
