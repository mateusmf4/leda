package adt.linkedList;

public class RecursiveSingleTest extends StudentLinkedListTest {
	@Override
	protected void getImplementations() {
		lista1 = new RecursiveSingleLinkedListImpl<>();
		lista2 = new RecursiveSingleLinkedListImpl<>();
	}
}