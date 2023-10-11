package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return equals(tree1.getRoot(), tree2.getRoot());
	}

	private boolean equals(BTNode<T> n1, BTNode<T> n2) {
		boolean result = n1.equals(n2);
		if (result && !n1.isEmpty() && !n2.isEmpty()) {
			result = equals(n1.getLeft(), n2.getLeft()) && equals(n1.getRight(), n2.getRight());
		}
		return result;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return isSimilar(tree1.getRoot(), tree2.getRoot());
	}

	private boolean isSimilar(BTNode<T> n1, BTNode<T> n2) {
		boolean result = n1.isEmpty() == n2.isEmpty();
		// se ambos não forem vazio
		if (!n1.isEmpty() && !n2.isEmpty()) {
			result = isSimilar(n1.getLeft(), n2.getLeft()) && isSimilar(n1.getRight(), n2.getRight());
		}
		return result;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		return orderStatistic(tree.getRoot(), k);
	}

	private int nodeSize(BTNode<T> node) {
		int result = 0;
		if (!node.isEmpty()) {
			result = 1 + nodeSize(node.getLeft()) + nodeSize(node.getRight());
		}
		return result;
	}

	private T orderStatistic(BTNode<T> node, int k) {
		T result = null;
		if (!node.isEmpty()) {
			int size = nodeSize(node.getLeft());
			if (size == k - 1) {
				result = node.getData();
			} else if (size >= k) {
				result = orderStatistic(node.getLeft(), k);
			} else {
				result = orderStatistic(node.getRight(), k - size - 1);
			}
		}
		return result;
	}

}
 