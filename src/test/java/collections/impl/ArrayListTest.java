package collections.impl;

import collections.Iterator;
import collections.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    private List<Integer> arr;

    @Before
    public void init(){
        arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(10);
    }

    @Test
    public void add() {
        assertEquals(10, ((ArrayList) arr).getCount());
        arr.add(65);
        assertEquals(11, ((ArrayList) arr).getCount());
        assertSame(65, arr.get(10));
    }

    @Test
    public void remove() {
        assertEquals(10, ((ArrayList) arr).getCount());
        Integer remove = arr.remove(5);
        assertEquals(9, ((ArrayList) arr).getCount());
        assertSame(6, remove);
    }

    @Test
    public void get() {
        assertSame(6,arr.get(5));
    }

    @Test
    public void iterator() {
        StringBuilder sb = new StringBuilder();
        Iterator iterator = arr.iterator();

        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        assertEquals("12345678910", sb.toString());
    }
}