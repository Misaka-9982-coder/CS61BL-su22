import edu.princeton.cs.algs4.BTree;
import org.junit.Test;

public class RedBlackTreeTest {

    @Test
    public void testRedBlackTreeConstructor() {
        TwoThreeTree Tree = new TwoThreeTree();
        Tree.root = new TwoThreeTree.TwoThreeNode<>(  3, 4);
        RedBlackTree<Integer> rbTree = new RedBlackTree<Integer>(Tree);
        System.out.println((rbTree.root != null));
        System.out.println((rbTree.root.left != null));
        System.out.println((rbTree.root.right == null));
        System.out.println((rbTree.root.isBlack));
        System.out.println((!rbTree.root.left.isBlack));
        System.out.println(3 == rbTree.root.left.item);
        System.out.println(4 == rbTree.root.item);
    }
}
