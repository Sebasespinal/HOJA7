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
    public void insert(Association<E, String> association) {
        if (data == null) {
            data = association.getKey();
        } else {
            E dataKey = data;
            E associationKey = association.getKey();

            int comparison = associationKey.compareTo(dataKey);
            if (comparison < 0) {
                if (left == null) {
                    left = new BinaryTree<>(association.getKey());
                }
                left.insert(association);
            } else if (comparison > 0) {
                if (right == null) {
                    right = new BinaryTree<>(association.getKey());
                }
                right.insert(association);
            }
        }
    }

    public String search(E key) {
        if (data == null || key == null) {
            return null;
        }

        E dataKey = data;
        E keyToSearch = key;

        int comparison = keyToSearch.compareTo(dataKey);
        if (comparison == 0) {
            return data.toString();
        } else if (comparison < 0 && left != null) {
            return left.search(key);
        } else if (comparison > 0 && right != null) {
            return right.search(key);
        } else {
            return null;
        }
    }

    public void inOrderTraversal() {
        if (left != null) {
            left.inOrderTraversal();
        }

        System.out.print(data + " ");

        if (right != null) {
            right.inOrderTraversal();
        }
    }
}
}