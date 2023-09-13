package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack10;
	public Stack<Integer> stackCheia;
	public Stack<Integer> stackVazia;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack10.push(1);
		stack10.push(2);
		stack10.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stackCheia.push(1);
		stackCheia.push(2);
	}

	private void getImplementations() {
		stack10 = new StackImpl<>(10);
		stackCheia = new StackImpl<>(2);
		stackVazia = new StackImpl<>(10);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(Integer.valueOf(3), stack10.top());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack10.isEmpty());
	}

	@Test
	public void testIsFull() {
		// vai depender do tamanho que a pilha foi iniciada!!!!
		assertFalse(stack10.isFull());
	}

	@Test
	public void testPush() throws StackOverflowException {
		stack10.push(Integer.valueOf(5));
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stackCheia.push(Integer.valueOf(5));
	}

	@Test
	public void testPop() throws StackUnderflowException {
		assertEquals(Integer.valueOf(3), stack10.pop());
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		assertEquals(Integer.valueOf(3), stackVazia.pop());
	}

	@Test
	public void testTopNull() {
		assertNull(stackVazia.top());
	}

	@Test
	public void testTopNormal() throws StackUnderflowException {
		assertEquals(Integer.valueOf(2), stackCheia.top());
		assertEquals(Integer.valueOf(2), stackCheia.top());
		assertEquals(Integer.valueOf(3), stack10.top());
		assertEquals(Integer.valueOf(3), stack10.top());
		
		assertEquals(Integer.valueOf(3), stack10.pop());
		assertEquals(Integer.valueOf(2), stack10.top());
		assertEquals(Integer.valueOf(2), stack10.pop());
		assertEquals(Integer.valueOf(1), stack10.top());
		assertEquals(Integer.valueOf(1), stack10.pop());
		assertNull(stack10.top());
		assertThrows(StackUnderflowException.class, () -> stack10.pop());
	}
}