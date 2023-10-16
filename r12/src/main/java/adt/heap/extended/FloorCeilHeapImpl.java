package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		boolean minHeap = this.comparator.compare(0, 1) > 0;

		// Queremos escolher o maior elemento que é menor ou igual a `numero`.
		// Se isso é uma max-heap, então é possivel simplesmente escolher o root,
		// que é o maior elemento da heap. Porem, em uma min-heap, o root será o menor elemento.
		// Portanto, em min-heap, os elementos da array são negados, para que o maior vire o menor.

		for (int x : array) {
			// Só adiciona o valor na heap se é menor ou igual a numero
			if (x <= numero) {
				if (minHeap) {
					this.insert(-x);
				} else {
					this.insert(x);
				}
			}
		}

		Integer result = this.extractRootElement();
		if (minHeap && result != null) {
			result = -result;
		}
		return result;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		boolean minHeap = this.comparator.compare(0, 1) > 0;

		for (int x : array) {
			if (x >= numero) {
				if (minHeap) {
					this.insert(x);
				} else {
					this.insert(-x);
				}
			}
		}

		// Ao contrario do floor, negamos somente na max-heap para que selecione o menor elemento.

		Integer result = this.extractRootElement();
		if (!minHeap && result != null) {
			result = -result;
		}
		return result;
	}

}
