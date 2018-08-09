import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LocalSolution {

	// Complete the countSwaps function below.
	static void countSwaps(String[] a) {
	}

	static void swap(int[] array) {
	}

	public static void main(String[] args) {
		InputStream is = SpareArraysBruteForce.class.getClassLoader().getResourceAsStream("minimum_absolute_value.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		final Scanner scanner = new Scanner(br);

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(arrItems[i]);
			arr[i] = aItem;
		}

		swap(arr);

		scanner.close();
	}
}