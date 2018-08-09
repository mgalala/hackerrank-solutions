import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumSwap {

	// Complete the minimumSwaps function below.
	public static int minimumSwaps(int[] arr) {
//		int[] copyOf = Arrays.copyOf(arr, arr.length);
//		Arrays.sort(copyOf);
//		int diff = 0;
//		for (int i = 0; i < copyOf.length; i++) {
//			if (copyOf[i] != arr[i])
//				diff++;
//
//		}
//		return diff - 1;
		
		int arrLen = arr.length;
        int count = 0;
        int [] sarr = arr.clone();
        Arrays.sort(sarr);
        
        for (int i = 0; i < arrLen; i++) {
            if (arr[i] != sarr[i]) {
                count++;
                for (int j = i + 1; j < arrLen; j++) {
                    if (arr[j] == sarr[i] ) {
                        int tmp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = tmp;
                        break;
                    }
                }
            }
        }
        return count;
	}

	public static void main(String[] args) throws IOException {
		InputStream is = SpareArraysBruteForce.class.getClassLoader().getResourceAsStream("minimum_swap.txt");
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

		int res = minimumSwaps(arr);
		System.out.println(res);

		scanner.close();
	}

	static class Pair implements Serializable {

		private Integer key;

		public Integer getKey() {
			return key;
		}

		private Integer value;

		public Integer getValue() {
			return value;
		}

		public Pair(Integer key, Integer value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return key + "=" + value;
		}

		@Override
		public int hashCode() {
			return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o instanceof Pair) {
				Pair pair = (Pair) o;
				if (key != null ? !key.equals(pair.key) : pair.key != null)
					return false;
				if (value != null ? !value.equals(pair.value) : pair.value != null)
					return false;
				return true;
			}
			return false;
		}
	}
}
