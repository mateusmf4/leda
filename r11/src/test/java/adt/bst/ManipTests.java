package adt.bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ManipTests {
	SimpleBSTManipulation<Integer> getImpl() {
		return new SimpleBSTManipulationImpl<>();
	}

	BST<Integer> createTreeEmpty() {
		return new BSTImpl<>();
	}

	BST<Integer> createTreeSingle() {
		BST<Integer> tree = new BSTImpl<>();
		tree.insert(4);
		return tree;
	}

	BST<Integer> createTreeSingle2() {
		BST<Integer> tree = new BSTImpl<>();
		tree.insert(10);
		return tree;
	}

	BST<Integer> createTree1() {
		BST<Integer> tree = new BSTImpl<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(20);
		return tree;
	}

	BST<Integer> createTree2() {
		BST<Integer> tree = new BSTImpl<>();
		tree.insert(5);
		tree.insert(9);
		return tree;
	}

	BST<Integer> createTree3() {
		BST<Integer> tree = new BSTImpl<>();
		tree.insert(9);
		tree.insert(5);
		return tree;
	}

	BST<Integer> createTree4() {
		BST<Integer> tree = new BSTImpl<>();
		tree.insert(9);
		tree.insert(4);
		return tree;
	}

	BST<Integer> createTreeBig() {
		BST<Integer> tree = new BSTImpl<>();
		tree.insert(10);
		tree.insert(11);
		tree.insert(4);
		tree.insert(3);
		tree.insert(1);
		tree.insert(6);
		tree.insert(5);
		tree.insert(7);
		return tree;
	}

	BST<Integer> createTreeBig2() {
		BST<Integer> tree = new BSTImpl<>();
		tree.insert(20);
		tree.insert(22);
		tree.insert(8);
		tree.insert(6);
		tree.insert(2);
		tree.insert(12);
		tree.insert(10);
		tree.insert(14);
		return tree;
	}

	@Test
	public void testEquals() {
		SimpleBSTManipulation<Integer> impl = getImpl();

		assertTrue(impl.equals(createTreeEmpty(), createTreeEmpty()));
		assertTrue(impl.equals(createTreeSingle(), createTreeSingle()));
		assertTrue(impl.equals(createTreeSingle2(), createTreeSingle2()));
		assertTrue(impl.equals(createTree1(), createTree1()));
		assertTrue(impl.equals(createTree2(), createTree2()));
		assertTrue(impl.equals(createTree3(), createTree3()));
		assertTrue(impl.equals(createTreeBig(), createTreeBig()));

		assertFalse(impl.equals(createTreeEmpty(), createTree1()));
		assertFalse(impl.equals(createTree2(), createTree3()));
		assertFalse(impl.equals(createTree2(), createTree4()));
		assertFalse(impl.equals(createTree3(), createTree4()));

		BST<Integer> t4 = createTreeBig();
		t4.insert(8);
		assertFalse(impl.equals(createTreeBig(), t4));

		assertFalse(impl.equals(createTreeSingle(), createTreeSingle2()));

		assertFalse(impl.equals(createTreeBig(), createTreeBig2()));
	}

	@Test
	public void testSimilar() {
		SimpleBSTManipulation<Integer> impl = getImpl();

		// se são iguais então são similares
		assertTrue(impl.isSimilar(createTreeEmpty(), createTreeEmpty()));
		assertTrue(impl.isSimilar(createTreeSingle(), createTreeSingle()));
		assertTrue(impl.isSimilar(createTreeSingle2(), createTreeSingle2()));
		assertTrue(impl.isSimilar(createTree1(), createTree1()));
		assertTrue(impl.isSimilar(createTree2(), createTree2()));
		assertTrue(impl.isSimilar(createTree3(), createTree3()));
		assertTrue(impl.isSimilar(createTreeBig(), createTreeBig()));

		assertFalse(impl.isSimilar(createTreeEmpty(), createTree1()));
		assertFalse(impl.isSimilar(createTree2(), createTree3()));

		assertTrue(impl.isSimilar(createTree3(), createTree4()));

		assertFalse(impl.equals(createTreeBig(), createTreeBig2()));
		assertTrue(impl.isSimilar(createTreeBig(), createTreeBig2()));

		BST<Integer> t4 = createTreeBig();
		t4.insert(8);
		assertFalse(impl.isSimilar(createTreeBig(), t4));
	}

	@Test
	public void testOrderStatistic() {
		SimpleBSTManipulation<Integer> impl = getImpl();

		BST<Integer> tree = new BSTImpl<>();
		tree.insert(67);
		tree.insert(53);
		tree.insert(50);
		tree.insert(35);
		tree.insert(30);
		tree.insert(51);
		tree.insert(55);

		assertEquals(Integer.valueOf(30), impl.orderStatistic(tree, 1));
		assertEquals(Integer.valueOf(35), impl.orderStatistic(tree, 2));
		assertEquals(Integer.valueOf(50), impl.orderStatistic(tree, 3));
		assertEquals(Integer.valueOf(51), impl.orderStatistic(tree, 4));
		assertEquals(Integer.valueOf(53), impl.orderStatistic(tree, 5));
		assertEquals(Integer.valueOf(55), impl.orderStatistic(tree, 6));
		assertEquals(Integer.valueOf(67), impl.orderStatistic(tree, 7));

		assertNull(impl.orderStatistic(tree, 0));
		assertNull(impl.orderStatistic(tree, 8));
		assertNull(impl.orderStatistic(tree, 10));
		assertNull(impl.orderStatistic(tree, 90));

		BST<Integer> tree2 = createTreeBig();
		Comparable[] arr = tree2.order();
		for (int i = 0; i < arr.length; ++i) {
			assertEquals(arr[i], impl.orderStatistic(tree2, i + 1));
		}
	}
}
