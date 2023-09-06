public class CountGreaterThanImpl implements CountGreaterThan {
	public int countGreater(Integer[] array, Integer x) {
		int result = 0;
		int i = findFirstGreater(array, x, 0, array.length - 1);
		if (i != -1) {
			result = array.length - i;
		}
		return result;
	}

	// Retorna o indice do primeiro numero maior do que x.
	// Se não for encontrado, -1
	private int findFirstGreater(Integer[] array, Integer x, int left, int right) {
		int result = -1;
		if (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid].compareTo(x) <= 0) {
				result = findFirstGreater(array, x, mid + 1, right);
			} else {
				result = mid;
				int lower = findFirstGreater(array, x, left, mid - 1);
				if (lower != -1) {
					result = lower;
				}
			}
		}
		return result;
	}
}