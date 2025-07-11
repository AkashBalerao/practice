package DesignPatterns;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Bike {
    void drive() {
        System.out.println("The bike " + this.hashCode() + " running....");
    }

    void stop() {
        System.out.println("The bike " + this.hashCode() + " has stopped....");
    }
}

class BusPool {
    private final BlockingQueue<Bike> bikes;
    private final int maxSize;

    BusPool(int size) {
        this.maxSize = size;
        this.bikes = new ArrayBlockingQueue<Bike>(10);

        for (int i = 0; i < maxSize; i++) {
            bikes.offer(new Bike());
        }
    }

    Bike acquire() throws InterruptedException {
        return bikes.take();
    }

    void release(Bike bike) {
        try {
			bikes.put(bike);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

public class ObjectPool {
    public static void main(String[] args) {
        BusPool bp = new BusPool(2);

        Runnable task = () -> {
            Bike bike;
			try {
				bike = bp.acquire();
				bike.drive();
				 try {
		                Thread.sleep(2000); 
		            } catch (InterruptedException ignored) {}
		            bike.stop();
		            bp.release(bike);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        };

        Thread t1 = new Thread(task, "Passenger-1");
        Thread t2 = new Thread(task, "Passenger-2");
        Thread t3 = new Thread(task, "Passenger-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
