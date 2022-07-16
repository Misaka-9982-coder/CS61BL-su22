import edu.princeton.cs.algs4.Queue;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class BinaryTreeTest {
    @Test
    public void treeFormatTest() {
        BinarySearchTree<String> x = new BinarySearchTree<String>();
        x.add("C");
        x.add("A");
        x.add("E");
        x.add("B");
        x.add("D");
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outContent));
        BinaryTree.print(x, "x");
        System.setOut(oldOut);
        assertEquals("x in preorder\nC A B E D \nx in inorder\nA B C D E \n\n".trim(),
                     outContent.toString().trim());
    }

    @Test
    public void testAddKey() {
        BinarySearchTree<String> x = new BinarySearchTree<String>();
        x.add("C");
        x.add("C");
        x.add("C");
        x.add("C");
        x.add("C");
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outContent));
        BinaryTree.print(x, "x");
        System.setOut(oldOut);
        assertEquals("x in preorder\nC \nx in inorder\nC \n\n".trim(),
                outContent.toString().trim());
    }

    @Test
    public void testBuildBinaryTree() {
        ArrayList<String> preList = new ArrayList<String>();
        preList.add("C");
        preList.add("A");
        preList.add("B");
        preList.add("E");
        preList.add("D");
        System.out.println(preList);
        ArrayList<String> inList = new ArrayList<String>();
        inList.add("A");
        inList.add("B");
        inList.add("C");
        inList.add("D");
        inList.add("E");
        System.out.println(inList);
        BinaryTree<String> x = new BinaryTree(preList, inList);
        x.printPreorder();
//        x.printInorder();
        Queue<BinaryTree.TreeNode> q = new Queue<BinaryTree.TreeNode>();
        q.enqueue(x.root);
        while(!q.isEmpty()) {
            BinaryTree.TreeNode node = q.dequeue();
            System.out.print(node.item + " ");
            if(node.left != null) {
                q.enqueue(node.left);
            }
            if(node.right != null) {
                q.enqueue(node.right);
            }
        }
    }
}