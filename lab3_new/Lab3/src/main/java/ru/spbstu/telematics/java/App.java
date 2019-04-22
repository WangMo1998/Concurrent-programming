package ru.spbstu.telematics.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<Passenger> passengers = new ArrayList<Passenger>();
    	for(int i=1; i<=18; i++) passengers.add(new Passenger(i));
    	
        Wagon w = new Wagon(5);
        Controller c = new Controller(w);
        Tourniquet t = new Tourniquet(c,passengers);
        
        Thread wt = new Thread(w,"Wagon");
        Thread ct = new Thread(c,"Controller");
        Thread tt = new Thread(t,"Tourniquet");
        
        wt.start();
        ct.start();
        tt.start();
    }
}
