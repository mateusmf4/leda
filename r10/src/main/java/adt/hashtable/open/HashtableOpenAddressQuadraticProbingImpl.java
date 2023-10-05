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
		if (element != null && search(element) == null) {
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
		if (element != null) {
			int index = indexOf(element);
			if (index != -1) {
				table[index] = deletedElement;
				--elements;
			}
		}
	}

	@Override
	public T search(T element) {
		T result = null;
		if (element != null) {
			int index = indexOf(element);
			if (index != -1)
				result = (T) table[index];
		}
		return result;
	}

	@Override
	public int indexOf(T element) {
		int result = -1;
		if (element != null) {
			int i = 0;
			while (result == -1 && i < this.capacity()) {
				int hash = hash(element, i);
	
				if (table[hash] != null && table[hash].equals(element)) {
					result = hash;
				} else {
					++i;
				}
			}
		}
		return result;
	}
}
