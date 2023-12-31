package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	protected DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		// Lista com 1 elemento.
		lista3.insert(1);
	}

	@Override
	protected void getImplementations() {
		lista1 = new DoubleLinkedListImpl<>();
		lista2 = new DoubleLinkedListImpl<>();
		lista3 = new DoubleLinkedListImpl<>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
	}

	@Test
	public void testEverythingDouble() {
		DoubleLinkedList<Integer> l1 = (DoubleLinkedList<Integer>) lista1;
		l1.removeFirst();
		l1.insertFirst(3);
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
		l1.insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
		l1.removeFirst();
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
		l1.removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
		l1.removeLast();
		Assert.assertArrayEquals(new Integer[] { 2 }, lista1.toArray());
		l1.insert(5);
		Assert.assertArrayEquals(new Integer[] { 2, 5 }, lista1.toArray());
		l1.removeLast();
		Assert.assertArrayEquals(new Integer[] { 2 }, lista1.toArray());
		l1.removeLast();
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		l1.insertFirst(5);
		Assert.assertArrayEquals(new Integer[] { 5 }, lista1.toArray());
		l1.removeFirst();
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		l1.removeFirst();
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		l1.insertFirst(123);
		l1.insert(10);
		l1.insertFirst(456);
		Assert.assertArrayEquals(new Integer[] { 456, 123, 10 }, lista1.toArray());
		l1.removeFirst();
		Assert.assertArrayEquals(new Integer[] { 123, 10 }, lista1.toArray());
		l1.removeFirst();
		Assert.assertArrayEquals(new Integer[] { 10 }, lista1.toArray());
		l1.removeFirst();
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		l1.removeFirst();
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
	}
}