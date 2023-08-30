package problems.test;

import org.junit.Assert;
import org.junit.Test;

import problems.Floor;
import problems.FloorBinarySearchImpl;

public class FloorTest {
	Floor impl = new FloorBinarySearchImpl();

	void genericTest(Integer[] arr, int value, Integer expected) {
		Integer result = impl.floor(arr, value);
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test01() {
		genericTest(new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7 }, 4, 4);
	}

	@Test
	public void test02() {
		genericTest(new Integer[]{ 0, 1, 2, 3, 5, 6, 7 }, 4, 3);
	}

	@Test
	public void test03() {
		genericTest(new Integer[]{ 7, 0, 2, 3, 10, 6 }, 4, 3);
	}

	@Test
	public void test04() {
		genericTest(new Integer[]{ 7, 0, 2, 3, 10, 6 }, 25, 10);
	}

	@Test
	public void test05() {
		genericTest(new Integer[]{ 7, 0, 2, 3, 10, 6 }, -1, null);
	}

	@Test
	public void test06() {
		genericTest(new Integer[]{ -23, -10, 5, 20, 23, 25, 29, 24 }, 28, 25);
	}

	@Test
	public void test07() {
		genericTest(new Integer[]{ -23, -10, 5, 20, 23, 25, 29, 24 }, 0, -10);
	}

	@Test
	public void test08() {
		genericTest(new Integer[]{ -23, -10, 5, 20, 23, 25, 29, 24 }, -10, -10);
	}

	@Test
	public void test09() {
		genericTest(new Integer[]{ 10 }, 1, null);
		genericTest(new Integer[]{ 10 }, 2, null);
		genericTest(new Integer[]{ 10 }, 10, 10);
		genericTest(new Integer[]{ 10 }, 15, 10);
	}

	@Test
	public void test10() {
		genericTest(new Integer[]{ }, 1, null);
		genericTest(new Integer[]{ }, 2, null);
		genericTest(new Integer[]{ }, 3, null);
	}
}
