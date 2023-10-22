package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return isBST(bst.getRoot(), null, null);
	}

	private boolean isBST(BTNode<T> node, T minLimit, T maxLimit) {
		boolean result = false;
		
		if (node.isEmpty()) {
			result = true;
		} else {
			T data = node.getData();
			if (minLimit != null && data.compareTo(minLimit) < 0) {
				result = false;
			} else if (maxLimit != null && data.compareTo(maxLimit) > 0) {
				result = false;
			} else {
				result = isBST(node.getLeft(), minLimit, data) && isBST(node.getRight(), data, maxLimit);
			}
		}

		return result;
	}
	
}
