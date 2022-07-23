import java.util.HashSet;
import java.util.Iterator;

public class HashMap <K, V> implements Map61BL<K, V> {

    /* TODO: Instance variables here */

    private int size;
    private int capacity;

    private double loadFactor;

    private HashSet<K> keys;

    /* TODO: Constructors here */

    public HashMap() {
        this.size = 0;
        this.capacity = 16;
        this.loadFactor = 0.75;
    }

    public HashMap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.loadFactor = 1;
    }

    public HashMap(int capacity, double loadFactor) {
        this.size = 0;
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }

    public int capacity() {
        return capacity;
    }

    /* TODO: Interface methods here */

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void put(K key, V value) {

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

    private static class Entry {

        private String key;
        private String value;

        Entry(String key, String value) {
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