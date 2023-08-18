package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < 0 || rightIndex >= array.length) return;
		for (int i = leftIndex + 1; i <= rightIndex; ++i) {
			// guardar o valor atual, já que sera sobrescrito
			T valor = array[i];
			int j;
			for (j = i; j > leftIndex; --j) {
				// se o "valor" é menor do que arr[j-1], então mova arr[j-1] pra frente
				if (valor.compareTo(array[j - 1]) < 0) {
					array[j] = array[j - 1];
				} else {
					break;
				}
			}
			// guarda o valor onde o loop anterior parou
			array[j] = valor;
		}
	}
}
