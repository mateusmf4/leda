package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {
	@Override
	public Integer floor(Integer[] array, Integer x) {
		quickSort(array, 0, array.length - 1);

		return floor(array, x, 0, array.length - 1);
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {
		final int target = leftIndex;
		int i = target;
		Integer pivot = array[target];
		for (int j = target + 1; j <= rightIndex; ++j) {
			if (pivot.compareTo(array[j]) > 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, target, i);
		return i;
	}

	private void quickSort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int pivot = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivot - 1);
			quickSort(array, pivot + 1, rightIndex);
		}
	}

	private Integer floor(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		Integer result = null;
		if (leftIndex <= rightIndex) {
			int middle = (rightIndex + leftIndex) / 2;
			int compare = array[middle].compareTo(x);
			if (compare == 0) {
				result = x;
			} else if (compare > 0) {
				result = floor(array, x, leftIndex, middle - 1);
			} else if (compare < 0) {
				result = array[middle];
				Integer rest = floor(array, x, middle + 1, rightIndex);
				if (rest != null)
					result = rest;
			}
		}
		return result;
	}
}
