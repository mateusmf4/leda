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
		if (k == 1) {
			// caso base: o menor de todos
			return menorValor(array);
		} else {
			T menorAnterior = getOrderStatistics(array, k - 1);
			if (menorAnterior == null)
				return null;
			return menorValorMaiorQue(array, menorAnterior);
		}
	}

	// Menor entre dois valores. Se um dos valores for null, retorna o outro.
	private T menorEntre(T a, T b) {
		if (a == null) return b;
		if (b == null) return a;
		if (a.compareTo(b) < 0) {
			return a;
		}
		return b;
	}

	// Retorna o menor valor da array.
	private T menorValor(T[] array) {
		return menorValor(array, 0);
	}

	private T menorValor(T[] array, int start) {
		// caso base: array vazia, o menor é null
		if (start >= array.length)
			return null;
		return menorEntre(array[start], menorValor(array, start + 1));
	}

	// Retorna o menor valor da array que é maior do que `maiorQue`.
	// Se nenhum elemento é maior do que `maiorQue`, retorna null.
	private T menorValorMaiorQue(T[] array, T maiorQue) {
		return menorValorMaiorQue(array, maiorQue, 0);
	}

	private T menorValorMaiorQue(T[] array, T maiorQue, int start) {
		// caso base: array vazia, o menor é null
		if (start >= array.length)
			return null;
		T valor = array[start];
		T menorResto = menorValorMaiorQue(array, maiorQue, start + 1);
		if (valor.compareTo(maiorQue) > 0) {
			return menorEntre(valor, menorResto);
		} else {
			return menorResto;
		}
	}
}
