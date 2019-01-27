import java.io.IOException;
import java.util.Arrays;

public class MaxLessThanSum {

	// Complete the maximumToys function below.
	static int maximumToys(int[] prices, int k) {
		Arrays.sort(prices);
		int items = 0;

		// To find max_sum less than sum
		for (int i = 0; i < prices.length; i++) {
			if (k - prices[i] >= 0) {
				k = k - prices[i];
				items++;
			}
		}

		return items;
	}

	public static void main(String[] args) throws IOException {

		int[] prices = { 1, 48, 46, 5, 111, 200, 1000, 10 };
		System.out.println(maximumToys(prices, 50));
	}
}
