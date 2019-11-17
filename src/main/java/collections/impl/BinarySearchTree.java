package collections.impl;

import java.util.Iterator;
// monster mode сделать на объъектах с дженериками
public class BinarySearchTree implements Iterable {

    @Override
    public Iterator iterator() {
        //todo написать реализацию
        return null;
    }

    class Node {
        int value;
        Node left = null;
        Node right = null;

        Node(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        //todo написать реализацию
    }

    public void reverse() {
        //todo написать реализацию
    }
}
