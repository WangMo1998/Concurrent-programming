package ru.spbstu.telematics.java;

public class Passenger {
	private int number;
	
	Passenger(int number){
		this.number = number;
	}
	
	@Override
	public String toString(){
		return "Passenger ¡í"+this.number;
	}
}
