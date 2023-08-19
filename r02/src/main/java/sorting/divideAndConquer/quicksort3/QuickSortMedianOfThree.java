package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	private void swapIfLess(T[] array, int a, int b) {
		if (a != b && array[a].compareTo(array[b]) < 0) {
			Util.swap(array, a, b);
		}
	}

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex || leftIndex < 0 || rightIndex >= array.length) return;

		int left = leftIndex;
		int right = rightIndex;
		int center = (left + right) / 2;

		swapIfLess(array, right, center);
		swapIfLess(array, center, left);
		swapIfLess(array, right, center);
		
		// agora array[left] < array[center] < array[right]

		int pivot = right - 1;
		Util.swap(array, center, pivot);
		int i = pivot;
		for (int j = pivot - 1; j > left; --j) {
			if (array[j].compareTo(array[pivot]) > 0) {
				i--;
				Util.swap(array, j, i);
			}
		}
		Util.swap(array, pivot, i);
		// onde o pivot acabou ficando
		pivot = i;

		sort(array, left, pivot - 1);
		sort(array, pivot + 1, right);
	}
}
