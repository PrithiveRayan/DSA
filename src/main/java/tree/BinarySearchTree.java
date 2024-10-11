package tree;

public class BinarySearchTree<T extends Comparable<T>> {



    Node root;

    public BinarySearchTree(T data){
        root = new Node(data);
    }

    public BinarySearchTree() {
    }

    class Node{
        T data;
        Node left, right;
        Node(T data){
            this.data = data;
            left = right = null;
        }
    }

    public void insert(T data){
        insert(root, data);
    }

    private Node insert(Node root, T data) {

        if(root == null){
            return new Node(data);
        }
        if(findMax(root.data, data)){
            root.left = insert(root.left, data);
        }
        else{
            root.right = insert(root.right, data);
        }
        return root;
    }

    public Node search(T data) {
        return search(root, data);
    }

    public Node search(Node root, T data) {

        if(root == null || root.data == data)
            return root;
        if(findMax(root.data, data)){
            return search(root.left, data);
        }
        return search(root.right, data);
    }

    public void inOrder(){
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    public void preOrder(){
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node root){
        if(root != null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void postOrder(){
        inOrder(root);
        System.out.println();
    }

    private void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

    public boolean findMax(T first, T second) {
        // Use compareTo() for comparison instead of '>'
        if (first.compareTo(second) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void delete(T data){
        delete(root, data);
    }
    private Node delete(Node root, T data){

        if(root == null)
            return root;

        if(findMax(data, root.data)){
           root.right = delete(root.right, data);
        } else if (findMax(root.data, data)) {
            root.left = delete(root.left, data);
        }
        else{
            if(root.right == null){
                return root.left;
            } else if (root.left == null) {
                return root.right;
            }
            else {
                root.data = findMin(root.right);
                root.right = delete(root.right, data);
            }

        }
        return root;

    }

    public T findMin(Node right){
        T minVal = right.data;
        while(root.left != null){
            minVal = root.left.data;
            root = root.left;
        }
        return minVal;
    }




}
