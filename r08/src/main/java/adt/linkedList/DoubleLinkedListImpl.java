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
			DoubleLinkedListNode<T> head = getHeadAsDouble();
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>(element, head, head.getPrevious());
			head.getPrevious().setNext(node);
			head.setPrevious(node);
			this.head = node;
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			head = head.getNext();
			DoubleLinkedListNode<T> prev = new DoubleLinkedListNode<>();
			prev.setNext(head);
			getHeadAsDouble().setPrevious(prev);
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			DoubleLinkedListNode<T> newLast = last.getPrevious();
			newLast.setNext(last.getNext());
			((DoubleLinkedListNode<T>) last.getNext()).setPrevious(newLast);
			if (last == head)
				head = newLast;
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
