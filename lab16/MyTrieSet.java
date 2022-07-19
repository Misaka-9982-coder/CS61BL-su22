import java.util.HashMap;
import java.util.List;

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
            }

            if(index == key.length() - 1) {
                return node.children.get(c).isWord;
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

            if(index == key.length() - 1) {
                node.children.get(c).isWord = true;
                node.children.get(c).word = key;
            }

            index ++ ;
            node = node.children.get(c);
        }
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        List<String> result = new java.util.ArrayList<>();
        int index = 0;
        TrieNode node = root;

        System.out.println("root children size : " + root.children.size());

        while(index < prefix.length()) {
            int c = prefix.charAt(index) - 'a';

            char ch = (char) (c + 'a');

            node = node.children.get(c);
            index ++ ;

            System.out.println("node children size : " + node.children.size() + " char : " + ch);

            if(index == prefix.length()) {
                for(TrieNode child : node.children.values()) {
                    DFSChild(child, result);
                }
                break;
            }
        }

        System.out.println("result: " + result);
        return result;
    }

    String DFSChild(TrieNode node, List<String> result) {
        if(node == null) {
            return "";
        }

        if(node.isWord) {
            result.add(node.word);
        }

        for(TrieNode child : node.children.values()) {
            return DFSChild(child, result);
        }

        return "";
    }

    @Override
    public String longestPrefixOf(String key) {
        int index = 0;
        TrieNode node = root;

        while(index < key.length()) {
            int c = key.charAt(index) - 'a';

            if(node.children.get(c) == null) {
                return key.substring(0, index);
            }

            if(index == key.length() - 1) {
                return node.children.get(c).word;
            }

            node = node.children.get(c);
            index ++ ;
        }

        return "";
    }
}
