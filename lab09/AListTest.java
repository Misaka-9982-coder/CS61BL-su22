import org.junit.Test;
import static org.junit.Assert.*;

public class AListTest {

    @Test
    public void testFor() {
        AList<Integer> a = new AList<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        int count = 0;
        for (Integer i : a) {
            count += i;
        }
        assertEquals(6, count);
    }

    @Test
    public void testNext() {
        Integer[] list = new Integer[]{1, 2, 3, 4, 5};
        AList<Integer> aList = AList.of(list);
        Integer cnt = 1;
        for(Integer item : aList) {
            assertEquals(cnt, item);
            cnt ++ ;
        }
    }
}
