package com.test.tree;

public class IsBinarySearchTree {
	private Node root;

	public static void main(String[] args) {
		IsBinarySearchTree tree = new IsBinarySearchTree();

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

		//System.out.println("Is Binary Search Tree : " + tree.isBST(tree.root));
	}

	/*private boolean isBST(Node node) {
		Node prev = null;
		// traverse the tree in inorder fashion and
		// keep a track of previous node
		if (root == null) {
			if (!isBST(root.left))
				return false;

			// allows only distinct values node
			if (prev != null && root.key <= prev.key)
				return false;
			prev = root;
			return isBST(root.right);
		}
		return true;
	}*/
}
