package deque;

public class LinkedListDeque<T> implements Deque<T> {

    private class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node(T item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head, tail;

    private int size;

    public LinkedListDeque() {
        size = 0;
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void addFirst(T item) {
        size ++ ;
        Node newNode = new Node(item);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    @Override
    public void addLast(T item) {
        size ++ ;
        Node newNode = new Node(item);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
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

    }

    @Override
    public T removeFirst() {
        if(size == 0) {
            return null;
        }
        T res = head.next.item;
        head.next.next.prev = head;
        head.next = head.next.next;
        size -- ;
        return res;
    }

    @Override
    public T removeLast() {
        if(size == 0) {
            return null;
        }
        T res = tail.prev.item;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        size -- ;
        return res;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        Node cur = head.next;
        for(int i = 0; i < index; i ++) {
            cur = cur.next;
        }
        return cur.item;
    }

    @Override
    public boolean equals(Object o) {
        o = (LinkedListDeque) o;
        Node cur = head.next;
        Node cur2 = ((LinkedListDeque) o).head.next;
        while(cur != tail) {
            if(!cur.item.equals(cur2.item)) {
                return false;
            }
            cur = cur.next;
            cur2 = cur2.next;
        }

        if(cur2.next != null) {
            return false;
        }

        return true;
    }
}
