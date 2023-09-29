package problems;

import adt.queue.Queue;

/**
 * Interface que modela uma fila a ser implementada usando-se
 * SingleLinkedListNode como estrutura sobrejacente.
 *
 * Restricoes:
* - Voce NÃO pode usar qualquer outra estrutura auxiliar, apenas SingleLinkedListNode
*   ou tipos primitivos
* - TODOS os método precisam ter complexidade O(1)
* - Voce DEVE respeitar a política FIFO seguida por Fila
*/
public interface QueueLinkedListNode<T> extends Queue<T> {

	/**
	 * Retorna a quantidade de elementos existentes na estrutura.
	 */
	public int size();
}