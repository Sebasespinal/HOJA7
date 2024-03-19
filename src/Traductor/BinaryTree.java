package Traductor;

public class BinaryTree<E extends Comparable<E>> {
    private E data;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    public BinaryTree(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public E getData() {
        return data;
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public void insert(E element) {
        if (data == null) {
            data = element;
        } else {
            if (element.compareTo(data) < 0) {
                if (left == null) {
                    left = new BinaryTree<>(element);
                } else {
                    left.insert(element);
                }
            } else {
                if (right == null) {
                    right = new BinaryTree<>(element);
                } else {
                    right.insert(element);
                }
            }
        }
    }

    public String search(E element) {
        if (data == null || element == null) {
            return null;
        }

        int comparison = element.compareTo(data);
        if (comparison == 0) {
            return data.toString();
        } else if (comparison < 0 && left != null) {
            return left.search(element);
        } else if (comparison > 0 && right != null) {
            return right.search(element);
        } else {
            return "*" + element.toString() + "*"; // Devolver la palabra original en inglés encerrada entre asteriscos
        }
    }

    public void inOrderTraversal(BinaryTree<E> node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrderTraversal(node.getRight());
        }
    }
}	