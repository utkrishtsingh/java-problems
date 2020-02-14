import java.util.Comparator;
import java.util.Optional;

public class BST {
    public static void main(String ...args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compare);
        // TODO: Perform delete and mirror operations
        bst.insert(1);
        bst.insert(0);
        bst.insert(2);
        // bst.delete(3);s
        System.out.println(bst.search(4).toString());
        System.out.println(bst.search(0).get().getValue());
        System.out.println(bst.height());
    }
}

class BinarySearchTree<T> {
    private Node<T> root;
    // private int size;
    private Comparator<T> comparator;

    /* Constructors */
    private BinarySearchTree() {
        throw new AssertionError("Need a comparator to initialize generic value binary tree");
    }

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
        // this.size = 0;
        this.root = null;
    }

    /* Methods */

    /* Height */
    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    /* --- */

    /* Insert */
    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) return new Node(value);
        int compareValue = comparator.compare(node.getValue(), value);
        if (compareValue < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (compareValue > 0){
            node.setRight(insert(node.getRight(), value));
        } //Not implemented for equals
        return node;
    }

    /* --- */

    /* Utilities */

    /* Minimum Value Node */
    private Node<T> min(Node<T> node) {
        if (node.getLeft() == null) return node;
        else return min(node.getLeft());
    }

    /* Delete Minimum Value Node */
    private Node<T> deleteMin(Node<T> node) {
        if (node.getLeft() == null) return node.getRight();
        node.setLeft(deleteMin(node.getLeft()));
        return node;
    }

    /* Maximum Value Node */
    private Node<T> max(Node<T> node) {
        if (node.getRight() == null) return node;
        else return max(node.getRight());
    }

    /* Delete Maximum Value Node */
    private Node<T> deleteMax(Node<T> node) {
        if (node.getRight() == null) return node.getLeft();
        node.setRight(deleteMax(node.getRight()));
        return node;
    }

    /* --- */

    /* Delete */
    public void delete(T value) {
        root = delete(root, value);
    }

    private Node<T> delete(Node<T> node, T value) {
        if (node == null) System.out.println("Value not found");
        int compareValue = comparator.compare(node.getValue(), value);
        if (compareValue < 0) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (compareValue > 0) {
            node.setRight(delete(node.getRight(), value));
        } else if (compareValue == 0) {
            Node<T> temp = node;
            node = min(node.getRight());
            node.setLeft(temp.getLeft());
            node.setRight(deleteMin(temp.getRight()));
        }
        return node;
    }

    /* --- */

    /* Search */
    public Optional<Node<T>> search(T value) {
        return search(root, value);
    }

    private Optional<Node<T>> search(Node<T> node, T value) {
        if (node == null) return Optional.empty();
        int compareValue = comparator.compare(node.getValue(), value);
        if (compareValue < 0) return search(node.getLeft(), value);
        else if (compareValue > 0) return search(node.getRight(), value);
        else return Optional.of(node);
    }
    /* --- */

}

class Node<T> {
    private T value;
    private Node left, right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /* Getters and Setters */
    public T getValue() {
    	return value;
    }

    public Node getLeft() {
    	return left;
    }

    public void setLeft(Node left) {
    	this.left = left;
    }

    public Node getRight() {
    	return right;
    }

    public void setRight(Node right) {
    	this.right = right;
    }
}
