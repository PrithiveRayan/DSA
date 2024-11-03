package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> {



    Node root;
    int maxDiameter = 0;
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

    public void inOrderIteratively(){
        inOrderIteratively(root);
        System.out.println();
    }

    private void inOrderIteratively(Node root){
        List<Integer> inOrder = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                inOrder.add((Integer) node.data);
                node = node.right;
            }
        }
        System.out.println(inOrder);
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

    public void preOrderIteratively(){
        preOrderIteratively(root);
        System.out.println();
    }

    private void preOrderIteratively(Node root){
       List<Integer> preOrder = new LinkedList<>();
       if(root == null)
           System.out.println("Nothing to print");
       Stack<Node> stack = new Stack<>();
       stack.push(root);
       while(!stack.empty()){
           root = stack.pop();
           preOrder.add((Integer) root.data);
           if(root.right != null){
               stack.push(root.right);
           }
           if(root.left != null){
               stack.push(root.left);
           }
       }
        System.out.println(preOrder);
    }

    public void postOrder(){
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

    public void postOrderIteratively(){
        postOrderIteratively(root);
        System.out.println();
    }

    private void postOrderIteratively(Node root){
        List<Integer> postOrder = new LinkedList<>();
        Stack<Node> left = new Stack<>();
        Stack<Node> right = new Stack<>();
        if(root == null)
            System.out.println("Nothing to print");
        left.push(root);
        while(!left.empty()){
            root = left.pop();
            right.add(root);
            if(root.left != null){
                left.push(root.left);
            }
            if(root.right != null){
                left.push(root.right);
            }
        }
        while (!right.isEmpty()){
            postOrder.add((Integer) right.pop().data);
        }
        System.out.println(postOrder);
    }


    public void levelOrder(){
        levelOrder(root);
        System.out.println();
    }

    private void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if(root == null)
            System.out.println("No elements to print.");
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> orders = new LinkedList<>();
            for(int i=0; i<size; i++){
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                orders.add((Integer) queue.poll().data);
            }
            result.add(orders);
        }
        System.out.println(result);
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
                root.right = delete(root.right, root.data);
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

    public int findDFSMaxDepth(){
        return findDFSDepth(root);
    }

    private int findDFSDepth(Node root){
        if(root == null){
            return 0;
        }
        int left = findDFSDepth(root.left);
        int right = findDFSDepth(root.right);
        return 1+Math.max(right,left);
    }

    public boolean isBalancedTree(){
        return isBalancedTree(root) != -1;
    }

    private int isBalancedTree(Node root){
        if(root == null){
            return 0;
        }
        int left = isBalancedTree(root.left);
        if(left == -1) return -1;
        int right = isBalancedTree(root.right);
        if(right == -1) return -1;
        if(Math.abs(left-right) > 1)
            return -1;
        return 1+Math.max(right,left);
    }

//    public int diameterOfATree(){
//        int[] diameter = new int[1];
//        diameterOfATree(root, diameter);
//        return diameter[0];
//    }
//
//    private int diameterOfATree(Node root, int[] diameter){
//        if(root == null){
//            return 0;
//        }
//        int left = diameterOfATree(root.left, diameter);
//        int right = diameterOfATree(root.right,diameter);
//        diameter[0] = Math.max(diameter[0], left+right);
//        return 1+Math.max(right,left);
//    }

    public int diameterOfATree(){
        maxDiameter = 0;
        diameterOfATree(root, maxDiameter);
        return maxDiameter;
    }

    private int diameterOfATree(Node root, int diameter){
        if(root == null){
            return 0;
        }
        int left = diameterOfATree(root.left, diameter);
        int right = diameterOfATree(root.right,diameter);
        diameter = Math.max(diameter, left+right);
        return 1+Math.max(right,left);
    }




}
