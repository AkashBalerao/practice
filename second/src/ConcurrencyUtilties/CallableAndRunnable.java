package ConcurrencyUtilties;
import java.util.concurrent.*;

public class CallableAndRunnable {
	
	public static void main(String [] args)
	{
		ExecutorService e = Executors.newFixedThreadPool(2);
		
		Callable<String> c = ()->{
			System.out.println("Executing tasks....");
			return "Task completed";
		};
		
		Future<?> future = e.submit(c);
		
		try {
			System.out.println(future.get());
		}catch(Exception r)
		{
			System.out.println(r);
		}
	}
}
