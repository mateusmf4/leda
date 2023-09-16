package adt.linkedList;

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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
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