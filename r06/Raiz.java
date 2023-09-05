package problems;
 
/**
 * Classe com metodos para calcular raiz n-esima de um numero com aproximacao
 * e para encontrar os limites que dividem um array em 3 partes de mesmo tamanho
 * 
 * @author adalbertocajueiro
 *
 */
public interface Raiz {

	/**
	 * Metodo que calcula uma raiz n-esima de um numero usando a tecnica de busca binaria
	 * e uma aproximacao. A raiz n-ésima (x) de um número N é um número que varia de 0 até N 
	 * tal que x^n = N (ou x^n se aproxima de N com determinado erro aceitável).
	 * 
	 * Essa busca por um número real de 0 até N pode ser feito de forma linear (que necessita de
	 * um valor fixo em cada passo para ser o "incremento" na busca) ou por busca binária
	 * que sempre vai buscar o elemento do meio de um intervalo (inicialmente de 0 - N).
	 *
	 * A cada escolha na busca é possível saber se o número escolhido é aceitável como rain n-ésima 
	 * de N comparando se a diferença está dentro da faixa de erro. Se não estiver, o algoritmo continua 
	 * buscando outro número. 
	 * 
	 * Restricoes:
	 * - Seu algoritmo DEVE usar a estrategia de busca binaria para encontrar a raiz desejada
	 * - Seu algoritmo DEVE ser recursivo
	 * - Voce NAO pode usar memoria extra (apenas variaveis)
	 * - Veu algoritmo DEVE ser O(log n)
	 * - Voce pode NÃO usar nenhum método pronto da classe Math
	 * - Voce pode implementar métodos auxiliares, desde que sejam todos recursivos
	 * 
	 * @param numero - o numero a calcular sua raiz n-esima
	 * @param raiz - a raiz desejada no calculo (ex pode ser raiz quadrada(2), cubica (3), etc
	 * @param erro - a margem de erro aceitavel para o calculo
	 * 
	 * @return - a primeira raiz calculada que satisfaz o erro.
	 * 
	 */
	public double raiz(int numero, int raiz, double erro);

}