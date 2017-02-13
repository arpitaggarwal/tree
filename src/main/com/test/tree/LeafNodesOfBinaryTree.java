package com.test.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeafNodesOfBinaryTree {
	private Node root;

	public static void main(String[] args) {
		LeafNodesOfBinaryTree tree = new LeafNodesOfBinaryTree();

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

		System.out.println("Leaf Nodes of binary tree is ");
		tree.printLeafNodes(tree.root);
		System.out.println("\nLeaf Nodes of binary tree using recursion is ");
		tree.printLeafNodesRecursion(tree.root);
	}

	private void printLeafNodes(Node root) {
		// base case if tree is empty
		if (root == null)
			return;

		Queue<Node> stack = new LinkedList<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node node = stack.poll();
			if (node.left == null && node.right == null) {
				System.out.print(node.key + " ");
			}
			if (node.left != null) {
				stack.add(node.left);
			}
			if (node.right != null) {
				stack.add(node.right);
			}
		}
	}

	private void printLeafNodesRecursion(Node root) {
		// base case if tree is empty
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			System.out.print(root.key + " ");
		}
		printLeafNodesRecursion(root.left);
		printLeafNodesRecursion(root.right);
	}
}
