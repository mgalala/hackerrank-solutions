import java.io.IOException;
import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/ctci-merge-sort
 * 
 * @author mgalala
 *
 */
public class NumberOfConversion {

	private static long numberOfConversions;

	// Complete the countInversions function below.
	static long countInversions(int[] arr) {
		numberOfConversions = 0;
		if (isSorted(arr)) {
			return 0;
		}
		sort(arr);
		return numberOfConversions;
	}

	public static void sort(int[] a) {
		int[] aux = new int[a.length];
		sort(a, aux, 0, a.length - 1);
		assert isSorted(a);
	}

	private static void sort(int[] a, int[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		// precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);

		// copy to aux[]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		// merge back to a[]
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				numberOfConversions += mid + 1 - i;
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}

		}

		assert isSorted(a, lo, hi);
	}

	private static boolean isSorted(int[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	private static boolean isSorted(int[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	private static boolean less(int v, int w) {
		int compareTo = Integer.valueOf(v).compareTo(Integer.valueOf(w));
		return compareTo < 0;
	}

	public static void main(String[] args) throws IOException {

		int[] arr1 = { 1, 5, 3, 7 };
		int[] arr2 = { 2, 1, 3, 1, 2 };
		System.out.println(Arrays.toString(arr1));
		System.out.println(countInversions(arr1));

		System.out.println(Arrays.toString(arr2));
		System.out.println(countInversions(arr2));
	}
}
