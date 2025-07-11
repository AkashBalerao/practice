
class CloseResource extends Thread{
	public void run()
	{
		System.out.println("Closing database connection....");
	}
}

public class ShutdownHook {
	
	public static void main(String [] args)
	{
		Runtime rt = Runtime.getRuntime();
		
		Thread t = new Thread(new CloseResource());
		
		rt.addShutdownHook(t);
		
		// if we don't want to run shutdownhook we could use .removeshutdownHook();
		
//		try {
//			Thread.sleep(5000);
//			
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		
//		System.exit(0);
		
		System.out.println("JVM is shutting down...");
	}
}
