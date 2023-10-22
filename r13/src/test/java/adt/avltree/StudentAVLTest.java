package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

public class StudentAVLTest {

	private AVLTree<Integer> avl;
	private BSTNode<Integer> NIL = new BSTNode<Integer>();

	@Before
	public void setUp() {
		avl = new AVLTreeImpl<>();
	}

	private void verifyAVL() {
		assertTrue(new BSTVerifierImpl<>(avl).isBST());
	}

	@Test
	public void testInit() {
		assertTrue(avl.isEmpty());
		assertEquals(0, avl.size());
		assertEquals(-1, avl.height());
		assertEquals(NIL, avl.getRoot());
		verifyAVL();
	}

	@Test
	public void testInsert() {
		avl.insert(-10);
		assertEquals(1, avl.size());
		assertEquals(0, avl.height());
		assertArrayEquals(new Integer[] { -10 }, avl.preOrder());
		verifyAVL();

		assertFalse(avl.isEmpty());
		assertEquals(new Integer(-10), avl.getRoot().getData());

		avl.insert(-15);
		assertEquals(2, avl.size());
		assertEquals(1, avl.height());
		assertArrayEquals(new Integer[] { -10, -15 }, avl.preOrder());
		verifyAVL();

		avl.insert(20);
		assertEquals(3, avl.size());
		assertEquals(1, avl.height());
		assertArrayEquals(new Integer[] { -10, -15, 20 }, avl.preOrder());
		verifyAVL();
	}

	@Test
	public void testRemove() {
		verifyAVL();
		avl.insert(55);
		verifyAVL();
		avl.insert(9);
		verifyAVL();
		avl.insert(91);
		verifyAVL();
		avl.insert(12);
		verifyAVL();

		avl.remove(-1);
		verifyAVL();
		assertEquals(4, avl.size());

		MateusGraph.printar(avl);
		avl.remove(91);
		verifyAVL();
		MateusGraph.printar(avl);
		assertEquals(3, avl.size());
		assertArrayEquals(new Integer[] { 12, 9, 55 }, avl.preOrder());

		avl.remove(12);
		verifyAVL();
		assertEquals(2, avl.size());
		assertArrayEquals(new Integer[] { 55, 9 }, avl.preOrder());

		avl.remove(9);
		verifyAVL();
		avl.remove(55);
		verifyAVL();
		assertEquals(NIL, avl.getRoot());
		assertTrue(avl.isEmpty());
	}
}
