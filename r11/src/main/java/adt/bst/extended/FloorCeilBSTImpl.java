package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bt.BTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		for (Integer x : array) {
			insert(x);
		}
		return floor(root, numero);
	}

	private Integer floor(BTNode<Integer> node, double num) {
		Integer result = null;
		if (!node.isEmpty()) {
			int compare = node.getData().compareTo((int)num);
			if (compare == 0) {
				result = node.getData();
			} else if (compare < 0) {
				result = node.getData();
				Integer other = floor(node.getRight(), num);
				if (other != null)
					result = other;
			} else {
				result = floor(node.getLeft(), num);
			}
		}
		return result;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (Integer x : array) {
			insert(x);
		}
		return ceil(getRoot(), numero);
	}

	private Integer ceil(BTNode<Integer> node, double num) {
		Integer result = null;
		if (!node.isEmpty()) {
			int compare = node.getData().compareTo((int)num);
			if (compare == 0) {
				result = node.getData();
			} else if (compare > 0) {
				result = node.getData();
				Integer other = ceil(node.getLeft(), num);
				if (other != null)
					result = other;
			} else {
				result = ceil(node.getRight(), num);
			}
		}
		return result;
	}

}
