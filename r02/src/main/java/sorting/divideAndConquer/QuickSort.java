package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private int partitionArr(T[] array, int leftIndex, int rightIndex) {
		// target element to be the pivot
		final int target = leftIndex;
		int i = target;
		T pivot = array[target];
		for (int j = target + 1; j <= rightIndex; ++j) {
			if (pivot.compareTo(array[j]) > 0) {
				// this sort of acts like a selection sort,
				// elements smaller than the pivot get pushed to
				// the beginning, but after the pivot
				i++;
				Util.swap(array, i, j);
			}
		}
		// swap the pivot to the end of the sorted sub array
		Util.swap(array, target, i);
		return i;
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int pivot = partitionArr(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}
	}
}
