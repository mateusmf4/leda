package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		
		if (leftIndex < 0 || rightIndex >= array.length) return;

		mergeSort(array, leftIndex, rightIndex);
	}

	private void mergeSort(T[] array, int leftIndex, int rightIndex) {
		int size = rightIndex - leftIndex + 1;
		if (size <= SIZE_LIMIT) {
			insertionSort(array, leftIndex, rightIndex);
		} else {
			MERGESORT_APPLICATIONS++;

			int middle = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, middle);
			mergeSort(array, middle + 1, rightIndex);

			// merging the two sub arrays
			new MergeSort<T>().merge(array, leftIndex, middle, rightIndex);
		}
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		INSERTIONSORT_APPLICATIONS++;
		for (int i = leftIndex + 1; i <= rightIndex; ++i) {
			T valor = array[i];
			int j;
			for (j = i; j > leftIndex; --j) {
				if (valor.compareTo(array[j - 1]) < 0) {
					array[j] = array[j - 1];
				} else {
					break;
				}
			}
			array[j] = valor;
		}
	}

}
