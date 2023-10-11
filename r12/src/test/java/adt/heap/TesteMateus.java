package adt.heap;

public class TesteMateus {
	public static void main(String[] args) {
		Heap<Integer> heap = new HeapImpl<>(Integer::compare);
		heap.insert(82);
		heap.insert(6);
		heap.insert(99);
		heap.insert(12);
		heap.insert(34);
		heap.insert(64);
		heap.insert(58);
		heap.insert(1);

		Heap<Integer> heap2 = new HeapImpl<>(Integer::compare);
		heap2.buildHeap(new Integer[] { 82, 6, 99, 12, 34, 64, 58, 1 });
	}
}
