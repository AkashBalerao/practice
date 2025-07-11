
class MyThread extends Thread{
	public void run()
	{
		for(int i=0; i<10; i++)
		{
			System.out.println(i+" "+Thread.currentThread().getName());
		}
	}
}

public class Callingthread {
	
	public static void main(String [] args)
	{
		MyThread r = new MyThread();
		Thread t = new Thread(r, "Thread2");
		r.start();
		t.start();
	}

}
