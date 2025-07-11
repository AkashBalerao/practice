package DesignPatterns;

// StrategyPatternJava

interface UPI{
	void pay(int amt);
}

class Gpay implements UPI
{
	public void pay(int amt)
	{
		System.out.println("Paying "+amt+" using Gpay");
	}
}

class Phonepe implements UPI
{
	public void pay(int amt)
	{
		System.out.println("Paying "+amt+" using Phonepe");
	}
}

public class StrategyPattern {
	
	public static void main(String [] args)
	{
		UPI a1 = new Gpay();
		
		a1.pay(3000);
		
		UPI a2 = new Phonepe();
		a2.pay(3000);
		
		
	}

}
