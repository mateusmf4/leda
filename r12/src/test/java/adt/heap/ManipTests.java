package adt.heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import orderStatistic.OrderStatistics;
import orderStatistic.OrderStatisticsHeapImpl;

public class ManipTests {
	OrderStatistics<Integer> getImpl() {
		return new OrderStatisticsHeapImpl<>();
	}

	@Test
	public void testOrderStatistic() {
		OrderStatistics<Integer> impl = getImpl();

		Integer[] values = new Integer[] {67, 53, 50, 35, 30, 51, 55};

		assertEquals(Integer.valueOf(30), impl.getOrderStatistics(values, 1));
		assertEquals(Integer.valueOf(35), impl.getOrderStatistics(values, 2));
		assertEquals(Integer.valueOf(50), impl.getOrderStatistics(values, 3));
		assertEquals(Integer.valueOf(51), impl.getOrderStatistics(values, 4));
		assertEquals(Integer.valueOf(53), impl.getOrderStatistics(values, 5));
		assertEquals(Integer.valueOf(55), impl.getOrderStatistics(values, 6));
		assertEquals(Integer.valueOf(67), impl.getOrderStatistics(values, 7));

		assertNull(impl.getOrderStatistics(values, 0));
		assertNull(impl.getOrderStatistics(values, 8));
		assertNull(impl.getOrderStatistics(values, 10));
		assertNull(impl.getOrderStatistics(values, 90));

		assertNull(impl.getOrderStatistics(values, 0));
		assertNull(impl.getOrderStatistics(values, -1));
		assertNull(impl.getOrderStatistics(values, -10));
	}
}
