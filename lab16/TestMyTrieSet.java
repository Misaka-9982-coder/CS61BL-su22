import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

/**
 * Created by Jenny Huang on 3/12/19.
 */
public class TestMyTrieSet {
    
    
    //Write your own test for add! Do this before running the other tests.

    // assumes add/contains work
    @Test
    public void basicClearTest() {
         MyTrieSet t = new MyTrieSet();
         for (int i = 0; i < 455; i++) {
             t.add("hi" + i);
             //make sure put is working via contains
             assertTrue(t.contains("hi" + i));
         }
         t.clear();
         for (int i = 0; i < 455; i++) {
             assertFalse(t.contains("hi" + i));
         }
    }

    // assumes add works
    @Test
    public void basicContainsTest() {
         MyTrieSet t = new MyTrieSet();
         assertFalse(t.contains("waterYouDoingHere"));
         t.add("waterYouDoingHere");
         t.contains("waterYouDoingHere");
         assertTrue(t.contains("waterYouDoingHere"));
    }

    @Test
    public void basicAddTest() {
        MyTrieSet t = new MyTrieSet();
        String[] saStrings = new String[]{"same", "sam", "sad", "sap"};
        for (String s: saStrings) {
            t.add(s);
        }

        for (String s: saStrings) {
             assertTrue(t.contains(s));
         }

    }

    // assumes add works
    @Test
    public void basicPrefixTest() {
         String[] saStrings = new String[]{"same", "sam", "sad", "sap"};
         String[] otherStrings = new String[]{"a", "awls", "hello"};

         MyTrieSet t = new MyTrieSet();
         for (String s: saStrings) {
             t.add(s);
         }
         for (String s: otherStrings) {
             t.add(s);
         }

         List<String> keys = t.keysWithPrefix("sa");
         for (String s: saStrings) {
             assertTrue(keys.contains(s));
         }
         for (String s: otherStrings) {
             assertFalse(keys.contains(s));
         }
    }

    @Test
    public void testLongestPrefix() {
        MyTrieSet t = new MyTrieSet();
        t.add("same");
        t.add("sam");
        t.add("sad");
        t.add("sap");
        assertEquals("same", t.longestPrefixOf("same"));
        assertEquals("sam", t.longestPrefixOf("sam"));
        assertEquals("sad", t.longestPrefixOf("sad"));
        assertEquals("sap", t.longestPrefixOf("sap"));
        assertEquals("", t.longestPrefixOf(""));
        assertEquals("", t.longestPrefixOf("a"));
        assertEquals("", t.longestPrefixOf("ab"));
        assertEquals("", t.longestPrefixOf("abc"));
        assertEquals("", t.longestPrefixOf("abcd"));
        assertEquals("", t.longestPrefixOf("abcde"));
        assertEquals("", t.longestPrefixOf("abcdef"));
        assertEquals("", t.longestPrefixOf("abcdefg"));
        assertEquals("", t.longestPrefixOf("abcdefgh"));
        assertEquals("", t.longestPrefixOf("abcdefghi"));
        assertEquals("", t.longestPrefixOf("abcdefghij"));
        assertEquals("", t.longestPrefixOf("abcdefghijk"));
        assertEquals("", t.longestPrefixOf("abcdefghijkl"));
        assertEquals("", t.longestPrefixOf("abcdefghijklm"));
        assertEquals("", t.longestPrefixOf("abcdefghijklmn"));
        assertEquals("", t.longestPrefixOf("abcdefghijklmno"));
        assertEquals("", t.longestPrefixOf("abcdefghijklmnop"));
        assertEquals("", t.longestPrefixOf("abcdefghijklmnopq"));
        assertEquals("sa", t.longestPrefixOf("sabsad"));
        assertEquals("s", t.longestPrefixOf("ssbsad"));
    }
}
