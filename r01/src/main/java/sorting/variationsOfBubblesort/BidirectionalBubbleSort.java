package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < 0 || rightIndex > array.length) return;
		for (int iteration = 0; iteration < rightIndex - leftIndex; ++iteration) {
			boolean swapped = false;

			// a cada iteração os limites extremos vão ficando cada vez mais proximos,
			// já que o bubble sort leva o maior elemento pro final,
			// e o segundo bubble sort leva o menor elemento pro começo.
			int leftLimit = leftIndex + iteration;
			int rightLimit = rightIndex - iteration;

			for (int j = leftLimit; j < rightLimit; ++j) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					Util.swap(array, j, j + 1);
					swapped = true;
				}
			}
			
			if (!swapped) break;
			swapped = false;

			// - 1 pois o loop anterior garantiu que o ultimo elemento está no lugar certo,
			// então é redundante iniciar dele.
			for (int j = rightLimit - 1; j > leftLimit; --j) {
				if (array[j].compareTo(array[j - 1]) < 0) {
					Util.swap(array, j, j - 1);
					swapped = true;
				}
			}
			
			if (!swapped) break;
		}
	}
}
