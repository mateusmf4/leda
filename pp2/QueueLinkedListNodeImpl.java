package problems;

import adt.linkedList.SingleLinkedListNode;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;


public class QueueLinkedListNodeImpl<T> implements QueueLinkedListNode<T>{

	private int maxSize;
	private int size;
	private SingleLinkedListNode<T> head;
	// aponta para o NIL no final da lista
	private SingleLinkedListNode<T> tail;

	/**
	 * Construtor da classe. Esse construtor precisa existir.
	 * Restricao:
	 * - NÃO altere a assinatura desse construtor.
	 *   Voce pode ajustar apenas o corpo do construtor, se necessário.
	 */
	public QueueLinkedListNodeImpl(int size){
		this.maxSize = size;
		this.size = 0;
		head = new SingleLinkedListNode<>();
		tail = head;
	}

	public void enqueue(T element) throws QueueOverflowException{
		if (element != null) {
			if (isFull()) {
				throw new QueueOverflowException();
			} else {
				tail.setData(element);
				tail.setNext(new SingleLinkedListNode<>());
				tail = tail.getNext();
				++size;
			}
		}
	}

	public T dequeue() throws QueueUnderflowException{
		if (isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			T result = head.getData();
			head = head.getNext();
			--size;
			return result;
		}
	}

	public T head(){
		return head.getData();
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public boolean isFull(){
		return size == maxSize;
	}

	public int size(){
		return size;
	}

}