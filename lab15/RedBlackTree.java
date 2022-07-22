public class RedBlackTree<T extends Comparable<T>> {

    /* Root of the tree. */
    RBTreeNode<T> root;

    static class RBTreeNode<T> {

        final T item;
        boolean isBlack;
        RBTreeNode<T> left;
        RBTreeNode<T> right;

        /* Creates a RBTreeNode with item ITEM and color depending on ISBLACK
           value. */
        RBTreeNode(boolean isBlack, T item) {
            this(isBlack, item, null, null);
        }

        /* Creates a RBTreeNode with item ITEM, color depending on ISBLACK
           value, left child LEFT, and right child RIGHT. */
        RBTreeNode(boolean isBlack, T item, RBTreeNode<T> left,
                   RBTreeNode<T> right) {
            this.isBlack = isBlack;
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    /* Creates an empty RedBlackTree. */
    public RedBlackTree() {
        root = null;
    }

    /* Creates a RedBlackTree from a given 2-3 TREE. */
    public RedBlackTree(TwoThreeTree<T> tree) {
        Node<T> ttTreeRoot = tree.root;
        root = buildRedBlackTree(ttTreeRoot);
    }

    /* Builds a RedBlackTree that has isometry with given 2-3 tree rooted at
       given node R, and returns the root node. */
    RBTreeNode<T> buildRedBlackTree(Node<T> r) {
        if (r == null) {
            return null;
        }

        if (r.getItemCount() == 1) {
            // TODO: Replace with code to create a 2-node equivalent
<<<<<<< HEAD
            RBTreeNode<T> blackNode = new RBTreeNode<T>(true, r.getItemAt(0));
            RBTreeNode<T> blackLeft = buildRedBlackTree(r.getChildAt(0));
            RBTreeNode<T> blackRight = buildRedBlackTree(r.getChildAt(1));

            blackNode.left = blackLeft;
            blackNode.right = blackRight;

            return blackNode;
        } else {
            // TODO: Replace with code to create a 3-node equivalent
            RBTreeNode<T> redNode = new RBTreeNode<T>(false, r.getItemAt(0));
            RBTreeNode<T> blackNode = new RBTreeNode<T>(true, r.getItemAt(1));
            blackNode.left = redNode;

            RBTreeNode<T> redLeft = buildRedBlackTree(r.getChildAt(0));
            RBTreeNode<T> redRight = buildRedBlackTree(r.getChildAt(1));
            RBTreeNode<T> blackRight = buildRedBlackTree(r.getChildAt(2));

            redNode.left = redLeft;
            redNode.right = redRight;
            blackNode.right = blackRight;

            return blackNode;
=======
            return null;
        } else {
            // TODO: Replace with code to create a 3-node equivalent
            return null;
>>>>>>> 0ec5ff8e9de8d302f54afb70881fa224d87f6057
        }
    }

    /* Flips the color of NODE and its children. Assume that NODE has both left
       and right children. */
    void flipColors(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
<<<<<<< HEAD
        node.isBlack = !node.isBlack;
        node.left.isBlack = !node.left.isBlack;
        node.right.isBlack = !node.right.isBlack;
=======
>>>>>>> 0ec5ff8e9de8d302f54afb70881fa224d87f6057
    }

    /* Rotates the given node NODE to the right. Returns the new root node of
       this subtree. */
    RBTreeNode<T> rotateRight(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
<<<<<<< HEAD
        RBTreeNode<T> newRight = new RBTreeNode<T>(false, node.item, node.left.right, node.right);
        node = new RBTreeNode<T>(true, node.left.item, node.left.left, newRight);
        return node;
=======
        return null;
>>>>>>> 0ec5ff8e9de8d302f54afb70881fa224d87f6057
    }

    /* Rotates the given node NODE to the left. Returns the new root node of
       this subtree. */
    RBTreeNode<T> rotateLeft(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
<<<<<<< HEAD
        RBTreeNode<T> newLeft = new RBTreeNode<T>(false, node.item, node.left, node.right.left);
        node = new RBTreeNode<T>(true, node.right.item, newLeft, node.right.right);
        return node;
=======
        return null;
>>>>>>> 0ec5ff8e9de8d302f54afb70881fa224d87f6057
    }

    public void insert(T item) {
        root = insert(root, item);
        root.isBlack = true;
    }

    /* Inserts the given node into this Red Black Tree*/
    private RBTreeNode<T> insert(RBTreeNode<T> node, T item) {
        // Insert (return) new red leaf node.
        if (node == null) {
            return new RBTreeNode<>(false, item);
        }

        // Handle normal binary search tree insertion.
        int comp = item.compareTo(node.item);
        if (comp == 0) {
            return node; // do nothing.
        } else if (comp < 0) {
<<<<<<< HEAD
            // continue to search the left
            node.left = insert(node.left, item);
        } else {
            // continue to search the right
=======
            node.left = insert(node.left, item);
        } else {
>>>>>>> 0ec5ff8e9de8d302f54afb70881fa224d87f6057
            node.right = insert(node.right, item);
        }

        // handle "middle of three" and "right-leaning red" structures
<<<<<<< HEAD
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }

        // handle "smallest of three" structure
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        
        // handle "largest of three" structure
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        // TODO: YOUR CODE HERE
        return node; //fix this return statement
=======

        // handle "smallest of three" structure
        
        // handle "largest of three" structure
        
        // TODO: YOUR CODE HERE
        return null; //fix this return statement
>>>>>>> 0ec5ff8e9de8d302f54afb70881fa224d87f6057
    }

    /* Returns whether the given node NODE is red. Null nodes (children of leaf
       nodes are automatically considered black. */
    private boolean isRed(RBTreeNode<T> node) {
        return node != null && !node.isBlack;
    }

}
