package Traductor;

class BinaryTree<E> {
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
        // Implementación del método de inserción en el árbol binario
    }

    public boolean search(E element) {
        // Implementación del método de búsqueda en el árbol binario
        return false;
    }

    // Método para recorrer el árbol en orden y producir la colección de palabras ordenadas
    public void inOrderTraversal(BinaryTree<E> node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrderTraversal(node.getRight());
        }
    }
}
