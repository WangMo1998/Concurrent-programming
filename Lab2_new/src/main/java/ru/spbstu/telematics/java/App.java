package ru.spbstu.telematics.java;

import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        CLinkedHashMap<String,String> map = new CLinkedHashMap<String,String>();
        System.out.println(map.size());
        map.put("flower", "Tulip");
        System.out.println(map.size());
        map.put("car", "Chery");
        map.put("pet", "Dog");
        System.out.println(map.size());
        if(map.contains("car")) System.out.println("Has car");
        else System.out.println("No car");
        map.put("car", "Mazda");
        System.out.println(map.size());
        System.out.println(map.get("car"));
        map.remove("car");
        System.out.println(map.size());
        if(map.contains("car")) System.out.println("Has car");
        else System.out.println("No car");
        
        Iterator it = map.iterator();
        
        System.out.println("LinkedHashMap through Iterator: ");
        while(it.hasNext()){
           CEntry e = (CEntry)it.next();
           System.out.println(e.getKey() + ": " + e.getValue());
       }
    }
}
