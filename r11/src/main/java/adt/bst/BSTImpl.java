package adt.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}

	private int height(BSTNode<T> node) {
		int result = -1;
		if (!node.isEmpty()) {
			int maior = height((BSTNode<T>) node.getLeft());
			int right = height((BSTNode<T>) node.getRight());
			if (right > maior)
				maior = right;
			result = maior + 1;
		}
		return result;
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(root, element);
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> result = null;
		if (node.isEmpty()) {
			result = new BSTNode<>();
		} else if (node.getData().equals(element)) {
			result = node;
		} else if (node.getData().compareTo(element) > 0) {
			result = search((BSTNode<T>) node.getLeft(), element);
		} else {
			result = search((BSTNode<T>) node.getRight(), element);
		}
		return result;
	}

	@Override
	public void insert(T element) {
		insert(root, element);
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.setRight(new BSTNode<>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} else if (node.getData().compareTo(element) > 0) {
			insert((BSTNode<T>) node.getLeft(), element);
		} else {
			insert((BSTNode<T>) node.getRight(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(root);
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> result = null;
		if (!node.isEmpty()) {
			if (node.getRight().isEmpty()) {
				result = node;
			} else {
				result = maximum((BSTNode<T>) node.getRight());
			}
		}
		return result;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(root);
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> result = null;
		if (!node.isEmpty()) {
			if (node.getLeft().isEmpty()) {
				result = node;
			} else {
				result = minimum((BSTNode<T>) node.getLeft());
			}
		}
		return result;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		return sucessor(root, element);
	}

	private BSTNode<T> sucessor(BSTNode<T> node, T element) {
		BSTNode<T> result = null;
		// TODO: não ta igual com adalberto.. mas funciona eu acredito!
		if (!node.isEmpty()) {
			if (node.getData().compareTo(element) <= 0) {
				result = sucessor((BSTNode<T>) node.getRight(), element);
			} else {
				result = node;
				BSTNode<T> other = sucessor((BSTNode<T>) node.getLeft(), element);
				if (other != null)
					result = other;
			}
		}
		return result;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		return predecessor(root, element);
	}

	private BSTNode<T> predecessor(BSTNode<T> node, T element) {
		BSTNode<T> result = null;
		if (!node.isEmpty()) {
			if (node.getData().compareTo(element) >= 0) {
				result = predecessor((BSTNode<T>) node.getLeft(), element);
			} else {
				result = node;
				BSTNode<T> other = predecessor((BSTNode<T>) node.getRight(), element);
				if (other != null)
					result = other;
			}
		}
		return result;
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		// TODO: sera se é pra usar array direto??
		ArrayList<T> arr = new ArrayList<>();
		preOrder(arr, root);
		return (T[]) arr.toArray(new Comparable[0]);
	}

	private void preOrder(List<T> arr, BSTNode<T> node) {
		if (!node.isEmpty()) {
			arr.add(node.getData());
			preOrder(arr, (BSTNode<T>) node.getLeft());
			preOrder(arr, (BSTNode<T>) node.getRight());
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		// TODO: sera se é pra usar array direto??
		ArrayList<T> arr = new ArrayList<>();
		order(arr, root);
		return (T[]) arr.toArray(new Comparable[0]);
	}

	private void order(List<T> arr, BSTNode<T> node) {
		if (!node.isEmpty()) {
			order(arr, (BSTNode<T>) node.getLeft());
			arr.add(node.getData());
			order(arr, (BSTNode<T>) node.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		// TODO: sera se é pra usar array direto??
		ArrayList<T> arr = new ArrayList<>();
		postOrder(arr, root);
		return (T[]) arr.toArray(new Comparable[0]);
	}

	private void postOrder(List<T> arr, BSTNode<T> node) {
		if (!node.isEmpty()) {
			postOrder(arr, (BSTNode<T>) node.getLeft());
			postOrder(arr, (BSTNode<T>) node.getRight());
			arr.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
