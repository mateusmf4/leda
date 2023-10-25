package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int result = 0;
		if (!node.isEmpty()) {
			result = height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
		}
		return result;
	}

	private int height(BSTNode<T> node) {
		int result = -1;
		if (!node.isEmpty()) {
			result = 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
		}
		return result;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);
		if (Math.abs(balance) > 1) {
			boolean isRoot = node == root;
			BSTNode<T> newRoot = root;
			if (balance > 0) {
				// está desbalanceado para a esquerda
				int childB = calculateBalance((BSTNode<T>) node.getLeft());
				if (childB >= 0) {
					// caso LL
					newRoot = Util.rightRotation(node);
				} else {
					// caso LR
					Util.leftRotation((BSTNode<T>) node.getLeft());
					newRoot = Util.rightRotation(node);
				}
			} else {
				// está desbalanceado para a direita
				int childB = calculateBalance((BSTNode<T>) node.getRight());
				if (childB <= 0) {
					// caso RR
					newRoot = Util.leftRotation(node);
				} else {
					// caso RL
					Util.rightRotation((BSTNode<T>) node.getRight());
					newRoot = Util.leftRotation(node);
				}
			}
			if (isRoot) {
				root = newRoot;
			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		if (parent != null) {
			rebalance(parent);
			rebalanceUp(parent);
		}
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
		} else {
			if (node.getData().compareTo(element) > 0) {
				insert((BSTNode<T>) node.getLeft(), element);
			} else {
				insert((BSTNode<T>) node.getRight(), element);
			}
			rebalance(node);
		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if (!node.isEmpty())
			remove(node);
	}

	private void remove(BSTNode<T> node) {
		if (node.isLeaf()) {
			// tem nenhum filho
			// transforma node em NIL
			node.setData(null);
			node.setLeft(null);
			node.setRight(null);

			rebalanceUp(node);
		} else if (node.getLeft().isEmpty() || node.getRight().isEmpty()) {
			// só tem um filho
			BSTNode<T> other = (BSTNode<T>) node.getLeft();
			if (other.isEmpty())
				other = (BSTNode<T>) node.getRight();

			// transforma node no filho não NIL..
			node.setData(other.getData());
			node.setRight(other.getRight());
			node.setLeft(other.getLeft());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);

			rebalanceUp(node);
		} else {
			// tem ambos os filhos
			BSTNode<T> suc = sucessor(node.getData());
			T data = suc.getData();
			remove(suc);
			node.setData(data);
		}
	}
}
