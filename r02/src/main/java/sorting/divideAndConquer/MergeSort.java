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
		if (leftIndex >= rightIndex || leftIndex < 0 || rightIndex >= array.length) return;

		int middle = (leftIndex + rightIndex) / 2;
		sort(array, leftIndex, middle);
		sort(array, middle + 1, rightIndex);

		// merging the two sub arrays
		merge(array, leftIndex, middle, rightIndex);
	}

	// this assumes that the two subarrays are right after each other,
	// so leftB = rightA + 1
	public void merge(T[] array, int leftA, int rightA, int rightB) {
		final int originalLeft = leftA;
		
		int size = rightB - leftA + 1;
		@SuppressWarnings("unchecked")
		T[] newArr = (T[])(new Comparable[size]);
		
		int leftB = rightA + 1;
		int indexOut = 0;

		while (leftA <= rightA && leftB <= rightB) {
			if (array[leftA].compareTo(array[leftB]) <= 0) {
				newArr[indexOut++] = array[leftA++];
			} else {
				newArr[indexOut++] = array[leftB++];
			}
		}
		while (leftA <= rightA) {
			newArr[indexOut++] = array[leftA++];
		}
		while (leftB <= rightB) {
			newArr[indexOut++] = array[leftB++];
		}
		for (int i = 0; i < size; ++i) {
			array[originalLeft + i] = newArr[i];
		}
	}
}
