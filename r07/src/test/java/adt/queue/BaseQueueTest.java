package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
abstract class BaseQueueTest<T extends Queue<Integer>> {
	abstract T getImpl(int size);

	@Test
	public void basicTest1() throws QueueOverflowException {
		T x = getImpl(10);
		x.enqueue(10);
		x.enqueue(123);
		x.enqueue(-3);
		assertEquals(Integer.valueOf(10), x.head());
	}

	@Test
	public void basicTest2() throws QueueOverflowException {
		T x = getImpl(3);
		x.enqueue(10);
		x.enqueue(123);
		x.enqueue(-3);
		assertEquals(Integer.valueOf(10), x.head());
		assertThrows(QueueOverflowException.class, () -> x.enqueue(23));
		assertThrows(QueueOverflowException.class, () -> x.enqueue(23));
	}

	@Test
	public void basicTest3() throws QueueOverflowException, QueueUnderflowException {
		T x = getImpl(3);
		x.enqueue(10);
		x.enqueue(123);
		x.enqueue(-3);
		assertEquals(Integer.valueOf(10), x.head());
		assertThrows(QueueOverflowException.class, () -> x.enqueue(23));
		assertEquals(Integer.valueOf(10), x.dequeue());
		x.enqueue(-4);
		assertEquals(Integer.valueOf(123), x.head());
	}

	@Test
	public void basicTest4() throws QueueOverflowException, QueueUnderflowException {
		T x = getImpl(3);
		x.enqueue(10);
		x.enqueue(123);
		x.enqueue(-3);
		assertThrows(QueueOverflowException.class, () -> x.enqueue(23));
		assertEquals(Integer.valueOf(10), x.dequeue());
		assertEquals(Integer.valueOf(123), x.dequeue());
		assertEquals(Integer.valueOf(-3), x.dequeue());
		assertThrows(QueueUnderflowException.class, () -> x.dequeue());
	}

	@Test
	public void basicTest5() throws QueueOverflowException, QueueUnderflowException {
		T x = getImpl(3);
		assertFalse(x.isFull());
		assertTrue(x.isEmpty());

		x.enqueue(10);
		assertFalse(x.isFull());
		assertFalse(x.isEmpty());

		x.enqueue(123);
		x.enqueue(-3);
		assertTrue(x.isFull());
		assertFalse(x.isEmpty());

		x.dequeue();
		assertFalse(x.isFull());
		assertFalse(x.isEmpty());

		x.dequeue();
		x.dequeue();
		assertFalse(x.isFull());
		assertTrue(x.isEmpty());
	}
}

