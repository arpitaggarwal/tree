package com.test.tree;

public class DepthFirstSearch {

	private Node root;

	public static void main(String[] args) {
		DepthFirstSearch tree = new DepthFirstSearch();

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);

		tree.root = node1;

		node1.left = node2;
		node1.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder(tree.root);

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder(tree.root);

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder(tree.root);
	}

	/**
	 * LRN
	 */
	private void printPostorder(Node root) {
		if (root == null)
			return;
		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.key + " ");
	}

	/**
	 * LNR
	 */
	private void printInorder(Node root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.print(root.key + " ");
		printInorder(root.right);
	}

	/**
	 * NLR
	 */
	private void printPreorder(Node root) {
		if (root == null)
			return;
		System.out.print(root.key + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}

}
