package com.test.tree;

public class SearchNodeInBinarySearchTree {
	private Node root;

	public static void main(String[] args) {
		SearchNodeInBinarySearchTree tree = new SearchNodeInBinarySearchTree();

		Node node8 = new Node(8);
		Node node3 = new Node(3);
		Node node10 = new Node(10);
		Node node1 = new Node(1);
		Node node6 = new Node(6);
		
		Node node14 = new Node(14);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node13 = new Node(13);
		
		tree.root = node8;

		node8.left = node3;
		node8.right = node10;

		node3.left = node1;
		node3.right = node6;
		node10.right = node14;
		node14.left = node13;
		
		node6.left = node4;
		node6.right = node7;

		System.out.println("Level Order traversal of binary tree is ");
		tree.printLevelOrder();

		Node result = tree.searchNode(tree.root, 13);
		System.out.println("\nFound : "+result.key);
	}

	private Node searchNode(Node root, int key) {
		if (root == null)
			return null;

		if (root.key == key) {
			return root;
		}
		if (key < root.key)
			return searchNode(root.left, key);
	//	else
		return searchNode(root.right, key);
	}

	/* function to print level order traversal of tree - BFS */
	private void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	/* Print nodes at the given level */
	private void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.key + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	private int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}
}