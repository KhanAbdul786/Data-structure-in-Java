//Problem statement
//Remove all leaf nodes from a given generic Tree. Leaf nodes are those nodes, which don't have any children.
//
//Note : Root will also be a leaf node if it doesn't have any child. You don't need to print the tree, just remove all leaf nodes and return the updated root.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//10 3 20 30 40 2 40 50 0 0 0 0 
//Input Graph
//
//
//
//
//Input Graph
//
//Sample Output 1 : (Level wise, each level in new line)
//10
//20

package test3;

import java.util.ArrayList;

import tree.TreeNode;

public class RemoveLeafNodes {
	class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data) {
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}

	public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
		if (root == null || root.children.size() == 0) {
			return null;
		}
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for (int i = 0; i < root.children.size(); i++) {
			TreeNode<Integer> child = root.children.get(i);
			if (child.children.size() == 0) {
				indexes.add(i);
			}
		}
		for (int i = indexes.size() - 1; i >= 0; i--) {
			int j = indexes.get(i);
			root.children.remove(j);
		}
		for (int i = 0; i < root.children.size(); i++) {
			TreeNode<Integer> child = removeLeafNodes(root.children.get(i));
			if (child == null) {
				root.children.remove(i);
			}
		}
		return root;
	}

}
