package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return equals((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
	}

	private boolean equals(BSTNode<T> n1, BSTNode<T> n2) {
		boolean result = n1.equals(n2);
		if (result && !n1.isEmpty() && !n2.isEmpty()) {
			// horrivel esses casts
			result = equals(
				(BSTNode<T>) n1.getLeft(),
				(BSTNode<T>) n2.getLeft()
			) && equals(
				(BSTNode<T>) n1.getRight(),
				(BSTNode<T>) n2.getRight()
			);
		}
		return result;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		// TODO Implement this method
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		// TODO Implement this method
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
