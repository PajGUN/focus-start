package collections;

public interface Map<K, V> {

    boolean insert(K key, V value);

    V get(K key);

    boolean delete(K key);
}