package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T>{

	/**
	* Restricoes extras:
	* - Você NÃO pode usar recursão
	* - Você pode criar métodos auxiliares se achar necessário, desde que sejam criados
	*   nesta classe
	*/
	public void removeDuplicates(SingleLinkedListNode<T> head){
		SingleLinkedListNode<T> node = head;
		while (!node.isNIL()) {
			removeAlike(head, node);
			node = node.getNext();
		}
	}

	// remove todos os elementos onde x.equals(node) mas que x != node
	private void removeAlike(SingleLinkedListNode<T> head, SingleLinkedListNode<T> node) {
		SingleLinkedListNode<T> aux = head;
		while (!aux.isNIL()) {
			if (aux.getNext() != node && aux.getNext().equals(node)) {
				aux.setNext(aux.getNext().getNext());
			} else {
				aux = aux.getNext();
			}
		}
	}
}
