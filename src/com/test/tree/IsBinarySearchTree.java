package com.test.tree;

public class IsBinarySearchTree {
	private Node root;

	public static void main(String[] args) {
		IsBinarySearchTree tree = new IsBinarySearchTree();

		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		tree.isBSTUsingInorder(tree.root);
	}

	/**
	 * If in-order traversal is sorted then it is a BST
	 * 
	 */
	private void isBSTUsingInorder(Node node) {
		if (node == null)
			return;

		isBSTUsingInorder(node.left);
		System.out.print(node.key + " ");
		isBSTUsingInorder(node.right);
	}

	/**
	 * Reference :
	 * http://stackoverflow.com/questions/10832496/finding-if-a-binary
	 * -tree-is-a-binary-search-tree
	 * 
	 * http://www.geeksforgeeks.org/a-program-to-check
	 * -if-a-binary-tree-is-bst-or-not/
	 * 
	 */
	public boolean isValid(Node root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBST(Node node, int MIN, int MAX) {
		if (node == null)
			return true;
		if (node.key > MIN && node.key < MAX
				&& isValidBST(node.left, MIN, node.key)
				&& isValidBST(node.right, node.key, MAX))
			return true;
		else
			return false;
	}
}
