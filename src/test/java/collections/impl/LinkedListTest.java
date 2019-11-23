package collections.impl;

import collections.Iterator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList list;
    private Iterator<Integer> iterator;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
    }

    @Test
    public void add() {
        list.add(7);
        assertEquals(7,list.get(6));
    }

    @Test
    public void addByIndex() {
        assertNotEquals(3,list.get(5));
        list.add(3,5);
        assertEquals(3,list.get(5));
    }

    @Test
    public void remove() {
        Integer remove = (Integer) list.remove(4);
        assertNotEquals(remove, list.get(4));
        assertSame(5, remove);
    }

    @Test
    public void get() {
        assertSame(4,list.get(3));
    }

    @Test
    public void iterator() {
        StringBuilder sb = new StringBuilder();
        Iterator iterator = list.iterator();

        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        assertEquals("123456", sb.toString());
    }
}