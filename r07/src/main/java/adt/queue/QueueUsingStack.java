package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		try {
			stack1.push(element);
		} catch (StackOverflowException e) {
			throw new QueueOverflowException();
		}
	}

	private T findHeadAndRemove(boolean remove) {
		T result = null;
		try {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			if (remove) {
				result = stack2.pop();
			} else {
				result = stack2.top();
			}
			// encontramos o primeiro da pilha, retornando tudo de volta pra stack1 agora
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
		} catch (StackOverflowException e) {
		} catch (StackUnderflowException e) {
		}
		return result;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();
		return findHeadAndRemove(true);
	}

	@Override
	public T head() {
		return findHeadAndRemove(false);
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}

}
