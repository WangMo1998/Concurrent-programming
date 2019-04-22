package ru.spbstu.telematics.java;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tourniquet implements Runnable{

	private Queue<Passenger> common_queue;
	private Queue<Passenger> exit_queue;

	public Boolean opened;
	
	private Controller c;
	
	Tourniquet(Controller c, List<Passenger> passengers){
		this.c = c;
		this.opened = true;
		common_queue = new LinkedList<Passenger>();
		exit_queue = new LinkedList<Passenger>();
		Iterator it = passengers.iterator();
		while(it.hasNext()){
			common_queue.add((Passenger)it.next());
		}
	}
	
	public void run() {
        String name = Thread.currentThread().getName();
        
        while(true){
        	synchronized(c.sync) {
        	try{
		        while(this.opened){
		        	if(!common_queue.isEmpty()) {
		        		Passenger p = common_queue.remove();
		        		exit_queue.add(p);
		        		System.out.println(p + " enters tourniquet.");
		        		Thread.sleep(500);
		        		c.enterPassenger();
		        	} else c.lastPassenger();
		        	if(c.isFull()) {
		        		this.opened = false;
		        		System.out.println("Tourniquet closed.");
		        	}
		        	
		        }
		        while(!this.opened){
		        	while(!c.canOut()) {
		        		c.sync.wait();
		        	}
		        	if(c.canOut()){
		        		if(!exit_queue.isEmpty()) {
			        		Passenger p = exit_queue.remove();
			        		System.out.println(p + " exits tourniquet.");
			        		Thread.sleep(500);
			        	} else {
			        		this.opened = true;
			        		System.out.println("Tourniquet opened.");
			        	}
		        	}
		        }
		        if(common_queue.isEmpty() && exit_queue.isEmpty()) {
		        	System.out.println("No more passengers in the queue!");
		        	this.opened = false;
	        		System.out.println("Tourniquet closed.");
		        	c.dayOver();
		        	break;
		        }
		        //Thread.sleep(1000);
        	} catch (InterruptedException e){
        		e.printStackTrace();
        	}
        	}
        }
    }
}
