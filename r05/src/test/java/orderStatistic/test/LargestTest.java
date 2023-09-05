package orderStatistic.test;

import org.junit.Assert;
import org.junit.Test;

import orderStatistic.KLargest;
import orderStatistic.KLargestOrderStatisticsImpl;

public class LargestTest {
	KLargest<Integer> impl = new KLargestOrderStatisticsImpl<>();

	void genericTest(Integer[] arr, int k, Integer[] expected) {
		Assert.assertArrayEquals(expected, impl.getKLargest(arr, k));
	}
	
	@Test
	public void test01() {
		genericTest(new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7 }, 1, new Integer[]{ 7 });
	}

	@Test
	public void test02() {
		genericTest(new Integer[]{ 0, 1, 2, 3, 5, 6, 7 }, 4, new Integer[]{ 7, 6, 5, 3 });
	}

	@Test
	public void test03() {
		genericTest(new Integer[]{ 0, 1, 2 }, 3, new Integer[]{ 2, 1, 0 });
		genericTest(new Integer[]{ 0, 1, 2 }, 5, new Integer[]{});
		genericTest(new Integer[]{ 0, 1, 2 }, 4, new Integer[]{});
		genericTest(new Integer[]{ 0, 1, 2 }, 10, new Integer[]{});
	}

	@Test
	public void test04() {
		genericTest(new Integer[]{}, 5, new Integer[]{});
		genericTest(new Integer[]{}, 4, new Integer[]{});
		genericTest(new Integer[]{}, 10, new Integer[]{});
		genericTest(new Integer[]{}, 1, new Integer[]{});
	}

	@Test
	public void testRepeated01() {
		genericTest(new Integer[]{ 1, 1, 1, 2, 3, 4 }, 4, new Integer[]{ 4, 3, 2, 1 });
	}

	@Test
	public void testRepeated02() {
		genericTest(new Integer[]{ 1, 1, 1, 2, 3, 4 }, 5, new Integer[]{ 4, 3, 2, 1, 1 });
	}

	@Test
	public void testRepeated03() {
		genericTest(new Integer[]{ 1, 1, 1, 1 }, 3, new Integer[]{ 1, 1, 1 });
	}
}
