package bst_2;

public class BSTUse {

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(5);
		bst.insert(2);
		bst.insert(3);
		bst.insert(1);
		bst.insert(3);
		bst.insert(6);
		bst.insert(8);
		bst.insert(4);

		bst.printTree();
		System.out.print(bst.isPresent(5));
		bst.deleteData(5);
		System.out.print(bst.isPresent(5));
		bst.printTree();

	}

}
