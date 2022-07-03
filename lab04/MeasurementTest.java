import org.junit.Test;

import static org.junit.Assert.*;

public class MeasurementTest {
    @Test
    public void test1() {
        // TODO: stub for first test
        Measurement measurement = new Measurement();
        assertNotNull(measurement);
    }

    // TODO: Add additional JUnit tests for Measurement.java here.
    @Test
    public void getFeetTest() {
        Measurement measurement = new Measurement(1);
        assertEquals(1, measurement.getFeet());

        Measurement m1 = new Measurement(2);
        assertEquals(2, m1.getFeet());

        Measurement m2 = new Measurement(3);
        assertEquals(3, m2.getFeet());
    }
    @Test
    public void getInchesTest() {
        Measurement measurement = new Measurement(1,2);
        assertEquals(2, measurement.getInches());

        Measurement m1 = new Measurement(2, 3);
        assertEquals(3, m1.getInches());

        Measurement m2 = new Measurement(3, 4);
        assertEquals(4, m2.getInches());
    }
    @Test
    public void plusTest() {
        Measurement measurement = new Measurement(1,2);
        Measurement m1 = new Measurement(2, 3);
        Measurement m2 = measurement.plus(m1);
        assertEquals(3, m2.getFeet());
        assertEquals(5, m2.getInches());

        Measurement m3 = new Measurement(3, 4);
        Measurement m4 = new Measurement(4, 5);
        Measurement m5 = m3.plus(m4);
        assertEquals(7, m5.getFeet());
        assertEquals(9, m5.getInches());
    }
    @Test
    public void minusTest() {
        Measurement m1 = new Measurement(1,2);
        Measurement m2 = new Measurement(2, 3);
        Measurement m3 = m1.minus(m2);
        assertEquals(-1, m3.getFeet());
        assertEquals(-1, m3.getInches());

        Measurement m4 = new Measurement(3, 4);
        Measurement m5 = new Measurement(4, 5);
        Measurement m6 = m4.minus(m5);
        assertEquals(-1, m6.getFeet());
        assertEquals(-1, m6.getInches());
    }
    @Test
    public void multipleTest() {
        Measurement m1 = new Measurement(1,2);
        Measurement m2 = m1.multiple(3);
        assertEquals(3, m2.getFeet());
        assertEquals(6, m2.getInches());

        Measurement m3 = new Measurement(3, 4);
        Measurement m4 = m3.multiple(5);
        assertEquals(15, m4.getFeet());
        assertEquals(20, m4.getInches());
    }
    @Test
    public void toStringTest() {
        Measurement m1 = new Measurement(1,2);
        assertEquals("1'2\"", m1.toString());

        Measurement m2 = new Measurement(3, 4);
        assertEquals("3'4\"", m2.toString());

        Measurement m3 = new Measurement(5, 6);
        assertEquals("5'6\"", m3.toString());
    }
}