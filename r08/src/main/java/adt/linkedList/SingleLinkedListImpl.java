package adt.linkedList;

import java.util.ArrayList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> node = head;
		while (!node.isNIL()) {
			size++;
			node = node.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> node = head;
		while (!node.isNIL() && !node.getData().equals(element)) {
			node = node.getNext();
		}
		return node.getData();
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (head.isNIL()) {
				head = new SingleLinkedListNode<T>(element, head);
			} else {
				SingleLinkedListNode<T> prev = head;
				while (!prev.getNext().isNIL()) {
					prev = prev.getNext();
				}
				prev.setNext(new SingleLinkedListNode<T>(element, prev.getNext()));
			}
		}
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> node = head;
		while (!node.isNIL() && !node.getData().equals(element)) {
			node = node.getNext();
		}
		if (!node.isNIL()) {
			node.setData(node.getNext().getData());
			node.setNext(node.getNext().getNext());
		}
	}

	@Override
	public T[] toArray() {
		T[] arr = (T[]) new Object[this.size()];
		int i = 0;
		SingleLinkedListNode<T> node = head;
		while (!node.isNIL()) {
			arr[i++] = node.getData();
			node = node.getNext();
		}
		return arr;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
