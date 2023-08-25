package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int menor = array[leftIndex];
			int maior = array[leftIndex];
			for (int i = leftIndex; i <= rightIndex; ++i) {
				int valor = array[i];
				if (valor < menor)
					menor = valor;
				if (valor > maior)
					maior = valor;
			}
			int[] count = new int[maior - menor + 1];
			for (int i = leftIndex; i <= rightIndex; ++i) {
				int valor = array[i];
				count[valor - menor]++;
			}
			int outIndex = leftIndex;
			for (int i = 0; i < count.length; ++i) {
				for (int n = 0; n < count[i]; ++n) {
					array[outIndex++] = i + menor;
				}
			}
		}
	}

}
