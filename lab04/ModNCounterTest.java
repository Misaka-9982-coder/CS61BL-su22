import org.junit.Test;

import static org.junit.Assert.*;

class ModNCounterTest {

    @Test
    public void increment() {
        ModNCounter counter = new ModNCounter(2);
        counter.increment();
        assertEquals(1, counter.value());
        counter.increment();
        assertEquals(0, counter.value());
    }

    @Test
    public void reset() {
        ModNCounter counter = new ModNCounter(2);
        counter.increment();
        counter.reset();
        assertEquals(0, counter.value());
    }

    public void testConstructor() {
        ModNCounter counter = new ModNCounter(3);
        assertEquals(0, counter.value());
        assertEquals(3, counter.getMyMod());
    }

    public void failedTest() {
        ModNCounter counter = new ModNCounter(3);
        assertEquals(1, counter.value());
    }

    public static void main(String[] args) {
        ModNCounterTest test = new ModNCounterTest();
        test.testConstructor();
        test.increment();
        test.reset();
    }
}