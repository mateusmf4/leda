package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	private int hash(T element, int probe) {
		return ((HashFunctionOpenAddress<T>) hashFunction).hash(element, probe);
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			int i = 0;
			boolean found = false;
			while (!found && i < this.capacity()) {
				int hash = hash(element, i);

				if (table[hash] == null || table[hash].equals(this.deletedElement)) {
					found = true;
					table[hash] = element;
					++elements;
				} else {
					COLLISIONS++;
					++i;
				}
			}
			if (!found)
				throw new HashtableOverflowException();
		}
	}

	@Override
	public void remove(T element) {
		int i = 0;
		boolean found = false;
		while (!found && i < this.capacity()) {
			int hash = hash(element, i);

			if (table[hash] != null && table[hash].equals(element)) {
				found = true;
				table[hash] = deletedElement;
				--elements;
			} else {
				++i;
			}
		}
	}

	@Override
	public T search(T element) {
		int index = indexOf(element);
		T result = null;
		if (index != -1)
			result = (T) table[index];
		return result;
	}

	@Override
	public int indexOf(T element) {
		int result = -1;
		int i = 0;
		while (result == -1 && i < this.capacity()) {
			int hash = hash(element, i);

			if (table[hash] != null && table[hash].equals(element)) {
				result = hash;
			} else {
				++i;
			}
		}
		return result;
	}
}
