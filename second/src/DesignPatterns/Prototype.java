package DesignPatterns;

class NetworkConnection implements Cloneable{
	
	private String IP;
	private String Data;
	
	NetworkConnection(String ip)
	{
		this.IP = ip;
	}
	
	public void LoadData() throws Exception
	{
		this.Data = "very imp data";
		Thread.sleep(2000);
	}
	
	public String getData()
	{
		return this.Data;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}

public class Prototype {
	public static void main(String [] args) throws CloneNotSupportedException
	{
		System.out.println("Connection creation time: "+System.currentTimeMillis());
		NetworkConnection nc = new NetworkConnection("192.168.0.1");
		
		try {
			nc.LoadData();			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("Time after loading data: "+System.currentTimeMillis());
		System.out.println(nc.getData());
		
		NetworkConnection newnc = (NetworkConnection) nc.clone();
		System.out.println("Time after second connection: "+System.currentTimeMillis());
		System.out.println(newnc.getData());
	}
}
