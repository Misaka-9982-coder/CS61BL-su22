package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list deque tests. */
public class LinkedListDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * LinkedListDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. Please do not import java.util.Deque here!*/

    public static Deque<Integer> lld = new LinkedListDeque<Integer>();

    @Test
    /** Adds a few things to the list, checks that isEmpty() is correct.
     * This is one simple test to remind you how junit tests work. You
     * should write more tests of your own.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement)." +
                " The code you submit to the AG shouldn't have any print statements!");
        /*
		assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());
		lld.addFirst(0);

        assertFalse("lld1 should now contain 1 item", lld.isEmpty());

        lld = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!
		*/
        lld.addFirst(0);
        assertFalse("lld should now contain 1 item", lld.isEmpty());

        lld.addLast(1);
        assertFalse("lld should now contain 2 items", lld.isEmpty());

        lld.addFirst(2);
        assertFalse("lld should now contain 3 items", lld.isEmpty());

        lld.removeFirst();
        lld.removeFirst();
        lld.removeFirst();
    }

    /** Adds an item, removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        lld.addFirst(0);
        lld.removeFirst();
        assertTrue("lld should be empty after removing the only item", lld.isEmpty());

        lld.addLast(1);
        lld.removeLast();
        assertTrue("lld should be empty after removing the only item", lld.isEmpty());
    }
    /** Make sure that removing from an empty LinkedListDeque does nothing */
    @Test
    public void removeEmptyTest() {
        lld.removeFirst();
        assertTrue(lld.isEmpty());

        lld.removeLast();
        assertTrue(lld.isEmpty());

        lld.removeFirst();
        lld.removeLast();
        assertTrue(lld.isEmpty());
    }
    /** Make sure your LinkedListDeque also works on non-Integer types */
    @Test
    public void multipleParamsTest() {

    }
    /** Make sure that removing from an empty LinkedListDeque returns null */
    @Test
    public void emptyNullReturn() {
        for(int i = 0; i < 100; i ++ ) {
            assertNull(lld.removeFirst());
            assertNull(lld.removeLast());
        }
    }
    /** TODO: Write tests to ensure that your implementation works for really large
     * numbers of elements, and test any other methods you haven't yet tested!
     */

    @Test
    public void sizeTest() {
        for(int i = 0; i < 100; i ++ ) {
            lld.addFirst(i);
            assertEquals(i + 1, lld.size());
        }

        for(int i = 100; i > 0; i -- ) {
            lld.removeFirst();
            assertEquals(i - 1, lld.size());
        }
    }

    @Test
    public void printDequeTest() {
        for(int i = 0; i < 100; i ++ ) {
            lld.addFirst(i);
            lld.printDeque();
        }

        for(int i = 0; i < 100; i ++ ) {
            lld.removeFirst();
        }
    }

    @Test
    public void getIndexTest() {
        for(int i = 0; i < 100; i ++ ) {
            lld.addLast(i);
            Integer tmp = i;
            assertEquals(tmp, lld.get(i));
        }

        for(int i = 0; i < 100; i ++ ) {
            lld.removeFirst();
        }

        for(int i = 99; i >= 0; i -- ) {
            lld.addFirst(i);
            Integer tmp = i;
            assertEquals(tmp, lld.get(0));
        }

        for(int i = 0; i < 100; i ++ ) {
            lld.removeLast();
        }
    }

    @Test
    public void equalsTest() {
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>();
        for(int i = 0; i < 100; i ++ ) {
            lld.addLast(i);
            lld2.addLast(i);

            assertTrue(lld.equals(lld2));
        }

        lld2.addLast(1);
        assertFalse(lld.equals(lld2));

        for(int i = 0; i < 100; i ++ ) {
            lld.removeFirst();
        }
    }
}
