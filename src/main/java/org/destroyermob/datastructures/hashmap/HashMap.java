package org.destroyermob.datastructures.hashmap;

import java.util.*;

public class HashMap<K, V> implements HashMapInterface<K, V> {

    private int size = 0;

    @SuppressWarnings("unchecked")
    private List<Entry<K, V>>[] keyValuePairs =  new List[256];

    @Override
    public int size() {
        return size;
    }

    @Override
    public int hash(K key) {
        String keyString = key.toString();

        byte f1 = (byte) keyString.charAt(0);
        byte f2 = (byte) keyString.charAt(0);

        if (keyString.length() > 1) {
            f1 = (byte) (keyString.charAt(0) + keyString.charAt(1));
            f2 = (byte) (keyString.charAt(keyString.length() - 1) + keyString.charAt(keyString.length() - 2));
        }

        f1 = (byte) (f1 << 2);

        byte f3 = (byte) (f1 | f2);

        return f3 & 0xFF;
    }

    @Override
    public void put(K key, V value) {
        size++;
        boolean collision = false;
        int index = hash(key) % keyValuePairs.length;
        if (keyValuePairs[index] == null)
            keyValuePairs[index] = new ArrayList<>();
        else {
            for (Entry<K, V> entry : keyValuePairs[index]) {
                if (entry.key.equals(key))
                    collision = true;
            }
        }
        if (!collision)
            keyValuePairs[index].add(new Entry<>(key, value));
        else
            System.out.println("Did not add key: " + key + ", key already exists");
    }

    @Override
    public V get(K key) {
        for (Entry<K, V> entry : keyValuePairs[hash(key) % keyValuePairs.length]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public void remove(K key) {
        for (Entry<K, V> entry : keyValuePairs[hash(key) % keyValuePairs.length]) {
            if (entry.key.equals(key)) {
                keyValuePairs[hash(key) % keyValuePairs.length].remove(entry);
            }
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
