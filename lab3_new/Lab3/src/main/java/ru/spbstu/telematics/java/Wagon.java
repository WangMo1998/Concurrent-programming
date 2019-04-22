package ru.spbstu.telematics.java;

public class Wagon implements Runnable{
	
	private int seats;
	private boolean canGo;
	private boolean ready;
	private boolean dayOver;
	
	public final Boolean sync = new Boolean(true);
	
	Wagon(){
		this.seats = 5;
		canGo = false;
		ready = true;
		this.dayOver = false;
	}
	
	Wagon(int seats){
		if(seats >= 0) {
			this.seats = seats;
		}
		canGo = false;
		ready = true;
		this.dayOver = false;
	}
	
	public boolean setSeats(int seats){
		if(seats >= 0) {
			this.seats = seats;
			return true;
		}
		return false;
	}
	
	public int getSeats(){
		return this.seats;
	}
	
	public void Go(){
		canGo = true;
		ready = false;
	}
	
	public boolean isReady(){
		return ready;
	}
	
	public void dayOver(){
		this.dayOver = true;
	}
	
    public void run() {
        String name = Thread.currentThread().getName();

        while(true){
        	synchronized(sync) {
	        	try{
			        if(canGo == true){
			        	System.out.println("Wagon started!");
			        	canGo = false;
			        	Thread.sleep(2000);
			        	System.out.println("Wagon finished!");
			        	ready = true;
			        	sync.notify();
			        }
			        if(dayOver) break;
			        //Thread.sleep(1000);
	        	} catch (InterruptedException e){
	        		e.printStackTrace();
	        	}
        	}
        }
    }

}
