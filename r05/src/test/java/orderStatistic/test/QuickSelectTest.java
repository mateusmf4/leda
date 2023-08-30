package orderStatistic.test;

import org.junit.Assert;
import org.junit.Test;

import orderStatistic.QuickSelect;

public class QuickSelectTest {
	QuickSelect<Integer> impl = new QuickSelect<>();

	void genericTest(Integer[] arr, int k, Integer expected) {
		Integer result = impl.quickSelect(arr, k);
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test01() {
		genericTest(new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7 }, 1, 0);
	}

	@Test
	public void test02() {
		genericTest(new Integer[]{ 0, 1, 2, 3, 5, 6, 7 }, 4, 3);
	}

	@Test
	public void test03() {
		genericTest(new Integer[]{ 7, 0, 2, 3, 10, 6 }, 4, 6);
	}

	@Test
	public void test04() {
		genericTest(new Integer[]{ 7, 0, 2, 3, 10, 6 }, 5, 7);
	}

	@Test
	public void test05() {
		genericTest(new Integer[]{ 7, 0, 2, 3, 10, 6 }, 10, null);
	}

	@Test
	public void test06() {
		genericTest(new Integer[]{ -23, -10, 5, 20, 23, 25, 29, 24 }, 2, -10);
	}

	@Test
	public void test07() {
		genericTest(new Integer[]{ -23, -10, 5, 20, 23, 25, 29, 24 }, 6, 24);
	}

	@Test
	public void test08() {
		genericTest(new Integer[]{ 10 }, 1, 10);
		genericTest(new Integer[]{ 10 }, 2, null);
		genericTest(new Integer[]{ 10 }, 3, null);
	}

	@Test
	public void test09() {
		genericTest(new Integer[]{ }, 1, null);
		genericTest(new Integer[]{ }, 2, null);
		genericTest(new Integer[]{ }, 3, null);
	}
}
