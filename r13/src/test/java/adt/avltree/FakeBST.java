package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class FakeBST extends BSTImpl<Integer> {
	@Override
	public void insert(Integer element) {
		insert(root, element);
	}

	private void insert(BSTNode<Integer> node, Integer element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.setRight(new BSTNode<>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} else {
			insert((BSTNode<Integer>) node.getRight(), element);
		}
	}
}
