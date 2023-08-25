package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int maior = 0;
			for (int i = leftIndex; i <= rightIndex; ++i) {
				int valor = array[i];
				if (valor > maior)
					maior = valor;
			}
			int[] count = new int[maior + 1];
			for (int i = leftIndex; i <= rightIndex; ++i) {
				int valor = array[i];
				count[valor]++;
			}
			int outIndex = leftIndex;
			for (int i = 0; i < count.length; ++i) {
				for (int n = 0; n < count[i]; ++n) {
					array[outIndex++] = i;
				}
			}
		}
	}

}
