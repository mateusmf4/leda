package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Voce NÃO pode modificar o aray original
	 * - Voce NÃO pode usar memória extra: nenhum array auxiliar deve ser criado e utilizado.
	 * - Você NÃO pode usar métodos já prontos de manipulação de arrays
	 * - Voce NÃO pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   usando a ideia do selection sort).
	 * - Considere que k varia de 1 a N 
	 * - Voce DEVE usar recursão para resolver o problema. Nenhum laço poderá ser utilizado.
	 * - Você pode implementar métodos auxiliares, desde que seja apenas nesta classe.
	 * - Os métodos auxiliares NÃO PODEM ter mais que três parâmetros.
	 *
	 * Dica: procure pensar como usar a ideia do selection sort para resolver esse problema,
     *       identifique que métodos você precisará para resolver o problema 
	 *       e pense no template da recursão em cada método que voce vai implementar.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		int ind = getSmallestIndex(array, k);
		if (ind == -1) {
			return null;
		} else {
			return array[ind];
		}
	}

	/**
	 * Retorna o k-ésimo menor indice. Se esse elemento não existe, retorna -1
	 */
	private int getSmallestIndex(T[] array, int k) {
		if (k == 1) {
			// caso base: o menor de todos
			return menorIndice(array);
		} else {
			int menorAnterior = getSmallestIndex(array, k - 1);
			if (menorAnterior == -1) {
				return -1;
			} else {
				return menorIndiceMaiorQue(array, menorAnterior);
			}
		}
	}

	private int menorIndice(T[] array) {
		if (array.length == 0) {
			return -1;
		} else {
			return menorIndice(array, 0, 0);
		}
	}

	private int menorIndice(T[] array, int ind, int menor) {
		if (ind >= array.length) {
			return menor;
		} else {
			if (array[ind].compareTo(array[menor]) < 0) {
				menor = ind;
			}
			return menorIndice(array, ind + 1, menor);
		}
	}

	private int menorIndiceMaiorQue(T[] array, int maiorQue) {
		return menorIndiceMaiorQue(array, 0, maiorQue);
	}

	private int menorIndiceMaiorQue(T[] array, int left, int maiorQue) {
		if (left >= array.length) {
			return -1;
		} else {
			T valor = array[left];
			int menorDoResto = menorIndiceMaiorQue(array, left + 1, maiorQue);
			if (valor.compareTo(array[maiorQue]) > 0) {
				if (menorDoResto == -1 || valor.compareTo(array[menorDoResto]) < 0) {
					return left;
				}
			}
			return menorDoResto;
		}
	}

}
