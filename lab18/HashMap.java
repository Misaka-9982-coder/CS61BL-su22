import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

public class HashMap <K, V> implements Map61BL<K, V>, Iterable<K> {

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
        this.loadFactor = 0.75;
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
        Entry entry = HashTable[index];
        if (entry == null) {
            return null;
        }
        return (V) HashTable[index].value;
    }

    @Override
    public void put(K key, V value) {
        if (size >= Math.floor(capacity * loadFactor)) {
            resize();
        }

        int index = hashCode(key);
        Entry entry = new Entry(key, value);

        V v = get(key);
        if (v == null) {
            this.size ++ ;
        }

        HashTable[index] = entry;
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
        int index = hashCode(key);
        if(HashTable[index] != null && HashTable[index].key == key) {
            V value = (V) HashTable[index].value;
            HashTable[index] = null;
            this.size -- ;
            return value;
        }
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
        return new HashMapIterator<K>();
    }

    private class HashMapIterator<K> implements Iterator<K> {

        int cnt;
        int cur = 0;
        public HashMapIterator() {
            cnt = 0;
            cur = 0;
        }

        @Override
        public boolean hasNext() {
            return cnt < size;
        }

        @Override
        public K next() {
            if(!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            while (HashTable[cur] == null) {
                cur = (cur + 1) % capacity;
            }
            K res = (K) HashTable[cur].key;
            cur ++ ;
            cnt ++ ;
            return res;
        }
    }

    public static class Entry<K, V> {

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