package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) return;

		int middle = (leftIndex + rightIndex) / 2;
		sort(array, leftIndex, middle);
		sort(array, middle + 1, rightIndex);

		// merging the two sub arrays

		int size = rightIndex - leftIndex + 1;
		T[] newArr = (T[])(new Comparable[size]);

		int indexA = leftIndex;
		int indexB = middle + 1;
		int indexOut = 0;

		while (indexA <= middle && indexB <= rightIndex) {
			if (array[indexA].compareTo(array[indexB]) <= 0) {
				newArr[indexOut++] = array[indexA++];
			} else {
				newArr[indexOut++] = array[indexB++];
			}
		}
		while (indexA <= middle) {
			newArr[indexOut++] = array[indexA++];
		}
		while (indexB <= rightIndex) {
			newArr[indexOut++] = array[indexB++];
		}
		for (int i = 0; i < size; ++i) {
			array[leftIndex + i] = newArr[i];
		}
	}
}
