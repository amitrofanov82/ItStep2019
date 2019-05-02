import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    private ArrayList testInstance;

    @Before
    public void setUp() {
        testInstance = new ArrayList(10);
    }

    @Test
    public void getAndAddfirstAndAddlast() {
        testInstance.addLast(108);
        testInstance.addFirst(16);
        assertEquals(16, testInstance.get(0));
        assertEquals(108, testInstance.get(testInstance.size() - 1));

        try {
            testInstance.get(5);
        } catch (Exception e) {
            assertEquals("Array index out of range: 5", e.getMessage());
        }
    }

    @Test
    public void set() {
    	//prepare test data
        Exception expectedException = null;
        
    	//run
        testInstance.addFirst(108);
        testInstance.set(10, 0);
        try {
            testInstance.set(10, 10);
        } catch (Exception e) {
        	expectedException = e;
        }
        
    	//check results
        assertEquals(10, testInstance.get(0));
        assertEquals("Array index out of range: 10", expectedException.getMessage());
    }

    @Test
    public void size() {
        for (int i = 0; i < 8; i++) {
            testInstance.addLast(i);
        }
        assertEquals(8, testInstance.size());
    }

    @Test
    public void insertBefore() {
        for (int i = 0; i < 5; i++) {
            testInstance.addLast(i);
        }
        testInstance.insertBefore(108, 3);
        assertEquals(2, testInstance.get(2));
        assertEquals(108, testInstance.get(3));
        assertEquals(3, testInstance.get(4));
    }

    @Test
    public void remove() {
        for (int i = 0; i < 3; i++) {
            testInstance.addLast(i);
        }
        testInstance.remove(1);
        assertEquals(0, testInstance.get(0));
        assertEquals(2, testInstance.get(1));
        try {
            testInstance.remove(15);
        } catch (Exception e) {
            assertEquals("Array index out of range: 15", e.getMessage());
        }
    }
}