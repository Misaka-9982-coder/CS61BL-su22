import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testHeight() {
        BinaryTree t;
        t = new BinaryTree();
        t.sampleTree1();
        BinaryTree.print(t, "sample tree 1");
        System.out.println("Height of empty tree is " + t.height());
        System.out.println("================================================");
        t.sampleTree2();
        BinaryTree.print(t, "sample tree 2");
        System.out.println("Height of empty tree is " + t.height());
        System.out.println("================================================");
        t.sampleTree3();
        BinaryTree.print(t, "sample tree 3");
        System.out.println("Height of empty tree is " + t.height());
        System.out.println("================================================");
        t.sampleTree4();
        BinaryTree.print(t, "sample tree 4");
        System.out.println("Height of empty tree is " + t.height());
    }

    @Test
    public void testIsCompletelyBalanced() {
        BinaryTree t;
        t = new BinaryTree();
        t.sampleTree1();
        BinaryTree.print(t, "sample tree 1");
        System.out.println("Is tree completely balanced? " + t.isCompletelyBalanced());
        System.out.println("================================================");
        t.sampleTree2();
        BinaryTree.print(t, "sample tree 2");
        System.out.println("Is tree completely balanced? " + t.isCompletelyBalanced());
        System.out.println("================================================");
        t.sampleTree3();
        BinaryTree.print(t, "sample tree 3");
        System.out.println("Is tree completely balanced? " + t.isCompletelyBalanced());
        System.out.println("================================================");
        t.sampleTree4();
        BinaryTree.print(t, "sample tree 4");
        System.out.println("Is tree completely balanced? " + t.isCompletelyBalanced());
    }

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
