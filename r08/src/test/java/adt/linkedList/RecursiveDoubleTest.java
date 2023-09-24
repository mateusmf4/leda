package adt.linkedList;

public class RecursiveDoubleTest extends StudentDoubleLinkedListTest {
	@Override
	protected void getImplementations() {
		lista1 = new RecursiveDoubleLinkedListImpl<>();
		lista2 = new RecursiveDoubleLinkedListImpl<>();
		lista3 = new RecursiveDoubleLinkedListImpl<>();
	}
}