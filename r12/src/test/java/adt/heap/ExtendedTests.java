package adt.heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import adt.heap.extended.FloorCeilHeap;
import adt.heap.extended.FloorCeilHeapImpl;

public class ExtendedTests {
	public FloorCeilHeap getImpl() {
		return new FloorCeilHeapImpl(new ComparatorMinHeap<>());
	}

	@Test
	public void testFloor1() {
		assertNull(getImpl().floor(new Integer[]{}, 10));
		assertNull(getImpl().floor(new Integer[]{11, 12, 13}, 10));

		assertEquals(Integer.valueOf(10), getImpl().floor(new Integer[]{10, 11, 12, 13}, 10));
		assertEquals(Integer.valueOf(10), getImpl().floor(new Integer[]{1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13}, 10));
		assertEquals(Integer.valueOf(9), getImpl().floor(new Integer[]{1, 7, 8, 2, 3, 4, 6, 9, 11, 12, 13}, 10));
		assertEquals(Integer.valueOf(8), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, 10));

		assertEquals(Integer.valueOf(8), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, 8.0));
		assertEquals(Integer.valueOf(8), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, 8.1));
		assertEquals(Integer.valueOf(8), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, 8.6));
		assertEquals(Integer.valueOf(5), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, 7.9));

		assertEquals(Integer.valueOf(-3), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, -3));
		assertEquals(Integer.valueOf(-3), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, -2.9));
		assertEquals(Integer.valueOf(-3), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, -2.4));
		assertEquals(Integer.valueOf(-3), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, -1));
		assertEquals(Integer.valueOf(-23), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, -3.1));
		assertEquals(Integer.valueOf(-23), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, -3.5));
		assertEquals(Integer.valueOf(-23), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, -4.0));
		assertEquals(Integer.valueOf(-23), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, -20));
		assertEquals(Integer.valueOf(-23), getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, -23));

		assertNull(getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, -23.1));
		assertNull(getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, -23.5));
		assertNull(getImpl().floor(new Integer[]{1, -3, 100, 5, 3, -23, 8}, -24));
	}

	@Test
	public void testCeil1() {
		assertNull(getImpl().ceil(new Integer[]{}, 10));
		assertNull(getImpl().ceil(new Integer[]{7, 8, 9}, 10));

		assertEquals(Integer.valueOf(10), getImpl().ceil(new Integer[]{10, 11, 12, 13}, 10));
		assertEquals(Integer.valueOf(10), getImpl().ceil(new Integer[]{1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13}, 10));
		assertEquals(Integer.valueOf(11), getImpl().ceil(new Integer[]{1, 7, 8, 2, 3, 4, 6, 9, 11, 12, 13}, 10));
		assertEquals(Integer.valueOf(100), getImpl().ceil(new Integer[]{1, -3, 100, 5, 3, -23, 8}, 10));

		assertEquals(Integer.valueOf(100), getImpl().ceil(new Integer[]{1, -3, 100, 5, 3, -23, 8}, 8.1));
		assertEquals(Integer.valueOf(8), getImpl().ceil(new Integer[]{1, -3, 100, 5, 3, -23, 8}, 8.0));
		assertEquals(Integer.valueOf(8), getImpl().ceil(new Integer[]{1, -3, 100, 5, 3, -23, 8}, 7.9));
		assertEquals(Integer.valueOf(8), getImpl().ceil(new Integer[]{1, -3, 100, 5, 3, -23, 8, 7}, 7.9));
		assertEquals(Integer.valueOf(8), getImpl().ceil(new Integer[]{1, -3, 100, 5, 3, -23, 8, 7}, 7.1));
		assertEquals(Integer.valueOf(7), getImpl().ceil(new Integer[]{1, -3, 100, 5, 3, -23, 8, 7}, 7.0));
		assertEquals(Integer.valueOf(7), getImpl().ceil(new Integer[]{1, -3, 100, 5, 3, -23, 8, 7}, 6.99));
	}
}
