import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumAbsoluteDifference {
	// Complete the minimumAbsoluteDifference function below.
	static int minimumAbsoluteDifference(int[] arr) {
		Arrays.sort(arr);

		Integer minumum = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			minumum = Math.min(minumum, Math.abs(arr[i] - arr[i + 1]));
		}
		return minumum;

	}

	public static void main(String[] args) throws IOException {
		InputStream is = SpareArraysBruteForce.class.getClassLoader().getResourceAsStream("minimum_absolute_value.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		final Scanner scanner = new Scanner(br);

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = minimumAbsoluteDifference(arr);
		StringBuilder bufferedWriter = new StringBuilder();
		bufferedWriter.append(String.valueOf(result));
		bufferedWriter.append("\n");

		System.out.println(bufferedWriter.toString());
		scanner.close();
	}
}
