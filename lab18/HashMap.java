import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashMap <K, V> implements Map61BL<K, V> {

    /* TODO: Instance variables here */

    private int size;
    private int capacity;

    private double loadFactor;

    private HashSet<K> keys;

    Entry[] HashTable;

    /* TODO: Constructors here */

    public HashMap() {
        this.size = 0;
        this.capacity = 16;
        this.loadFactor = 0.75;
        HashTable = new Entry[capacity];
    }

    public HashMap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.loadFactor = 1;
        HashTable = new Entry[capacity];
    }

    public HashMap(int capacity, double loadFactor) {
        this.size = 0;
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        HashTable = new Entry[capacity];
    }

    public int capacity() {
        return capacity;
    }

    public int hashCode(K key) {
        int index =  (int) (Math.abs(key.hashCode()) % capacity);
        while(HashTable[index] != null && HashTable[index].key != key) {
            index = (index + 1) % capacity;
        }
        return index;
    }

    /* TODO: Interface methods here */

    @Override
    public void clear() {
        this.size = 0;
        this.capacity = 16;
        HashTable = new Entry[16];
    }

    @Override
    public boolean containsKey(K key) {
        int index = hashCode(key);
        if(HashTable[index] == null) {
            return false;
        }
        return HashTable[index].key == key;
    }

    @Override
    public V get(K key) {
        int index = hashCode(key);
        return (V) HashTable[index].value;
    }

    @Override
    public void put(K key, V value) {
        if (size >= capacity * loadFactor) {
            resize();
        }
        int index = hashCode(key);
        Entry entry = new Entry(key, value);
        HashTable[index] = entry;
        this.size ++ ;
    }

    public void resize() {
        capacity = capacity * 2;
        Entry[] tmp = new Entry[capacity];
        for (int i = 0; i < size; i++) {
            if (HashTable[i] != null) {
                tmp[i] = HashTable[i];
            }
        }
        HashTable = tmp;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean remove(K key, V value) {
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private static class Entry<K, V> {

        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /* Returns true if this key matches with the OTHER's key. */
        public boolean keyEquals(Entry other) {
            return key.equals(other.key);
        }

        /* Returns true if both the KEY and the VALUE match. */
        @Override
        public boolean equals(Object other) {
            return (other instanceof Entry
                    && key.equals(((Entry) other).key)
                    && value.equals(((Entry) other).value));
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }
}