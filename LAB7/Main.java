import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class AVLTreeTest {

    public static void main(String[] args) {
        // Task 1: Inserting keys and printing the AVL tree in BFS
        AVLTree<Integer> tree = new AVLTree<>();
        int[] keys = {8, 14, 12, 18, 23, 20, 15, 13, 7, 16};

        for (int key : keys) {
            tree.insertAVL(key);
        }

        System.out.println("AVL Tree after insertion (BFS):");
        tree.breadthFirst();

        // Task 2: Deleting user-input keys and printing the AVL tree in BFS
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter a key to delete:");
            int keyToDelete = scanner.nextInt();
            tree.deleteAVL(keyToDelete);
        }

        System.out.println("AVL Tree after deletion (BFS):");
        tree.breadthFirst();
        System.out.println();
        // Task 3: Creating an AVL tree of strings and printing it in inorder
        AVLTree<String> stringTree = new AVLTree<>();
        Set<String> uniqueWords = new HashSet<>();

        try {
            Scanner fileScanner = new Scanner(new File("sampletextfile.txt"));
            while (fileScanner.hasNext()) {
                String word = fileScanner.next().toLowerCase().replaceAll("[^a-z]", "");
                if (!uniqueWords.contains(word)) {
                    uniqueWords.add(word);
                    stringTree.insertAVL(word);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("AVL Tree of strings (Inorder):");
        stringTree.inorder();

        scanner.close();
    }
}



