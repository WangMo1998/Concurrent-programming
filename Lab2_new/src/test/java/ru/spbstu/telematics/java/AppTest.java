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
		
		// Создаем одинаковые экземпляры классов - наш Map и стандартный Map
		CLinkedHashMap<String,String> ourmap = new CLinkedHashMap<String,String>();
		LinkedHashMap<String,String> stdmap = new LinkedHashMap<String,String>();
		
		// Проверяем исходный размер
		assertEquals(ourmap.size(), stdmap.size());
		
        ourmap.put("flower", "Tulip");
        stdmap.put("flower", "Tulip");
        
        // Проверяем размер после добавления элемента
        assertEquals(ourmap.size(), stdmap.size());
        
        ourmap.put("car", "Chery");
        ourmap.put("pet", "Dog");
        
        stdmap.put("car", "Chery");
        stdmap.put("pet", "Dog");
        
        // Проверяем размер после добавления ещё элементов
        assertEquals(ourmap.size(), stdmap.size());
        // Проверяем правильность поиска имеющегося элемента по ключу
        assertEquals(ourmap.contains("car"), stdmap.containsKey("car"));
        
        ourmap.put("car", "Mazda");
        stdmap.put("car", "Mazda");
        
        // Проверяем размер после попытки добавления дубликата имеющегося элемента
        assertEquals(ourmap.size(), stdmap.size());
        // Проверяем правильность извлечения значения по ключу для имеющегося элемента
        assertEquals(ourmap.get("car"), stdmap.get("car"));
        
        ourmap.remove("car");
        stdmap.remove("car");
        
        // Проверяем размер после удаления элемента
        assertEquals(ourmap.size(), stdmap.size());
        // Проверяем правильность поиска несуществующего элемента по ключу
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
