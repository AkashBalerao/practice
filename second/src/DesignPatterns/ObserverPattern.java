package DesignPatterns;

import java.util.ArrayList;

interface Observer{
	void showmessage(String msg);
}

class Employee implements Observer{
	
	private String username;
	
	Employee(String name)
	{
		this.username = name;
	}
	
	public void showmessage(String msg)
	{
		System.out.println(msg);
	}
}


class EmplyFactory{
	ArrayList<Observer> a = new ArrayList<>();
	
	void addObserver(Observer ob)
	{
		a.add(ob);
	}
	
	void removeObserver(Observer ob)
	{
		a.remove(ob);
	}
	
	void notifyall(String s)
	{
		for(Observer r: a)
		{
			r.showmessage(s);
		}
	}
	
}

public class ObserverPattern {
	
	public static void main(String [] args)
	{
		Employee e1 = new Employee("Akash");
		Employee e2 = new Employee("Ram");
		
		EmplyFactory e = new EmplyFactory();
		
		e.addObserver(e2);
		e.addObserver(e1);
		
		e.notifyall("There is a discount");
	}
}
