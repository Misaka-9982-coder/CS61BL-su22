import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testFibTree() {
        BinaryTree<Integer> fibTree;
        fibTree = BinaryTree.fibTree(0);
        BinaryTree.print(fibTree, "fibTree(0)");
        fibTree = BinaryTree.fibTree(1);
        BinaryTree.print(fibTree, "fibTree(1)");
        fibTree = BinaryTree.fibTree(2);
        BinaryTree.print(fibTree, "fibTree(2)");
        fibTree = BinaryTree.fibTree(3);
        BinaryTree.print(fibTree, "fibTree(3)");
        fibTree = BinaryTree.fibTree(4);
        BinaryTree.print(fibTree, "fibTree(4)");
        fibTree = BinaryTree.fibTree(5);
        BinaryTree.print(fibTree, "fibTree(5)");
    }
}
