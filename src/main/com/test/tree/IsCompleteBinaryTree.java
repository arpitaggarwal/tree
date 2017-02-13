package com.test.tree;

public class IsCompleteBinaryTree {

	private Node root;

	public static void main(String[] args) {
		IsCompleteBinaryTree tree = new IsCompleteBinaryTree();

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

		System.out.println("Is Complete Binary Tree : "
				+ tree.isComplete(tree.root));

		int node_count = tree.countNodes(node1);
		int index = 0;

		if (tree.isComplete(node1, index, node_count))
			System.out.print("The binary tree is complete");
		else
			System.out.print("The binary tree is not complete");
	}

	/**
	 * If height of the tree is h, then the total number of nodes will be 2^h-1
	 * and vice-versa.
	 * 
	 * h = Height of Tree n = Number of nodes in the Tree if(n = 2^h -1) return
	 * true else return false
	 */
	private boolean isComplete(Node root) {
		int height = getHeight(root);
		int numberOfNodes = countNodes(root);
		return numberOfNodes == (int) Math.pow(2, height) - 1;
	}

	private int getHeight(Node node) {
		if (node == null)
			return 0;

		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);

		if (leftHeight > rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;

	}

	private int countNodes(Node node) {
		if (node == null)
			return 0;
		return 1 + countNodes(node.left) + countNodes(node.right);
	}

	/**
	 * Reference :
	 * http://www.geeksforgeeks.org/check-whether-binary-tree-complete
	 * -not-set-2-recursive-solution/
	 * 
	 * @param node
	 * @param index
	 * @param number_nodes
	 * @return
	 */
	/* This function checks if the binary tree is complete or not */
	boolean isComplete(Node node, int index, int number_nodes) {
		// An empty tree is complete
		if (node == null)
			return true;

		// If index assigned to current node is more than
		// number of nodes in tree, then tree is not complete
		if (index >= number_nodes)
			return false;

		// Recur for left and right subtrees
		return (isComplete(node.left, 2 * index + 1, number_nodes) && isComplete(
				node.right, 2 * index + 2, number_nodes));

	}
}
