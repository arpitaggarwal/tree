package com.test.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TopViewOfBinaryTree {

	private Node root;

	public static void main(String[] args) {
		TopViewOfBinaryTree tree = new TopViewOfBinaryTree();
		 /* Create following Binary Tree
        1
      /  \
     2    3
      \
       4
        \
         5
          \
           6*/
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);
		tree.root = root;
		System.out.println("Following are nodes in top view of Binary Tree");
		tree.printTopView();
	}

	/**
	 * Reference :
	 * http://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
	 */
	// This method prints nodes in top view of binary tree
	public void printTopView() {
		// base case
		if (root == null) {
			return;
		}
		// Creates an empty hashset
		Set<Integer> set = new HashSet<>();

		Queue<QItem> queue = new LinkedList<QItem>();

		queue.add(new QItem(root, 0));
		while (!queue.isEmpty()) {
			QItem temp = queue.poll();

			if (!set.contains(temp.hd)) {
				System.out.print(temp.node.key + " ");
				set.add(temp.hd);
			}

			if (temp.node.left != null) {
				queue.add(new QItem(temp.node.left, temp.hd - 1));
			}
			if (temp.node.right != null) {
				queue.add(new QItem(temp.node.right, temp.hd + 1));
			}

		}
	}
}

class QItem {
	Node node;
	int hd;

	public QItem(Node n, int h) {
		node = n;
		hd = h;
	}
}
