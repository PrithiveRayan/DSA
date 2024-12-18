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


        System.out.println("Maximum depth is "+tree.findDFSMaxDepth());
        tree.levelOrder();
//        tree.preOrder();
//        tree.preOrderIteratively();
//        tree.postOrder();
//        tree.postOrderIteratively();
//        tree.inOrder();
//        tree.inOrderIteratively();


        if(tree.search(10) == null){
            System.out.println("Element not found.");
        }
        else {
            System.out.println("Element found.");
        }

        tree.delete(4);
        tree.inOrder();

//        System.out.println("Is Balanced tree? "+tree.isBalancedTree());
        System.out.println("Diameter of a tree is "+tree.diameterOfATree());


    }
}
