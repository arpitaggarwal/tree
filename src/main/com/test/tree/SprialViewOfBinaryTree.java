package com.test.tree;

import java.util.Stack;

public class SprialViewOfBinaryTree {

	private Node root;

	public static void main(String[] args) {
		SprialViewOfBinaryTree tree = new SprialViewOfBinaryTree();

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

		System.out.println("Spiral View of binary tree is ");
		tree.spiralView(tree.root);
	}

	private void spiralView(Node root) {
		/* base case if tree is empty */
		if (root == null)
			return;
		boolean direction = false;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		// Stack<NodeTree> tempStack = new Stack<>();
		while (!stack.isEmpty()) {
			Stack<Node> tempStack = new Stack<Node>();
			while (!stack.isEmpty()) {
				Node tempNode = stack.pop();
				System.out.printf("%d ", tempNode.key);
				if (!direction) {
					if (tempNode.left != null)
						tempStack.push(tempNode.left);
					if (tempNode.right != null)
						tempStack.push(tempNode.right);
				} else {
					if (tempNode.right != null)
						tempStack.push(tempNode.right);
					if (tempNode.left != null)
						tempStack.push(tempNode.left);
				}
			}
			// for changing direction
			direction = !direction;
			stack = tempStack;
		}
	}
}
