package collections.impl;

import collections.Map;

public class HashMap<K, V> implements Map<K, V> {

    //Для упрощения кода размер массива корзин будет постоянен (16).
    //Увеличение массива уже было реализовано в ArrayList
    private final int length = 16;
    private Node[] nodes = new Node[length];
    private int count = 0;

    class Node<K,V> {
        final int hash;
        final K key;
        private V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private int indexFor(int h, int length)
    {
        return h & (length - 1);
    }

    @Override
    public boolean insert(K key, V value) {
        //todo написать реализацию. Коллизии обрабатывать не надо
        int hash = hash(key);
        int place = indexFor(hash, length);
        Node<K,V> node = new Node<>(hash,key,value,null);
        if (count == 0){
            nodes[place] = node;
            count++;
        } else {
            if (nodes[place] == null){
                nodes[place] = node;
                count++;
            } else {
                Node temp = nodes[place];
                while (temp.next != null){
                    temp = temp.next;
                }
                temp.next = node;
                count++;
            }
        }
        return true;
    }

    @Override
    public V get(K key) {
        //todo написать реализацию
        int hash = hash(key);
        int place = indexFor(hash, length);
        Node node = nodes[place];
        while (!node.getKey().equals(key)){
            node = node.next;
            if (node == null) return null;
        }
        return (V) node.getValue();
    }

    @Override
    public boolean delete(K key) {
        //todo написать реализацию
        int countNodes = 0;
        boolean hasKey = false;

        int hash = hash(key);
        int place = indexFor(hash, length);
        Node node = nodes[place];

        while (!hasKey){
            if (node.getKey().equals(key)){
                hasKey = true;
            } else {
                if (node.next == null) break;
                else {
                    node = node.next;
                    countNodes++;
                }
            }
        }

        if (hasKey){
            Node tmp = nodes[place];
            if (countNodes == 0){
                if (tmp.next == null) nodes[place] = null;
                else nodes[place] = tmp.next;
            } else {
                for (int i = 0; i < countNodes-1; i++){
                    tmp = tmp.next;
                }
                if (node.next == null){
                    tmp.next = null;
                } else {
                    tmp.next = node.next;
                }
            }
            count--;
            return true;
        } else {
            return false;
        }
    }
}
