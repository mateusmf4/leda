package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		head = last = new DoubleLinkedListNode<>();
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				head = last = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>());
			} else {
				DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>(element, (DoubleLinkedListNode<T>) last.getNext(), last);
				last.setNext(node);
				last = node;
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (isEmpty()) {
			insert(element);
		} else {
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>(element, getHeadAsDouble(), getHeadAsDouble().getPrevious());
			getHeadAsDouble().setPrevious(node);
			head = node;
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			DoubleLinkedListNode<T> prev = getHeadAsDouble().getPrevious();
			prev.setNext(head.getNext());
			((DoubleLinkedListNode<T>) head.getNext()).setPrevious(prev);
			head = head.getNext();
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			DoubleLinkedListNode<T> newLast = last.getPrevious();
			newLast.setNext(last.getNext());
			((DoubleLinkedListNode<T>) last.getNext()).setPrevious(newLast);
			last = newLast;
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

	private DoubleLinkedListNode<T> getHeadAsDouble() {
		return (DoubleLinkedListNode<T>) head;
	}

	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedListImpl<>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
	}

}
