package collections.impl;

import collections.Iterator;
import collections.List;


public class ArrayList<E> implements List<E> {
    private Object[] array;

    private int count = 0;

    public int getCount() {
        return count;
    }


    public ArrayList() {
        array = new Object[10];
    }

    public ArrayList(int capacity) {
        if(capacity > 0){
            this.array = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity <= 0");
        }
    }

    @Override
    public boolean add(E e) {
        //todo написать реализацию
        if (count==array.length){
            Object[] newArray = new Object[(int) (array.length * 1.5)];
            System.arraycopy(array,0,newArray,0,array.length);
            newArray[count] = e;
            array = newArray;
            count++;
        } else {
            array[count] = e;
            count++;
        }
        return true;
    }

    @Override
    public E remove(int index) {
        //todo написать реализацию
        E oldValue = (E) array[index];
        System.arraycopy(array,index+1, array, index, array.length-index-1);
        array[array.length-1] = null;
        count--;
        return oldValue;
    }

    @Override
    public E get(int index) {
        //todo написать реализацию
        return (E) array[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int iterCount = 0;

            @Override
            public boolean hasNext() {
                return iterCount < count;
            }

            @Override
            public E next() {
                E current = (E) array[iterCount];
                iterCount++;
                return current;
            }
        };
    }
}
