package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < 0 || rightIndex >= array.length) return;
		for (int target = leftIndex; target <= rightIndex; ++target) {
			int smallest = target;
			for (int i = target + 1; i <= rightIndex; ++i) {
				if (array[i].compareTo(array[smallest]) < 0) {
					smallest = i;
				}
			}
			Util.swap(array, target, smallest);
		}
	}
}
