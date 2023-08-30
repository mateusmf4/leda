package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 *   Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 *   os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 *   ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 *   Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		int size = array.length >= k ? k : 0;
		T[] result = (T[]) new Comparable[size];
		if (array.length >= k) {
			for (int i = 0; i < size; ++i) {
				T value = orderStatistics(array, array.length - i);
				result[i] = value;
			}
		}
		return result;
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		return quickSelect(array, k, 0, array.length - 1);
	}

	// copiado
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
