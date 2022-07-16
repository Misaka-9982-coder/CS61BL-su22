public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    /* Creates an empty BST. Super() calls the constructor for BinaryTree (not in scope). */
    public BinarySearchTree() {
        super();
    }

    /* Creates a BST with root as ROOT. */
    public BinarySearchTree(TreeNode root) {
        super(root);
    }

    /* Returns true if the BST contains the given KEY. */
    public boolean contains(T key) {
        // TODO: YOUR CODE HERE
        if(root == null) {
            return false;
        }
        return containsHelper(root, key);
    }

    /* Adds a node for KEY iff KEY isn't in the BST already. */
    public void add(T key) {
        // TODO: YOUR CODE HERE
        if(root == null) {
            root = new TreeNode(key);
        }

        if(contains(key)) {
            return;
        }

        addHelper(null, root, key);
    }

    /* Deletes a node from the BST. 
     * Even though you do not have to implement delete, you 
     * should read through and understand the basic steps.
    */
    public T delete(T key) {
        TreeNode parent = null;
        TreeNode curr = root;
        TreeNode delNode = null;
        TreeNode replacement = null;
        boolean rightSide = false;

        while (curr != null && !curr.item.equals(key)) {
            if (curr.item.compareTo(key) > 0) {
                parent = curr;
                curr = curr.left;
                rightSide = false;
            } else {
                parent = curr;
                curr = curr.right;
                rightSide = true;
            }
        }
        delNode = curr;
        if (curr == null) {
            return null;
        }

        if (delNode.right == null) {
            if (root == delNode) {
                root = root.left;
            } else {
                if (rightSide) {
                    parent.right = delNode.left;
                } else {
                    parent.left = delNode.left;
                }
            }
        } else {
            curr = delNode.right;
            replacement = curr.left;
            if (replacement == null) {
                replacement = curr;
            } else {
                while (replacement.left != null) {
                    curr = replacement;
                    replacement = replacement.left;
                }
                curr.left = replacement.right;
                replacement.right = delNode.right;
            }
            replacement.left = delNode.left;
            if (root == delNode) {
                root = replacement;
            } else {
                if (rightSide) {
                    parent.right = replacement;
                } else {
                    parent.left = replacement;
                }
            }
        }
        return delNode.item;
    }

    private boolean containsHelper(TreeNode curr, T key) {
        if(curr == null) {
            return false;
        }

        if (curr.item.compareTo(key) < 0) {
            containsHelper(curr.left, key);
        } else if (curr.item.compareTo(key) > 0) {
            containsHelper(curr.right, key);
        } else {
            return true;
        }

        return false;
    }

    public void addHelper(TreeNode pre, TreeNode curr, T key) {
        if(curr == null) {
            curr = new TreeNode(key);
            if(pre.item.compareTo(key) > 0) {
                pre.left = curr;
            } else if(pre.item.compareTo(key) < 0) {
                pre.right = curr;
            }
        }

        if(curr.item.compareTo(key) > 0) {
            addHelper(curr, curr.left, key);
        } else if(curr.item.compareTo(key) < 0) {
            addHelper(curr, curr.right, key);
        }
    }
}
