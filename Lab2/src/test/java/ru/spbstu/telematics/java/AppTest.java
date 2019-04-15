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
		
		// ����٧էѧ֧� ��էڧߧѧܧ�ӧ�� ��ܧ٧֧ާ�ݧ��� �ܧݧѧ���� - �ߧѧ� Map �� ���ѧߧէѧ��ߧ�� Map
		CLinkedHashMap<String,String> ourmap = new CLinkedHashMap<String,String>();
		LinkedHashMap<String,String> stdmap = new LinkedHashMap<String,String>();
		
		// �����ӧ֧��֧� �ڧ���էߧ�� ��ѧ٧ާ֧�
		assertEquals(ourmap.size(), stdmap.size());
		
        ourmap.put("flower", "Tulip");
        stdmap.put("flower", "Tulip");
        
        // �����ӧ֧��֧� ��ѧ٧ާ֧� ����ݧ� �է�ҧѧӧݧ֧ߧڧ� ��ݧ֧ާ֧ߧ��
        assertEquals(ourmap.size(), stdmap.size());
        
        ourmap.put("car", "Chery");
        ourmap.put("pet", "Dog");
        
        stdmap.put("car", "Chery");
        stdmap.put("pet", "Dog");
        
        // �����ӧ֧��֧� ��ѧ٧ާ֧� ����ݧ� �է�ҧѧӧݧ֧ߧڧ� �֧�� ��ݧ֧ާ֧ߧ���
        assertEquals(ourmap.size(), stdmap.size());
        // �����ӧ֧��֧� ���ѧӧڧݧ�ߧ���� ���ڧ�ܧ� �ڧާ֧��֧ԧ��� ��ݧ֧ާ֧ߧ�� ��� �ܧݧ���
        assertEquals(ourmap.contains("car"), stdmap.containsKey("car"));
        
        ourmap.put("car", "Mazda");
        stdmap.put("car", "Mazda");
        
        // �����ӧ֧��֧� ��ѧ٧ާ֧� ����ݧ� ������ܧ� �է�ҧѧӧݧ֧ߧڧ� �է�ҧݧڧܧѧ�� �ڧާ֧��֧ԧ��� ��ݧ֧ާ֧ߧ��
        assertEquals(ourmap.size(), stdmap.size());
        // �����ӧ֧��֧� ���ѧӧڧݧ�ߧ���� �ڧ٧ӧݧ֧�֧ߧڧ� �٧ߧѧ�֧ߧڧ� ��� �ܧݧ��� �էݧ� �ڧާ֧��֧ԧ��� ��ݧ֧ާ֧ߧ��
        assertEquals(ourmap.get("car"), stdmap.get("car"));
        
        ourmap.remove("car");
        stdmap.remove("car");
        
        // �����ӧ֧��֧� ��ѧ٧ާ֧� ����ݧ� ��էѧݧ֧ߧڧ� ��ݧ֧ާ֧ߧ��
        assertEquals(ourmap.size(), stdmap.size());
        // �����ӧ֧��֧� ���ѧӧڧݧ�ߧ���� ���ڧ�ܧ� �ߧ֧���֧��ӧ���֧ԧ� ��ݧ֧ާ֧ߧ�� ��� �ܧݧ���
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
