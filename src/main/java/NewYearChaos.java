import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class NewYearChaos {
	public static void main(String[] args) {

		InputStream is = NewYearChaos.class.getClassLoader().getResourceAsStream("newyearchaos.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		final Scanner scanner = new Scanner(br);

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}

	private static void minimumBribes(int[] q) {
		int expectedValue = 1;
		int numberOfBribes = 0;
		boolean print = true;
		ArrayList<Integer> optimal = new ArrayList<Integer>();
		for (int i = 1; i <= q.length; i++) {
			optimal.add(i);
		}

		for (int i = 1; i <= q.length; i++) {
			int item = q[i - 1];
			if (item != expectedValue) {
				// not in place
				if (item - i > 2) {
					System.out.println("Too chaotic");
					print = false;
					break;
				}
				numberOfBribes = numberOfBribes + optimal.indexOf(Integer.valueOf(item));
			} else {
				expectedValue = expectedValue + 1;
			}

			optimal.remove(Integer.valueOf(item));
			optimal.trimToSize();
		}

		if (print)
			System.out.println(numberOfBribes);
	}
}
