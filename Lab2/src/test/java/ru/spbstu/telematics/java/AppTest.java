package ru.spbstu.telematics.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.LinkedHashMap;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
	public void TestWithString(){
		
		// §³§à§Ù§Õ§Ñ§Ö§Þ §à§Õ§Ú§ß§Ñ§Ü§à§Ó§í§Ö §ï§Ü§Ù§Ö§Þ§á§Ý§ñ§â§í §Ü§Ý§Ñ§ã§ã§à§Ó - §ß§Ñ§ê Map §Ú §ã§ä§Ñ§ß§Õ§Ñ§â§ä§ß§í§Û Map
		CLinkedHashMap<String,String> ourmap = new CLinkedHashMap<String,String>();
		LinkedHashMap<String,String> stdmap = new LinkedHashMap<String,String>();
		
		// §±§â§à§Ó§Ö§â§ñ§Ö§Þ §Ú§ã§ç§à§Õ§ß§í§Û §â§Ñ§Ù§Þ§Ö§â
		assertEquals(ourmap.size(), stdmap.size());
		
        ourmap.put("flower", "Tulip");
        stdmap.put("flower", "Tulip");
        
        // §±§â§à§Ó§Ö§â§ñ§Ö§Þ §â§Ñ§Ù§Þ§Ö§â §á§à§ã§Ý§Ö §Õ§à§Ò§Ñ§Ó§Ý§Ö§ß§Ú§ñ §ï§Ý§Ö§Þ§Ö§ß§ä§Ñ
        assertEquals(ourmap.size(), stdmap.size());
        
        ourmap.put("car", "Chery");
        ourmap.put("pet", "Dog");
        
        stdmap.put("car", "Chery");
        stdmap.put("pet", "Dog");
        
        // §±§â§à§Ó§Ö§â§ñ§Ö§Þ §â§Ñ§Ù§Þ§Ö§â §á§à§ã§Ý§Ö §Õ§à§Ò§Ñ§Ó§Ý§Ö§ß§Ú§ñ §Ö§ë§× §ï§Ý§Ö§Þ§Ö§ß§ä§à§Ó
        assertEquals(ourmap.size(), stdmap.size());
        // §±§â§à§Ó§Ö§â§ñ§Ö§Þ §á§â§Ñ§Ó§Ú§Ý§î§ß§à§ã§ä§î §á§à§Ú§ã§Ü§Ñ §Ú§Þ§Ö§ð§ë§Ö§Ô§à§ã§ñ §ï§Ý§Ö§Þ§Ö§ß§ä§Ñ §á§à §Ü§Ý§ð§é§å
        assertEquals(ourmap.contains("car"), stdmap.containsKey("car"));
        
        ourmap.put("car", "Mazda");
        stdmap.put("car", "Mazda");
        
        // §±§â§à§Ó§Ö§â§ñ§Ö§Þ §â§Ñ§Ù§Þ§Ö§â §á§à§ã§Ý§Ö §á§à§á§í§ä§Ü§Ú §Õ§à§Ò§Ñ§Ó§Ý§Ö§ß§Ú§ñ §Õ§å§Ò§Ý§Ú§Ü§Ñ§ä§Ñ §Ú§Þ§Ö§ð§ë§Ö§Ô§à§ã§ñ §ï§Ý§Ö§Þ§Ö§ß§ä§Ñ
        assertEquals(ourmap.size(), stdmap.size());
        // §±§â§à§Ó§Ö§â§ñ§Ö§Þ §á§â§Ñ§Ó§Ú§Ý§î§ß§à§ã§ä§î §Ú§Ù§Ó§Ý§Ö§é§Ö§ß§Ú§ñ §Ù§ß§Ñ§é§Ö§ß§Ú§ñ §á§à §Ü§Ý§ð§é§å §Õ§Ý§ñ §Ú§Þ§Ö§ð§ë§Ö§Ô§à§ã§ñ §ï§Ý§Ö§Þ§Ö§ß§ä§Ñ
        assertEquals(ourmap.get("car"), stdmap.get("car"));
        
        ourmap.remove("car");
        stdmap.remove("car");
        
        // §±§â§à§Ó§Ö§â§ñ§Ö§Þ §â§Ñ§Ù§Þ§Ö§â §á§à§ã§Ý§Ö §å§Õ§Ñ§Ý§Ö§ß§Ú§ñ §ï§Ý§Ö§Þ§Ö§ß§ä§Ñ
        assertEquals(ourmap.size(), stdmap.size());
        // §±§â§à§Ó§Ö§â§ñ§Ö§Þ §á§â§Ñ§Ó§Ú§Ý§î§ß§à§ã§ä§î §á§à§Ú§ã§Ü§Ñ §ß§Ö§ã§å§ë§Ö§ã§ä§Ó§å§ð§ë§Ö§Ô§à §ï§Ý§Ö§Þ§Ö§ß§ä§Ñ §á§à §Ü§Ý§ð§é§å
        assertEquals(ourmap.contains("car"), stdmap.containsKey("car"));
		
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
