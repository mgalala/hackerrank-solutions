import java.util.Scanner;

public class Solution {

	// Complete the countSwaps function below.
	static void countSwaps(int[] a) {
		int swapCounter = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				// Swap adjacent elements if they are in decreasing order
				if (a[j] > a[j + 1]) {
					swapCounter++;
					swap(a[j], a[j + 1], a);
				}
			}
		}

		System.out.println(" Array is sorted in " + swapCounter + " swaps");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[a.length - 1]);
	}

	static void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		countSwaps(a);

		scanner.close();
	}
}