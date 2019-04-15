package ru.spbstu.telematics.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	public void testString(){
		try{
	        FileReWriter f = new FileReWriter("text.txt");
	        f.writeToFile("Hello World!");
	        f.saveFile();
        } catch (IOException e){
        	e.printStackTrace();
        }
		
		try{
			FileReader fr = new FileReader("text.txt");
			BufferedReader reader = new BufferedReader(fr);
			String str = reader.readLine();
			fr.close();
			assertEquals(str, "Hello World!");
		} catch (IOException e){
			e.printStackTrace();
		}
		
		
	}
	
	public void testAppend(){
		try{
	        FileReWriter f = new FileReWriter("text.txt");
	        String s = "text";
	        Integer i = 5;
	        f.writeToFile(s);
	        f.writeToFile(i,'a');
	        f.saveFile();
        } catch (IOException e){
        	e.printStackTrace();
        }
		
		try{
			FileReader fr = new FileReader("text.txt");
			BufferedReader reader = new BufferedReader(fr);
			String str = reader.readLine();
			fr.close();
			assertEquals(str, "text5");
		} catch (IOException e){
			e.printStackTrace();
		}
		
		
	}
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
