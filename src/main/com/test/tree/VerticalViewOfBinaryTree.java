package com.test.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class VerticalViewOfBinaryTree {

	private Node root;
	private Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
	private Map<Integer, ArrayList<Integer>> ht = new TreeMap<>();;
	private ArrayList<Integer> al;

	public static void main(String[] args) {
		VerticalViewOfBinaryTree tree = new VerticalViewOfBinaryTree();

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
				.println("Vertical traversal of binary tree using Preorder is ");
		tree.verticalUsingPreorder(tree.root, 0);
		tree.print(tree.map);
		System.out.println("Vertical traversal of binary tree is ");
		tree.vertical(tree.root, 0, false);
		tree.print(tree.ht);
	}

	public void verticalUsingPreorder(Node root, int hd) {
		// Base case
		if (root == null)
			return;
		// Store current node in map 'm'
		if (map.get(hd) != null) {
			ArrayList<Integer> x = map.get(hd);
			x.add(root.key);
			map.put(hd, x);
		} else {
			al = new ArrayList<>();
			al.add(root.key);
			map.put(hd, al);
		}
		// Store nodes in left subtree
		verticalUsingPreorder(root.left, hd - 1);
		// Store nodes in right subtree
		verticalUsingPreorder(root.right, hd + 1);
	}

	public int vertical(Node root, int level, boolean leftCall) {
		if (root != null) {
			level = vertical(root.right, ++level, true);
			if (ht.get(level) != null) {
				ArrayList<Integer> x = ht.get(level);
				x.add(root.key);
				ht.put(level, x);
			} else {
				al = new ArrayList<>();
				al.add(root.key);
				ht.put(level, al);
			}
			vertical(root.left, --level, false);
			return level;
		} else if (leftCall) {
			return --level;
		} else {
			return ++level;
		}
	}

	public void print(Map<Integer, ArrayList<Integer>> map) {
		Set<Integer> i = map.keySet();
		Collections.sort(new ArrayList<>(i));
		for (int keys : i) {
			System.out.println(map.get(keys));
		}
	}
}
