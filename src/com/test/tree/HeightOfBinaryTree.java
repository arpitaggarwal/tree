package com.test.tree;

public class HeightOfBinaryTree {

	private Node root;

	public static void main(String[] args) {
		HeightOfBinaryTree tree = new HeightOfBinaryTree();

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

		System.out
				.println("Height of binary tree is " + tree.height(tree.root));
	}

	/**
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 * Reference : http://www.comp.dit.ie/rlawlor/Alg_DS/searching/3.%20%20Binary%20Search%20Tree%20-%20Height.pdf
	 *
	 * @param root
	 * @return {@link Integer}
	 */
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
