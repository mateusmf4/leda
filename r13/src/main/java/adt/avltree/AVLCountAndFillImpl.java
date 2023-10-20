package adt.avltree;

import adt.bst.BSTNode;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);
		if (Math.abs(balance) > 1) {
			if (balance > 0) {
				// está desbalanceado para a esquerda
				int childB = calculateBalance((BSTNode<T>) node.getLeft());
				if (childB >= 0) {
					LLcounter++;
				} else {
					LRcounter++;
				}
			} else {
				// está desbalanceado para a direita
				int childB = calculateBalance((BSTNode<T>) node.getRight());
				if (childB <= 0) {
					RRcounter++;
				} else {
					RLcounter++;
				}
			}
		}

		super.rebalance(node);
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
