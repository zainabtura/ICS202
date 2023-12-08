import java.util.*;

public class TestAVL {
	public static void main(String[] args) {
			//Example which works with Left Rotation
         AVLTree<String> t = new AVLTree<String>();
         for(int i = 1; i <= 5; i++)
				t.insertAVL("a" + i);
			t.breadthFirst();
			System.out.println();
		
         System.out.println("Exercise 2");
         int[] values = {8, 14, 12, 18, 23, 20, 15, 13, 7, 16};

         System.out.println("Exercise 3");
         //read the text file, insert unique words into the AVL tree and print its inorder traversal
	}
}