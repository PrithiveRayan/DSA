package tree;

public class DriverClass {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(6);
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(10);
        tree.insert(5);
        tree.insert(8);

        tree.inOrder();

        if(tree.search(105) == null){
            System.out.println("Element not found.");
        }
        else {
            System.out.println("Element found.");
        }

        tree.delete(8);

        tree.inOrder();


    }
}
