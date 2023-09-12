package adt.queue;

public class QueueImplTest extends BaseQueueTest<QueueImpl<Integer>> {
	@Override
	QueueImpl<Integer> getImpl(int size) {
		return new QueueImpl<>(size);
	}
}
