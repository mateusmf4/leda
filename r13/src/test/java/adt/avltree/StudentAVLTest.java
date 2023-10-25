package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import adt.bst.BST;
import adt.bst.BSTImpl;
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
		assertTrue(new AVLTreeVerifierImpl<>(avl).isAVLTree());
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

		avl.remove(91);
		verifyAVL();
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

	@Test
	public void testNotAVL() {
		AVLTree<Integer> fake = new FakeAVLTree();
		assertTrue(new AVLTreeVerifierImpl<>(fake).isAVLTree());
		fake.insert(5);
		assertTrue(new AVLTreeVerifierImpl<>(fake).isAVLTree());
		fake.insert(4);
		assertTrue(new AVLTreeVerifierImpl<>(fake).isAVLTree());

		fake.insert(3);
		assertFalse(new AVLTreeVerifierImpl<>(fake).isAVLTree());
		fake.insert(2);
		assertFalse(new AVLTreeVerifierImpl<>(fake).isAVLTree());
		fake.insert(6);
		assertFalse(new AVLTreeVerifierImpl<>(fake).isAVLTree());
		fake.insert(7);
		assertFalse(new AVLTreeVerifierImpl<>(fake).isAVLTree());
		fake.insert(8);
		assertFalse(new AVLTreeVerifierImpl<>(fake).isAVLTree());
	}

	@Test
	public void testIsAVL() {
		AVLTree<Integer> real = new AVLTreeImpl<>();
		assertTrue(new AVLTreeVerifierImpl<>(real).isAVLTree());
		real.insert(5);
		assertTrue(new AVLTreeVerifierImpl<>(real).isAVLTree());
		real.insert(4);
		assertTrue(new AVLTreeVerifierImpl<>(real).isAVLTree());
		
		real.insert(3);
		assertTrue(new AVLTreeVerifierImpl<>(real).isAVLTree());
		real.insert(2);
		assertTrue(new AVLTreeVerifierImpl<>(real).isAVLTree());
		real.insert(6);
		assertTrue(new AVLTreeVerifierImpl<>(real).isAVLTree());
		real.insert(7);
		assertTrue(new AVLTreeVerifierImpl<>(real).isAVLTree());
		real.insert(8);
		assertTrue(new AVLTreeVerifierImpl<>(real).isAVLTree());
	}

	@Test
	public void testNotBST() {
		BST<Integer> fake = new FakeBST();
		assertTrue(new BSTVerifierImpl<>(fake).isBST());
		fake.insert(5);
		assertTrue(new BSTVerifierImpl<>(fake).isBST());
		fake.insert(6);
		assertTrue(new BSTVerifierImpl<>(fake).isBST());

		fake.insert(3);
		assertFalse(new BSTVerifierImpl<>(fake).isBST());
		fake.insert(2);
		assertFalse(new BSTVerifierImpl<>(fake).isBST());
		fake.insert(6);
		assertFalse(new BSTVerifierImpl<>(fake).isBST());
		fake.insert(7);
		assertFalse(new BSTVerifierImpl<>(fake).isBST());
		fake.insert(8);
		assertFalse(new BSTVerifierImpl<>(fake).isBST());
	}

	@Test
	public void testIsBST() {
		BST<Integer> real = new BSTImpl<>();
		assertTrue(new BSTVerifierImpl<>(real).isBST());
		real.insert(5);
		assertTrue(new BSTVerifierImpl<>(real).isBST());
		real.insert(6);
		assertTrue(new BSTVerifierImpl<>(real).isBST());

		real.insert(3);
		assertTrue(new BSTVerifierImpl<>(real).isBST());
		real.insert(2);
		assertTrue(new BSTVerifierImpl<>(real).isBST());
		real.insert(6);
		assertTrue(new BSTVerifierImpl<>(real).isBST());
		real.insert(7);
		assertTrue(new BSTVerifierImpl<>(real).isBST());
		real.insert(8);
		assertTrue(new BSTVerifierImpl<>(real).isBST());
	}

	@Test
	public void testWeird() {
		avl.insert(8);
		verifyAVL();
		avl.insert(4);
		verifyAVL();
		avl.insert(2);
		verifyAVL();
		avl.insert(1);
		verifyAVL();
		avl.insert(3);
		verifyAVL();
		avl.insert(6);
		verifyAVL();
		avl.insert(5);
		verifyAVL();
		avl.insert(7);
		verifyAVL();
		avl.insert(12);
		verifyAVL();
		avl.insert(10);
		verifyAVL();
		avl.insert(9);
		verifyAVL();
		avl.insert(11);
		verifyAVL();
		avl.insert(14);
		verifyAVL();
		avl.insert(13);
		verifyAVL();
		avl.insert(15);
		verifyAVL();
		MateusGraph.printar(avl);
	}
}
