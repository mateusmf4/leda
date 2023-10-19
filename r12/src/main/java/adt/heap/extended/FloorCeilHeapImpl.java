package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		for (Integer x : array) {
			this.insert(x);
		}

		return floorRec(null, numero);
	}

	private Integer floorRec(Integer best, double numero) {
		Integer result = best;
		Integer elem = this.extractRootElement();
		if (elem != null) {
			if (elem <= numero && (best == null || elem > best)) {
				best = elem;
			}
			result = floorRec(best, numero);
		}
		return result;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (Integer x : array) {
			this.insert(x);
		}

		return ceilRec(null, numero);
	}

	private Integer ceilRec(Integer best, double numero) {
		Integer result = best;
		Integer elem = this.extractRootElement();
		if (elem != null) {
			if (elem >= numero && (best == null || elem < best)) {
				best = elem;
			}
			result = ceilRec(best, numero);
		}
		return result;
	}

}
