package testdome.java;

class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {
//
//        boolean contains = false;
        if(root.value == value){
           return true;
        }
        if (root.value < value && root.right == null) {
            return false;
        }
        if (root.value > value && root.left == null) {
            return false;
        }
        if(root.value < value){
           return contains(root.right, value);
        }
        return contains(root.left, value);


    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        System.out.println(contains(n2, 3));
    }
}
