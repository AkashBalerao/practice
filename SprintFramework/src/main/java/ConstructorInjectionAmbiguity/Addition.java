package ConstructorInjectionAmbiguity;

public class Addition {
	private int a;
	private int b;
	
	Addition(int a, int b)
	{
		this.a = a;
		this.b = b;
		System.out.println("int");
	}
	
	Addition(double ad, double bd)
	{
		this.a = (int)ad;
		this.b = (int)bd;
		System.out.println("double");
	}
	
	Addition(String a, String b)
	{
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);
		System.out.println("String");
	}
	
	public void sum()
	{
		System.out.println("Value of a: "+a);
		System.out.println("Value of b: "+b);
		System.out.println("Sum: "+(a+b));
	}
}
