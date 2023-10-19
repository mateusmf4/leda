package adt.heap;

import adt.heap.extended.FloorCeilHeap;
import adt.heap.extended.FloorCeilHeapImpl;

public class ExtendedTestsMax extends ExtendedTests {
	@Override
	public FloorCeilHeap getImpl() {
		return new FloorCeilHeapImpl(new ComparatorMaxHeap<>());
	}
}
