package adt.queue;

public class CircularQueueTest extends BaseQueueTest<CircularQueue<Integer>> {
	@Override
	CircularQueue<Integer> getImpl(int size) {
		return new CircularQueue<>(size);
	}
}
