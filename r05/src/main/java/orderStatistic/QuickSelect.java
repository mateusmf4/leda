package orderStatistic;

import util.Util;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 *
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 *
 * @author adalberto e campelo
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calcular o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os dados em duas partes, baseando-se no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso reduz a complexidade de O(n.log n) para O(n).
	 *
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 *
	 *
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento
	 *            este array normalmente nao esta ordenado
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return
	 *
	 */
	public T quickSelect(T[] array, int k) {
		return quickSelect(array, k, 0, array.length - 1);
	}

	private T quickSelect(T[] array, int k, int leftIndex, int rightIndex) {
		T result = null;
		if (leftIndex <= rightIndex) {
			int pivot = partition(array, leftIndex, rightIndex);
			// indice inicia de 0, k inicia de 1
			if (pivot == k - 1) {
				result = array[pivot];
			} else if (pivot < k - 1) {
				// pivot < k, então k esta na direita do pivot
				result = quickSelect(array, k, pivot + 1, rightIndex);
			} else {
				// pivot > k, então k esta a esquerda do pivot
				result = quickSelect(array, k, leftIndex, pivot - 1);
			}
		}
		return result;
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		final int target = leftIndex;
		int i = target;
		T pivot = array[target];
		for (int j = target + 1; j <= rightIndex; ++j) {
			if (pivot.compareTo(array[j]) > 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, target, i);
		return i;
	}
}