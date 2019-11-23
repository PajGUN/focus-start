package collections.impl;

import collections.Iterator;
import collections.List;

public class LinkedList<E> implements List<E> {
        private Node<E> first;
        private Node<E> last;
        private int count = 0;

    private class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

    }

    @Override
    public boolean add(E e) {
        //todo написать реализацию
        if (first == null || last == null){
            Node<E> node = new Node<>(null,e,null);
            first = node;
            last = node;
            count++;
        } else {
            Node<E> node = new Node<>(last,e,null);
            last.next = node;
            last = node;
            count++;
        }
        return true;
    }

    public boolean add(E e, int index) {
        //todo написать реализацию
        if (index == 0 && count == 0){
            add(e);
            count++;
            return true;
        }
        if (index < count){
            Node<E> match = first;
            for (int i = 0; i < count; i++ ){
                if (i == index){
                    if (i == 0){
                        first = new Node<>(null,e,match);
                        match.prev = first;
                    }
                    else {
                        Node<E> node = new Node<>(match.prev,e,match);
                        match.prev.next = node;
                        match.prev = node;
                        count++;
                    }
                    break;
                }
                match = match.next;
            }
        } else {
            throw new IndexOutOfBoundsException("Index > size of LinkedList");
        }
        return true;
    }

    @Override
    public E remove(int index) {
        //todo написать реализацию
        if (index < count){
            if (count == 1){
                E removableItem = first.item;
                first = null;
                last = null;
                count--;
                return removableItem;
            }

            if (index == 0) {
                E removableItem = first.item;
                first = first.next;
                first.prev = null;
                count--;
                return removableItem;
            }
            if (index == count-1) {
                E removableItem = last.item;
                last = last.prev;
                last.next = null;
                count--;
                return removableItem;
            }

            Node<E> match = first;
            for (int i = 1; i<count-1; i++){
                match = match.next;
                if (index == i) {
                    match.prev.next = match.next;
                    match.next.prev = match.prev;
                    match.prev = null;
                    match.next = null;
                    count--;
                    return match.item;
                }
            }
        } else {
            throw new IndexOutOfBoundsException("Index > size of LinkedList");
        }
        return null;
    }

    @Override
    public E get(int index) {
        //todo написать реализацию
        if (index < count){
            if (index == 0) return first.item;
            else if (index == count-1) return last.item;

            Node<E> match = first;
            for (int i = 1; i<count-1; i++){
                match = match.next;
                if (index == i) return match.item;
            }
        } else {
            throw new IndexOutOfBoundsException("Index > size of LinkedList");
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        //todo написать реализацию
        return new Iterator<E>() {
            private int iterCount = 0;
            Node<E> match = first;
            @Override
            public boolean hasNext() {
                return iterCount < count;
            }

            @Override
            public E next() {
                if (iterCount == 0) {
                    iterCount++;
                    return match.item;
                }
                else {
                    match = match.next;
                    iterCount++;
                    return match.item;
                }
            }
        };
    }
}
