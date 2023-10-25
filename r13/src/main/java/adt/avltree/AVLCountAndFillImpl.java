package adt.avltree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

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
		// FIXME: pode isso?
		Arrays.sort(array);

		// Faz uma BFS
		Queue<T[]> queue = new ArrayDeque<>();
		queue.add(array);
		while (!queue.isEmpty()) {
			T[] value = queue.poll();
			if (value.length != 0) {
				int mid = value.length / 2;
				this.insert(value[mid]);

				queue.add(Arrays.copyOfRange(value, 0, mid));
				queue.add(Arrays.copyOfRange(value, mid + 1, value.length));
			}
		}
	}
}
