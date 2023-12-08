import java.util.*;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random rand = new Random();
        ArrayList<Integer> keysInserted = new ArrayList<>();

        // Inserting random keys into the binary tree and storing them in a list
        for (int i = 0; i < 5; i++) {
            int key = rand.nextInt(20) + 1;
            bst.insert(key);
            keysInserted.add(key);
        }

        // Printing the traversals
        System.out.println("Breadth-First traversal prints: ");
        bst.breadthFirst();
        System.out.println();

        System.out.println("Preorder Depth First Traversal prints: ");
        bst.preorder();
        System.out.println();

        System.out.println("Inorder Depth First Traversal prints: ");
        bst.inorder();
        System.out.println();

        System.out.println("Post Order Depth First Traversal prints: ");
        bst.postorder();
        System.out.println();

        // Testing the methods
        System.out.println("The number of nodes is " + bst.count());
        for (int i = 0; i < 2; i++) { // Repeat twice
            int randomIndex = rand.nextInt(keysInserted.size());
            int randomKey = keysInserted.get(randomIndex);
            System.out.println("Is " + randomKey + " a leaf? " + bst.isLeaf(randomKey));
        }
        System.out.println("Number of Leaves is " + bst.countLeaves());
        System.out.println("Height is " + (bst.height() + 1)); // Adding 1 to consider the root as height 1
    }
}
