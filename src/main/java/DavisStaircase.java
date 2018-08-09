import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DavisStaircase {

	// Complete the minimumSwaps function below.
	public static int stepPerms(int n) {
		// recursive solution
		// if (n == 1 || n == 0) {
		// return 1;
		// } else if (n == 2) {
		// return 2;
		// } else {
		// return stepPerms(n - 3) + stepPerms(n - 2) + stepPerms(n - 1);
		// }

		if (n == 1)
			return 1;
		int[] res = new int[n + 1];
		if (n >= 1)
			res[0] = 1;
		if (n >= 2)
			res[1] = 1;
		if (n >= 3)
			res[2] = 2;

		for (int i = 3; i <= n; i++)
			res[i] = res[i - 1] + res[i - 2] + res[i - 3];

		return res[n];
	}

	public static void main(String[] args) throws IOException {
		InputStream is = SpareArraysBruteForce.class.getClassLoader().getResourceAsStream("stairs.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		final Scanner scanner = new Scanner(br);

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int nr = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			int res = stepPerms(nr);
			System.out.println(res);
		}
		scanner.close();
	}

}
