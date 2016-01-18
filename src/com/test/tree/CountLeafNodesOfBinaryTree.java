package com.test.tree;

public class CountLeafNodesOfBinaryTree {
	private Node root;

	public static void main(String[] args) {
		CountLeafNodesOfBinaryTree tree = new CountLeafNodesOfBinaryTree();

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

		System.out.println("Leaf Node Count of binary tree is "
				+ tree.printLeafNodesCountRecursion(tree.root));

	}

	private int printLeafNodesCountRecursion(Node root) {
		// base case if tree is empty
		if (root == null)
			return 0;

		if (root.left == null && root.right == null) {
			return 1;
		}
		return printLeafNodesCountRecursion(root.left)
				+ printLeafNodesCountRecursion(root.right);

	}
}
