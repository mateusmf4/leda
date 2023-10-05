package adt.hashtable.closed;

import java.util.LinkedList;

import adt.hashtable.hashfunction.HashFunction;
import adt.hashtable.hashfunction.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionFactory;
import util.Util;

public class HashtableClosedAddressImpl<T> extends
		AbstractHashtableClosedAddress<T> {

	/**
	 * A hash table with closed address works with a hash function with closed
	 * address. Such a function can follow one of these methods: DIVISION or
	 * MULTIPLICATION. In the DIVISION method, it is useful to change the size
	 * of the table to an integer that is prime. This can be achieved by
	 * producing such a prime number that is bigger and close to the desired
	 * size.
	 * 
	 * For doing that, you have auxiliary methods: Util.isPrime and
	 * getPrimeAbove as documented bellow.
	 * 
	 * The length of the internal table must be the immediate prime number
	 * greater than the given size (or the given size, if it is already prime). 
	 * For example, if size=10 then the length must
	 * be 11. If size=20, the length must be 23. You must implement this idea in
	 * the auxiliary method getPrimeAbove(int size) and use it.
	 * 
	 * @param desiredSize
	 * @param method
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashtableClosedAddressImpl(int desiredSize,
			HashFunctionClosedAddressMethod method) {
		int realSize = desiredSize;

		if (method == HashFunctionClosedAddressMethod.DIVISION) {
			realSize = this.getPrimeAbove(desiredSize); // real size must the
														// the immediate prime
														// above
		}
		initiateInternalTable(realSize);
		HashFunction function = HashFunctionFactory.createHashFunction(method,
				realSize);
		this.hashFunction = function;
	}

	// AUXILIARY
	/**
	 * It returns the prime number that is closest (and greater) to the given
	 * number.
	 * If the given number is prime, it is returned. 
	 * You can use the method Util.isPrime to check if a number is
	 * prime.
	 */
	int getPrimeAbove(int number) {
		while (!Util.isPrime(number)) {
			++number;
		}
		return number;
	}

	private int hash(T element) {
		return ((HashFunctionClosedAddress<T>) this.hashFunction).hash(element);
	}

	private LinkedList<T> getSlot(int hash) {
		return (LinkedList<T>) table[hash];
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			int hash = this.hash(element);
	
			// checagem para elementos duplicados
			if (table[hash] == null || !getSlot(hash).contains(element)) {
				if (table[hash] == null) {
					table[hash] = new LinkedList<T>();
				} else {
					COLLISIONS++;
				}
				getSlot(hash).add(element);
		
				++elements;
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int index = indexOf(element);
			if (index != -1) {
				getSlot(index).remove(element);
				--elements;
			}
		}
	}

	@Override
	public T search(T element) {
		T result = null;
		if (element != null) {
			int hash = this.hash(element);
			if (table[hash] != null) {
				LinkedList<T> list = getSlot(hash);
				int index = list.indexOf(element);
				if (index != -1)
					result = list.get(index);
			}
		}
		return result;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;
		
		if (element != null) {
			int hash = this.hash(element);
			if (table[hash] != null) {
				if (getSlot(hash).contains(element))
					index = hash;
			}
		}

		return index;
	}

}
