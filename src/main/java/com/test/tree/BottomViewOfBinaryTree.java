package com.test.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

	private Node root;
	private Map<Integer, Integer> map = new TreeMap<>();

	public static void main(String[] args) {
		BottomViewOfBinaryTree tree = new BottomViewOfBinaryTree();
        /**
                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \      
                  10    14
        */
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		tree.root = root;
		System.out.println("Following are nodes in bottom view of Binary Tree");
		tree.bottomView();
		tree.print(tree.map);
	}

	/**
	 * Reference : http://www.geeksforgeeks.org/bottom-view-binary-tree/
	 */
	// This method prints nodes in top view of binary tree
	public void bottomView() {
		// base case
		if (root == null) {
			return;
		}

		Queue<QItem> queue = new LinkedList<QItem>();

		queue.add(new QItem(root, 0));
		while (!queue.isEmpty()) {
			QItem temp = queue.poll();

			/**
			 * Every time, we encounter a new horizontal distance or an existing
			 * horizontal distance put the node data for the horizontal distance
			 * as key. For the first time it will add to the map, next time it
			 * will replace the value. This will make sure that the bottom most
			 * element for that horizontal distance is present in the map and if
			 * you see the tree from beneath that you will see that element.
			 */
			map.put(temp.hd, temp.node.key);

			if (temp.node.left != null) {
				queue.add(new QItem(temp.node.left, temp.hd - 1));
			}
			if (temp.node.right != null) {
				queue.add(new QItem(temp.node.right, temp.hd + 1));
			}

		}
	}

	public void print(Map<Integer, Integer> map) {
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}

}
