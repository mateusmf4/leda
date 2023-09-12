package adt.queue;

public class QueueUsingStackTest extends BaseQueueTest<QueueUsingStack<Integer>> {
	@Override
	QueueUsingStack<Integer> getImpl(int size) {
		return new QueueUsingStack<>(size);
	}
}
