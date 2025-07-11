package Week3Assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Main {
	
	public static void main(String [] args) throws IOException, ClassNotFoundException, InterruptedException, ExecutionException
	{
		File f = new File("passenger.txt");
		
		FileOutputStream fr = new FileOutputStream(f);
		
		ObjectOutputStream oos = new ObjectOutputStream(fr);
		
		for(Person p : Person.passengers)
		{
			oos.writeObject(p);
		}
		
		
		FileInputStream fis = new FileInputStream(f);
		
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Person.passengers.clear();
		while (true) { 
            try {
                Person p = (Person) ois.readObject();
                Person.passengers.add(p);
                
                System.out.println("Id: "+p.getId());
                System.out.println("Name: "+p.getName());
    			System.out.println("Age: "+p.getAge());
    			System.out.println("Gender: "+p.getGender());
    			System.out.println("SeatNo: "+(p.getSeatNo()==0?"No Seat Allocated":p.getSeatNo()));
    			System.out.println();
            } catch (EOFException e) {
                // System.out.println("End of file reached.");
                break; 
            }
        }
		
		ExecutorService es = Executors.newFixedThreadPool(5);
		ArrayList<Future<Person>> al = new ArrayList<>();
		
		
				
		for(Person p: Person.passengers) 
		{
			al.add(es.submit(p::run));
		}
		
//		try {
//			Thread.sleep(3000);
//		}catch(Exception e)
//		{
//			
//		}
		
		for(Future<Person> o: al)
		{
			Person p= o.get();
			oos.writeObject(p);
		}
		
		System.out.println();
		
		while (true) { 
            try {
                Person p = (Person) ois.readObject();
                Person.passengers.add(p);
                
                System.out.println("Id: "+p.getId());
                System.out.println("Name: "+p.getName());
    			System.out.println("Age: "+p.getAge());
    			System.out.println("Gender: "+p.getGender());
    			System.out.println("SeatNo: "+(p.getSeatNo()==0?"No Seat Allocated":p.getSeatNo()));
    			System.out.println();
            } catch (EOFException e) {
                // System.out.println("End of file reached.");
                break; 
            }
        }
		
		
		oos.close();
		fr.close();
		es.shutdown();
	}
}
