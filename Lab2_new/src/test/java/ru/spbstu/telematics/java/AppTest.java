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
		
		// ������� ���������� ���������� ������� - ��� Map � ����������� Map
		CLinkedHashMap<String,String> ourmap = new CLinkedHashMap<String,String>();
		LinkedHashMap<String,String> stdmap = new LinkedHashMap<String,String>();
		
		// ��������� �������� ������
		assertEquals(ourmap.size(), stdmap.size());
		
        ourmap.put("flower", "Tulip");
        stdmap.put("flower", "Tulip");
        
        // ��������� ������ ����� ���������� ��������
        assertEquals(ourmap.size(), stdmap.size());
        
        ourmap.put("car", "Chery");
        ourmap.put("pet", "Dog");
        
        stdmap.put("car", "Chery");
        stdmap.put("pet", "Dog");
        
        // ��������� ������ ����� ���������� ��� ���������
        assertEquals(ourmap.size(), stdmap.size());
        // ��������� ������������ ������ ���������� �������� �� �����
        assertEquals(ourmap.contains("car"), stdmap.containsKey("car"));
        
        ourmap.put("car", "Mazda");
        stdmap.put("car", "Mazda");
        
        // ��������� ������ ����� ������� ���������� ��������� ���������� ��������
        assertEquals(ourmap.size(), stdmap.size());
        // ��������� ������������ ���������� �������� �� ����� ��� ���������� ��������
        assertEquals(ourmap.get("car"), stdmap.get("car"));
        
        ourmap.remove("car");
        stdmap.remove("car");
        
        // ��������� ������ ����� �������� ��������
        assertEquals(ourmap.size(), stdmap.size());
        // ��������� ������������ ������ ��������������� �������� �� �����
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
