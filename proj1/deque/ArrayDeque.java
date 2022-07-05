package deque;

public class ArrayDeque<T> implements Deque<T>{

    private T[] items;
    private int maxSize;
    private int size;

    public ArrayDeque() {
        this.maxSize = 500;
        items = (T[]) new Object[maxSize];
        size = 0;
    }

    public ArrayDeque(int maxSize) {
        this.maxSize = maxSize;
        this.items = (T[]) new Object[maxSize];
        this.size = 0;
    }

    @Override
    public void addFirst(T item) {
        if (size == maxSize) {
            T[] newItems = (T[]) new Object[maxSize * 2];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
            newItems = null;
        }

        for(int i = size; i > 0; i -- ) {
            items[i] = items[i - 1];
        }

        items[0] = item;
        size ++ ;
    }

    @Override
    public void addLast(T item) {
        if (size == maxSize) {
            T[] newItems = (T[]) new Object[maxSize * 2];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
            newItems = null;
        }

        items[size ++ ] = item;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for(int i = 0; i < size; i ++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        T res = items[0];
        for(int i = 0; i < size - 1; i ++) {
            items[i] = items[i + 1];
        }
        items[size - 1] = null;
        size -- ;
        return res;
    }

    @Override
    public T removeLast() {
        T res = items[size - 1];
        items[size - 1] = null;
        size -- ;
        return null;
    }

    @Override
    public T get(int index) {
        return items[index];
    }

    public boolean equals(Object o) {
        o = (ArrayDeque<T>) o;
        if(((ArrayDeque<?>) o).size() != this.size) {
            return false;
        }

        for(int i = 0; i < size; i ++ ) {
            if(!items[i].equals(((ArrayDeque<T>) o).items[i])) {
                return false;
            }
        }
        return true;
    }
}
