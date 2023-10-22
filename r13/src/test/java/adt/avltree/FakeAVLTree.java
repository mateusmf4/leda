package adt.avltree;

import adt.bst.BSTNode;

public class FakeAVLTree extends AVLTreeImpl<Integer> {
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
		} else if (node.getData().compareTo(element) > 0) {
			insert((BSTNode<Integer>) node.getLeft(), element);
		} else {
			insert((BSTNode<Integer>) node.getRight(), element);
		}
	}
}
