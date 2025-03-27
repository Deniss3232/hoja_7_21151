public class BinarySearchTree<E extends Comparable<E>> {
    private BSTNode<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(E data) {
        root = insertRec(root, data);
    }

    private BSTNode<E> insertRec(BSTNode<E> node, E data) {
        if (node == null) return new BSTNode<>(data);
        if (data.compareTo(node.data) < 0) node.left = insertRec(node.left, data);
        else if (data.compareTo(node.data) > 0) node.right = insertRec(node.right, data);
        return node;
    }

    public E search(E key) {
        return searchRec(root, key);
    }

    private E searchRec(BSTNode<E> node, E key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.data);
        if (cmp == 0) return node.data;
        else if (cmp < 0) return searchRec(node.left, key);
        else return searchRec(node.right, key);
    }

    public void inOrderAsc() {
        inOrderAscRec(root);
    }

    private void inOrderAscRec(BSTNode<E> node) {
        if (node != null) {
            inOrderAscRec(node.left);
            System.out.println(node.data);
            inOrderAscRec(node.right);
        }
    }

    public void inOrderDesc() {
        inOrderDescRec(root);
    }

    private void inOrderDescRec(BSTNode<E> node) {
        if (node != null) {
            inOrderDescRec(node.right);
            System.out.println(node.data);
            inOrderDescRec(node.left);
        }
    }
}
