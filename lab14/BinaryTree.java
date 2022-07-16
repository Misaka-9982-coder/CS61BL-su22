import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BinaryTree<T> {

    protected TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode t) {
        root = t;
    }

    public BinaryTree(ArrayList<T> pre,  ArrayList<T> in) {
        root = build(pre, in);
    }

    private TreeNode build(ArrayList<T> pre, ArrayList<T> in) {
        // TODO
        Map<T, Integer> positionMap = new HashMap<T, Integer>();
        for (int i = 0; i < pre.size(); i ++ ) {
            positionMap.put(pre.get(i), i);
        }
        return buildHelper(pre, in, 0, pre.size() - 1, 0, in.size() - 1, positionMap);
    }

    private TreeNode buildHelper(ArrayList<T> pre, ArrayList<T> in, int preStart, int preEnd, int inStart, int inEnd, Map<T, Integer> positionMap) {
        if (preStart > preEnd) {
            return null;
        }
        int len = positionMap.get(pre.get(preStart)) - inStart;
        TreeNode root = new TreeNode(pre.get(preStart));
        root.left = buildHelper(pre, in, preStart + 1, preStart + len, inStart, inStart + len - 1, positionMap);
        root.right = buildHelper(pre, in, preStart + len + 1, preEnd, inStart + len + 1, inEnd, positionMap);
        return root;
    }

    /* Print the values in the tree in preorder. */
    public void printPreorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printPreorder();
            System.out.println();
        }
    }

    /* Print the values in the tree in inorder. */
    public void printInorder() {
        // TODO: YOUR CODE HERE
        if(root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printInorder();
            System.out.println();
        }
    }

    /* Prints the BinaryTree in preorder or in inorder. Used for your testing. */
    protected static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        System.out.println();
    }

    protected class TreeNode {

        T item;
        TreeNode left;
        TreeNode right;
        int size = 0;

        public TreeNode(T item) {
            this.item = item; left = right = null;
        }

        public TreeNode(T item, TreeNode left, TreeNode right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }

        /* Prints the nodes of the BinaryTree in preorder. Used for your testing. */
        private void printPreorder() {
            System.out.print(item + " ");
            if (left != null) {
                left.printPreorder();
            }
            if (right != null) {
                right.printPreorder();
            }
        }

        /* Prints the nodes of the BinaryTree in inorder. Used for your testing. */
        private void printInorder() {
            // TODO: YOUR CODE HERE
            if(left != null) {
                left.printInorder();
            }
            System.out.print(item + " ");
            if(right != null) {
                right.printInorder();
            }
        }
    }
}