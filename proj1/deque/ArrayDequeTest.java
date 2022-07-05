package deque;

import org.junit.Test;

import static org.junit.Assert.*;

/* Performs some basic array deque tests. */
public class ArrayDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * ArrayDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. */

    //public static Deque<Integer> ad = new ArrayDeque<Integer>();
    public static Deque<Integer> ad = new ArrayDeque<Integer>();

    @Test
    public void testAddFirst() {
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        ad.addFirst(4);
        ad.addFirst(5);
        assertEquals(5, ad.size());
        assertEquals(5, (int)ad.removeFirst());
        assertEquals(4, (int)ad.removeFirst());
        assertEquals(3, (int)ad.removeFirst());
        assertEquals(2, (int)ad.removeFirst());
        assertEquals(1, (int)ad.removeFirst());
        assertEquals(0, ad.size());
    }

    @Test
    public void testAddLast() {
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        ad.addLast(4);
        ad.addLast(5);
        assertEquals(5, ad.size());
        assertEquals(1, (int)ad.removeFirst());
        assertEquals(2, (int)ad.removeFirst());
        assertEquals(3, (int)ad.removeFirst());
        assertEquals(4, (int)ad.removeFirst());
        assertEquals(5, (int)ad.removeFirst());
        assertEquals(0, ad.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(ad.isEmpty());
        ad.addFirst(1);
        assertFalse(ad.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, ad.size());
        ad.addFirst(1);
        assertEquals(1, ad.size());
        ad.addLast(2);
        assertEquals(2, ad.size());
        ad.removeFirst();
        assertEquals(1, ad.size());
        ad.removeLast();
        assertEquals(0, ad.size());
    }

    @Test
    public void testRemoveFirst() {
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        ad.addFirst(4);
        ad.addFirst(5);
        assertEquals(5, ad.size());
        assertEquals(5, (int)ad.removeFirst());
        assertEquals(4, (int)ad.removeFirst());
        assertEquals(3, (int)ad.removeFirst());
        assertEquals(2, (int)ad.removeFirst());
        assertEquals(1, (int)ad.removeFirst());
        assertEquals(0, ad.size());
    }

    @Test
    public void testRemoveLast() {
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        ad.addLast(4);
        ad.addLast(5);
        assertEquals(5, ad.size());
        assertEquals(1, (int)ad.removeFirst());
        assertEquals(2, (int)ad.removeFirst());
        assertEquals(3, (int)ad.removeFirst());
        assertEquals(4, (int)ad.removeFirst());
        assertEquals(5, (int)ad.removeFirst());
        assertEquals(0, ad.size());
    }

    @Test
    public void testGetIndex() {
        for(int i = 0; i < 100; i ++ ) {
            ad.addLast(i);
            Integer tmp = i;
            assertEquals(tmp, ad.get(i));
        }

        for(int i = 0; i < 100; i ++ ) {
            Integer tmp = ad.get(0);
            ad.removeFirst();
            Integer tmp1 = i;
            assertEquals(tmp1, tmp);
        }
    }

    @Test
    public void testEquals() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();
        assertTrue(ad1.equals(ad2));
        ad1.addFirst(1);
        ad2.addFirst(1);
        assertTrue(ad1.equals(ad2));
        ad1.addLast(2);
        ad2.addLast(2);
        assertTrue(ad1.equals(ad2));
        ad1.removeFirst();
        ad2.removeFirst();
        assertTrue(ad1.equals(ad2));
        ad1.removeLast();
        ad2.removeLast();
        assertTrue(ad1.equals(ad2));
    }

    @Test
    public void multipleParamsTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();
        ArrayDeque<String> ad2 = new ArrayDeque<String>();
        assertTrue(ad1.equals(ad2));
        ad1.addFirst("1");
        ad2.addFirst("1");
        assertTrue(ad1.equals(ad2));
    }
}
