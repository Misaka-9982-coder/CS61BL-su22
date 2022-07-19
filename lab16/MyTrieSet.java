import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MyTrieSet implements TrieSet61BL {

    private TrieNode root;

    static class TrieNode {
        final HashMap<Integer, TrieNode> children;
        boolean isWord;
        String word;

        TrieNode() {
            children = new HashMap<>();
            isWord = false;
            word = null;
        }
    }

    MyTrieSet() {
        root = new TrieNode();
    }

    @Override
    public void clear() {
        root = new TrieNode();
    }

    @Override
    public boolean contains(String key) {
        int index = 0;
        TrieNode node = root;
        while(index < key.length()) {
            int c = key.charAt(index) - 'a';
            if(node.children.get(c) == null) {
                return false;
            } else if (node.isWord) {
                return true;
            }
            node = node.children.get(c);
            index ++ ;
        }
        return false;
    }

    @Override
    public void add(String key) {
        int index = 0;
        TrieNode node = root;
        while(index < key.length()) {
            int c = key.charAt(index) - 'a';
            if(node.children.get(c) == null) {
                node.children.put(c, new TrieNode());
            }
            index ++ ;
        }
        node.isWord = true;
        node.word = key;
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        List<String> result = new java.util.ArrayList<>();

        return result;
    }

    @Override
    public String longestPrefixOf(String key) {
        return null;
    }
}
