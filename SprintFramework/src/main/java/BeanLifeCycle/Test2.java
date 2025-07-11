package BeanLifeCycle;

public class Test2 {
	
	Test2()
	{
		abc();
	}
	
	public void abc()
	{
		System.out.println(this);
	}
	
	public static void main(String [] args)
	{
		Test2 t = new Test2();
		System.out.println(t);
	}
}
