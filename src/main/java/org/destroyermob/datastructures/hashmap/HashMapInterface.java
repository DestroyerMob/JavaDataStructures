package org.destroyermob.datastructures.hashmap;

public interface HashMapInterface<K, V> {
    public int size();
    public int hash(K key);
    public void put(K key, V value);
    public V get(K key);
    public void remove(K key);
}
