package ru.spbstu.telematics.java;

public class Controller implements Runnable{

	private Wagon w;
	private boolean full;
	private boolean canGo;
	private boolean canOut;
	private int pCount;
	private boolean dayOver;
	
	public final Boolean sync = new Boolean(true);
	
	Controller(Wagon w){
		this.w = w;	
		this.full = false;
		this.canGo = false;
		this.canOut = true;
		this.pCount = 0;
		this.dayOver = false;
	}
	
	public void enterPassenger(){
		pCount++;
		System.out.println("Occupied: " + pCount + ", Free: " + (w.getSeats() - pCount));
		if(pCount == w.getSeats()) {
			full = true;
			canGo = true;
			canOut = false;
			pCount = 0;
		}
	}
	
	public void lastPassenger(){
		full = true;
		if(pCount > 0) {
			canGo = true;
			canOut = false;
			pCount = 0;
		}
	}
	
	public boolean isFull(){
		return full;
	}
	
	public boolean canOut(){
		return canOut;
	}
	
	public void dayOver(){
		this.dayOver = true;
	}
	
	
	public void run() {
        String name = Thread.currentThread().getName();
        while(true){
        	synchronized(sync) {
        	synchronized(w.sync) {
	        	try{
			        if(canGo == true){
			        	w.Go();
			        	canGo = false;
			        }
			        if(canGo == false){
			        	while(!w.isReady()) {
			        		w.sync.wait();
			        	}
			        	if(w.isReady()) {
			        		canOut = true;
			        		full = false;
			        		sync.notify();
			        	}
			        }
			        if(dayOver){
			        	w.dayOver();
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
}
