package Revision;

public class UncaughtThreadExceptions {
	
	public static void main(String []args)
	{
		Thread t1 = new Thread(()->{
			for(int i=0; i<100; i++)
			{
				System.out.println(i);
				if(i==50)
				{
					throw new RuntimeException();
				}
			}
		});
		
		t1.start();
		try {
			Thread.sleep(1000);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println("dslkfjadskfjlk");
	
	}

}
