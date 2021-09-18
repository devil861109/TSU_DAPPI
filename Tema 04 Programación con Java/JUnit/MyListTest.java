package org.sisoftware;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    public MyListTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of add method, of class MyList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");

        String element = "123";
        MyList instance = new MyList();
        instance.add(element);
        assertEquals(1, instance.size());
    }

    /**
     * Test of remove method, of class MyList.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        String element = "123";
        MyList instance = new MyList();
        instance.add(element);
        instance.remove(element);
        assertEquals(0, instance.size());
    }

    @Test
    public void testRemove_Case2() {
        System.out.println("remove");
        MyList instance = new MyList();
        instance.remove("123");
        assertEquals(0, instance.size());
    }

    /**
     * Test of size method, of class MyList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        MyList instance = new MyList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class MyList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        MyList instance = new MyList();
        String expResult = "First Element";
        instance.add(expResult);
        String result = instance.get(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testGet_Case2() {
        System.out.println("get");
        MyList instance = new MyList();
        String expResult = "First Element";
        String result = instance.get(2);
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class MyList.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        String element = "123";
        MyList instance = new MyList();
        boolean expResult = true;
        instance.add(element);
        boolean result = instance.contains(element);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIndex method, of class MyList.
     */
    @Test
    public void testGetIndex() {
        System.out.println("getIndex");
        String element = "123";
        MyList instance = new MyList();
        int expResult = 0;
        instance.add(element);
        int result = instance.getIndex(element);
        assertEquals(expResult, result);
    }
}