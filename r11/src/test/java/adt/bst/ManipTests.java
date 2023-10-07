package adt.bst;

import static org.junit.Assert.assertFalse;
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
}
