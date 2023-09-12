package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue10;
	public Queue<Integer> queueCheia;
	public Queue<Integer> queueVazia;

	@Before
	public void setUp() throws QueueOverflowException {
		getImplementations();

		// Fila com 3 elementos não cheia.
		queue10.enqueue(1);
		queue10.enqueue(2);
		queue10.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queueCheia.enqueue(1);
		queueCheia.enqueue(2);
	}

	private void getImplementations() {
		queue10 = new QueueImpl<>(10);
		queueCheia = new QueueImpl<>(2);
		queueVazia = new QueueImpl<>(10);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(Integer.valueOf(1), queue10.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue10.isEmpty());
		assertTrue(queueVazia.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue10.isFull());
	}

	@Test
	public void testEnqueue() throws QueueOverflowException {
		queue10.enqueue(Integer.valueOf(5));
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queueCheia.enqueue(Integer.valueOf(5));
	}

	@Test
	public void testDequeue() throws QueueUnderflowException {
		assertEquals(Integer.valueOf(1), queue10.dequeue());
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(Integer.valueOf(1), queueVazia.dequeue()); 
	}
}