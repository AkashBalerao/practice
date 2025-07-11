package DesignPatterns;

// Template Method Design Pattern

abstract class Laptop{
	
	public void play()
	{
		startLaptop();
		runLaptop();
		stopLaptop();
	}
	
	abstract void startLaptop();
	abstract void runLaptop();
	abstract void stopLaptop();
}

class LapA extends Laptop{

	@Override
	void startLaptop() {
		System.out.println("Starting LapA");
	}

	@Override
	void runLaptop() {
		System.out.println("Running LapA");
		
	}

	@Override
	void stopLaptop() {
		System.out.println("Stopping LapA");
	}
	
}

class LapB extends Laptop{

	@Override
	void startLaptop() {
		System.out.println("Starting LapB");
	}

	@Override
	void runLaptop() {
		System.out.println("Running LapB");
		
	}

	@Override
	void stopLaptop() {
		System.out.println("Stopping LapB");
	}
	
}

public class TemplateMethod {
	
	public static void main(String [] args)
	{
		Laptop a = new LapA();
		Laptop b = new LapB();
		
		a.play();
		b.play();
	}
}
