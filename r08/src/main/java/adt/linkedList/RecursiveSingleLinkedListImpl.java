package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {
		data = null;
		next = null;
	}

	@Override
	public boolean isEmpty() {
		return data == null;
	}

	@Override
	public int size() {
		int size = 0;
		if (!isEmpty()) {
			size = 1 + next.size();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T result = null;
		if (!isEmpty()) {
			if (data.equals(element)) {
				result = data;
			} else {
				result = next.search(element);
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			data = element;
			next = new RecursiveSingleLinkedListImpl<>();
		} else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (data.equals(element)) {
				data = next.data;
				next = next.next;
			} else {
				next.remove(element);
			}
		}
	}

	private void toArrayImpl(T[] arr, int index) {
		if (!isEmpty()) {
			arr[index] = data;
			next.toArrayImpl(arr, index + 1);
		}
	}

	@Override
	public T[] toArray() {
		T[] arr = (T[]) new Object[this.size()];
		toArrayImpl(arr, 0);
		return arr;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
