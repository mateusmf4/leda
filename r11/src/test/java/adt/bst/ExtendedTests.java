package adt.bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import adt.bst.extended.FloorCeilBST;
import adt.bst.extended.FloorCeilBSTImpl;

public class ExtendedTests {
	FloorCeilBST getImpl() {
		return new FloorCeilBSTImpl();
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
