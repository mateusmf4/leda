package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			data = element;
			next = new RecursiveDoubleLinkedListImpl<>();
			((RecursiveDoubleLinkedListImpl<T>) next).previous = this;
			previous = new RecursiveDoubleLinkedListImpl<>();
			previous.next = this;
		} else if (next.isEmpty()) {
			next.insert(element);
			((RecursiveDoubleLinkedListImpl<T>) next).previous = this;
		} else {
			next.insert(element);
		}
	}

	@Override
	public void insertFirst(T element) {
		if (isEmpty()) {
			insert(element);
		} else if (previous.isEmpty()) {
			RecursiveDoubleLinkedListImpl<T> node = new RecursiveDoubleLinkedListImpl<>();
			node.data = data;
			node.next = next;
			((RecursiveDoubleLinkedListImpl<T>) next).previous = node;
			node.previous = this;
			
			data = element;
			next = node;
		} else {
			previous.insertFirst(element);
		}
	}

	@Override
	public void removeFirst() {
		if (previous != null) {
			if (previous.isEmpty()) {
				data = next.data;
				if (!next.isEmpty()) {
					next = next.next;
				} else {
					next = new RecursiveDoubleLinkedListImpl<>();
				}
				((RecursiveDoubleLinkedListImpl<T>) next).previous = this;
			} else {
				previous.removeFirst();
			}
		}
	}

	@Override
	public void removeLast() {
		if (next != null) {
			if (next.isEmpty()) {
				data = null;
				next = null;
			} else {
				((RecursiveDoubleLinkedListImpl<T>) next).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
