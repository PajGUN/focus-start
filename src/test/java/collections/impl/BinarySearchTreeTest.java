package collections.impl;

import collections.Iterator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    BinarySearchTree tree;
    StringBuilder sb;


    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree();
        sb = new StringBuilder();
        tree.add(5);
        tree.add(2);
        tree.add(8);
        tree.add(9);
        tree.add(6);
        tree.add(3);
    }

    @Test
    public void add() {
        int countNodes = 0;
        tree.add(20);

        Iterator iterator = tree.iterator();
        while (iterator.hasNext()){
            countNodes++;
            sb.append(iterator.next()).append(" ");
        }
        assertEquals(countNodes, 7);
        assertEquals("2 3 5 6 8 9 20 ", sb.toString());
    }

    @Test
    public void reverse() {
        tree.reverse();
        Iterator iterator = tree.iterator();
        while (iterator.hasNext()){
            sb.append(iterator.next()).append(" ");
        }
        assertEquals("9 8 6 5 3 2 ", sb.toString());
    }

    @Test
    public void iterator() {
        Iterator iterator = tree.iterator();
        while (iterator.hasNext()){
            sb.append(iterator.next()).append(" ");
        }
        assertEquals("2 3 5 6 8 9 ", sb.toString());
    }


}